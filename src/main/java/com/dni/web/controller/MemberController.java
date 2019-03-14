package com.dni.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dni.web.entity.Member;
import com.dni.web.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("join")
	public String join(Model model) {
		return "member.join";
	}

	@GetMapping("email-duplicated-error")
	@ResponseBody
	public String emailDuError() {
		return "<script>alert('이미 가입된 이메일입니다.'); location.href = './join-email';</script>";
	}
	
	@GetMapping("join-invalide-error")
	@ResponseBody
	public String joinInvalideError() {
		return "<script>alert('계산식이 올바르지 않습니.'); location.href = './join-reg';</script>";
	}	
	
	@GetMapping("is-id-duplicated")
	@ResponseBody
	public String isIdDuplicated(@RequestParam(value="id", defaultValue="") String id) {
		
		boolean duplicated = service.isIdDuplicated(id);
		if(duplicated)
			return "true";
		
		return "false";
	}
	
	@GetMapping("join-email")
	public String joinEmail() {
		
		return "member.join-email";
	}	
	
	@PostMapping("join-email")
	public String joinEmail(String email, HttpServletResponse response) {
	
		boolean duplicated = service.isEmailDuplicated(email);
		
		if(duplicated)
			return "redirect:email-duplicated-error";
		
		/*-----------------*/
		UUID uuid = UUID.randomUUID();
		MessageDigest salt = null;
		String digest = null;
		
		
		try {
			salt = MessageDigest.getInstance("SHA-256");
			salt.update(uuid.toString().getBytes());
			//문자열을 계속 더하기 할 때 StringBuilder를 쓴다 [String는 뒤를 찾는 속도가 있어서]
			byte[] key = salt.digest();
			//바이트열을 문자열로 바꾸기 위해서 더하기가 반복되어야한다.
			StringBuilder builder = new StringBuilder();
			for(byte b : key)
				builder.append(String.format("%02x", b)); //16진수로 포멧
			
			digest = builder.toString();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		
		Cookie cookie = new Cookie("joinId", digest);
		cookie.setPath("/member/");
		cookie.setMaxAge(60*60*24); //초/분/시간
		
		response.addCookie(cookie);
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom("devbogo@gmail.com");
			helper.setTo(email);
			helper.setSubject("DNI 회원가입을 위한 인증메일");
			helper.setText("<a href=\"http://localhost:8080/member/join-reg?id="+digest+"&em="+email+"\">가입 링크</a>test", true);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// URI 방식
		/*
		 * book/1 
		 * /book?id=1
		 * 
		 */
		
		mailSender.send(message);
		
		return "member.join-email-info";
	}	

	@GetMapping("join-reg")
	public String joinReg(@RequestParam(value="id", defaultValue="") String key
			, @RequestParam(value="em", defaultValue="test@email.com") String email
			, @CookieValue(value="joinId", defaultValue="") String joinId
			, Model model) {
		
		
		if(joinId.equals("") || joinId.equals("") || !key.equals(joinId) || email.equals(""))
			return "mebmer.join-error";
		
		String uid = email.split("@")[0];
		model.addAttribute("uid", uid);
		model.addAttribute("email", email);
		
		//이메일 중복 & 사진 
		return "member.join-reg";
	}
	
	@PostMapping("join-reg")
	public String joinReg(Member member
			, @RequestParam("photo-file") MultipartFile photoFile
			, Integer moonjage
			, HttpServletRequest request) throws IOException {
		
		HttpSession session = request.getSession();
		Integer moonjageSaved = (Integer) session.getAttribute("moonjage"); 
		if(moonjage != moonjageSaved)
			return "member.join-invalide-error";
		
		String userId = member.getId();
		String resLocation ="/resources/users/"+userId+"/";
		
		ServletContext context = request.getServletContext();
		String homeDir = context.getRealPath(resLocation);
		String uploadedFileName = photoFile.getOriginalFilename();
		
		// File.separator =>unix인지 windows인지 동적으로 알아내고 경로를 잘 맞춰줌 
		String filePath = homeDir + uploadedFileName;
		
		//경로가 존재하는지?
		File dir = new File(homeDir);
		
		if(!dir.exists())
			dir.mkdirs();
		
		
		InputStream fis = photoFile.getInputStream();
		FileOutputStream fos = new FileOutputStream(filePath);
		
        byte[] buf = new byte[1024];
        int size = 0;
        while((size = fis.read(buf,0,buf.length)) > 0)
            fos.write(buf,0,size);
        
        fis.close();
        fos.close();
        
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPwd = encoder.encode(member.getPwd());
        
        member.setPhoto(uploadedFileName);
        member.setPwd(encodedPwd);
        
        service.addMember(member);
        
		return "redirect:../index";
	}

	@GetMapping("rest-pwd")
	public String restPwd() {
		return "member.rest-pwd";
	}	
	
	@PostMapping("rest-pwd")
	public String restPwd(String id) {
		
		Member member = service.getMember(id);
		
		if(member == null)
			return "redirect:join-error";
		
		String email = member.getEmail();
		
		UUID uuid = UUID.randomUUID();
		MessageDigest salt = null;
		String digest = null;
		
		/*--------- unique key generating ---------*/
		try {
			salt = MessageDigest.getInstance("SHA-256");
			salt.update(uuid.toString().getBytes());
			//문자열을 계속 더하기 할 때 StringBuilder를 쓴다 [String는 뒤를 찾는 속도가 있어서]
			byte[] key = salt.digest();
			//바이트열을 문자열로 바꾸기 위해서 더하기가 반복되어야한다.
			StringBuilder builder = new StringBuilder();
			for(byte b : key)
				builder.append(String.format("%02x", b)); //16진수로 포멧
			
			digest = builder.toString();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		
		/*------- email sending --------------*/
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom("devbogo@gmail.com");
			helper.setTo(email);
			helper.setSubject("DNI 회원가입을 위한 인증메일");
			helper.setText("<a href=\"http://localhost:8080/member/pwd-reg?id="+digest+"&em="+email+"\">가입 링크</a>test", true);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		mailSender.send(message);
		
		
		return "redirect:?";
	}	
	
	
	@GetMapping("login")
	public String login() {
		return "member.login";
	}	
}