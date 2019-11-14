package com.edu.freemarker;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import bsh.This;
import bsh.util.Sessiond;

public class SendMail {
//	static String from=null;
//	static String code=null;
//	static String to=null;
	public static void sendMail() throws Exception{
		//1、创建properties对象
		Properties properties =new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.host", "smtp.126.com");
		properties.put("mail.smtp.auth", true);
		InputStream in = new BufferedInputStream(new FileInputStream("conf/db.properties"));  
        properties.load(in);
		String from=properties.getProperty("from");
//		System.out.println(from);
		String code=properties.getProperty("code");
		String to=properties.getProperty("to");
		//2、Session对象，设置发件箱、授权码
		Session session=Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from,code);
			}
		});
		//3、Message对象设置，发件人，收件人，主题，正文
		Message message=new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Hello World!");
			message.setText("实训");
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		sendMail();
	}
}
