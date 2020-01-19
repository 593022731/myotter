package com.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class RootConfig {
	public static void main(String[] args) {

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.126.com");// 指定用来发送Email的邮件服务器主机名
		mailSender.setPort(25);// 默认端口，标准的SMTP端口
		mailSender.setUsername("wuyun_otter@126.com");// 用户名
		mailSender.setPassword("dev123");// 密码

		SimpleMailMessage message = new SimpleMailMessage();// 消息构造器
		message.setFrom("wuyun_otter@126.com");// 发件人
		message.setTo("weihui452@163.com");// 收件人
		message.setSubject("sdfas Ema3il Test");// 主题
		message.setText("asdfsdf world222");// 正文
		mailSender.send(message);
		System.out.println("邮件发送完毕");
	}

}