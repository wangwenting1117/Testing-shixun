package com.freemarker;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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

public class SendMai {
//	static String from="wangwenting1117@126.com";//发送邮件的一方
//	static String to="1433837332@qq.com";//收邮件的一方
//	static String code="web0805";//授权码
	
	public static void main(String[] args) throws AddressException, MessagingException, IOException {
		// TODO Auto-generated method stub
		//1.创建Properties对象
		Properties prop=new Properties();
		prop.setProperty("mail.host", "smtp.126.com"); //// 设置126邮件服务器
        prop.setProperty("mail.transport.protocol", "smtp"); // 邮件发送协议
        prop.setProperty("mail.smtp.auth", "true"); // 需要验证用户名密码
        //建立连接 读取配置文件中的数据
        String filepath="conf/mail.properties";//路径
        InputStream in = new BufferedInputStream(new FileInputStream(filepath));  
        prop.load(in);
        
        String from=prop.getProperty("sender_name");//发送邮件的一方
    	String to=prop.getProperty("receiver_name");//收邮件的一方
    	String code=prop.getProperty("code");//授权码
		//2.创建  定义整个应用程序所需的环境信息  session对象
		Session session=Session.getDefaultInstance(prop, new Authenticator(){
			//PasswordAuthentication 密码认证
			public PasswordAuthentication getPasswordAuthentication(){
				//发件人邮箱用户名，授权码
				return new PasswordAuthentication(from,code);
			}
		});
		//3.创建邮件 message对象
		MimeMessage message=new MimeMessage(session);
		//设置邮件的基本信息 发件人 收件人 内容
		message.setFrom(new InternetAddress(from));//发件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject("测试");
		message.setText("Hello World");
		//4.发送邮件 transport对象
		Transport tr=session.getTransport();
		tr.send(message);
		System.out.println("小白已接收！");
	}

}