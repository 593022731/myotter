package com.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class RootConfig {
	public static void main(String[] args) {

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.126.com");// ָ����������Email���ʼ�������������
		mailSender.setPort(25);// Ĭ�϶˿ڣ���׼��SMTP�˿�
		mailSender.setUsername("wuyun_otter@126.com");// �û���
		mailSender.setPassword("dev123");// ����

		SimpleMailMessage message = new SimpleMailMessage();// ��Ϣ������
		message.setFrom("wuyun_otter@126.com");// ������
		message.setTo("weihui452@163.com");// �ռ���
		message.setSubject("sdfas Ema3il Test");// ����
		message.setText("asdfsdf world222");// ����
		mailSender.send(message);
		System.out.println("�ʼ��������");
	}

}