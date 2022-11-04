package minjae._common;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import minjae.dto.UserFind;

public class JavaMail {
	
	public void sendAuthEmail(UserFind userfind) {
		final String host = "smtp.naver.com";
		final String user = "cmcteam1@naver.com"; //발신자의 이메일 아이디를 입력
		final String password = "Cmcteam1!";         //발신자 이메일의 패스워드를 입력
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", host); 
		prop.put("mail.smtp.port", 587); 
		prop.put("mail.smtp.auth", "true"); 
//		prop.put("mail.smtp.ssl.enable", "true"); 
//		prop.put("mail.smtp.ssl.trust", "smtp.naver.com");
		
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			
			// 수신자 메일 주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(userfind.getEmail()));
			
			// 메일 제목
			message.setSubject("코딩산악회 아이디 찾기 인증번호");
			
			// 메일 내용
			String msgText = "<h1>코딩산악회 본인인증 이메일</h1>";
			msgText += "<hr><br>";
			msgText += "<p>인증번호 - " + userfind.getAuthno() + "</p>";
//			System.out.println(userfind.getAuthno());
//			message.setText("test");
			message.setContent(msgText, "text/html; charset=utf-8");
			
			// send the message
			Transport.send(message); //전송
			System.out.println("message send successfully...");
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
}
