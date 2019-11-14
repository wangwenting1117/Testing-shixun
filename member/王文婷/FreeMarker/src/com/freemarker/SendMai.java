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
//	static String from="wangwenting1117@126.com";//�����ʼ���һ��
//	static String to="1433837332@qq.com";//���ʼ���һ��
//	static String code="web0805";//��Ȩ��
	
	public static void main(String[] args) throws AddressException, MessagingException, IOException {
		// TODO Auto-generated method stub
		//1.����Properties����
		Properties prop=new Properties();
		prop.setProperty("mail.host", "smtp.126.com"); //// ����126�ʼ�������
        prop.setProperty("mail.transport.protocol", "smtp"); // �ʼ�����Э��
        prop.setProperty("mail.smtp.auth", "true"); // ��Ҫ��֤�û�������
        //�������� ��ȡ�����ļ��е�����
        String filepath="conf/mail.properties";//·��
        InputStream in = new BufferedInputStream(new FileInputStream(filepath));  
        prop.load(in);
        
        String from=prop.getProperty("sender_name");//�����ʼ���һ��
    	String to=prop.getProperty("receiver_name");//���ʼ���һ��
    	String code=prop.getProperty("code");//��Ȩ��
		//2.����  ��������Ӧ�ó�������Ļ�����Ϣ  session����
		Session session=Session.getDefaultInstance(prop, new Authenticator(){
			//PasswordAuthentication ������֤
			public PasswordAuthentication getPasswordAuthentication(){
				//�����������û�������Ȩ��
				return new PasswordAuthentication(from,code);
			}
		});
		//3.�����ʼ� message����
		MimeMessage message=new MimeMessage(session);
		//�����ʼ��Ļ�����Ϣ ������ �ռ��� ����
		message.setFrom(new InternetAddress(from));//������
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject("����");
		message.setText("Hello World");
		//4.�����ʼ� transport����
		Transport tr=session.getTransport();
		tr.send(message);
		System.out.println("С���ѽ��գ�");
	}

}