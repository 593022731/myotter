package com.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class CopyOfRootConfig {
	public static void main(String[] args) {

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.qq.com");// ָ����������Email���ʼ�������������
		mailSender.setPort(25);// 587�˿ڰ����ƿ����ã������˿ڲ���
		mailSender.setUsername("593022731@qq.com");// �û���
		mailSender.setPassword("hofufapgtfwxbcci");// ����

		SimpleMailMessage message = new SimpleMailMessage();// ��Ϣ������
		message.setFrom("593022731@qq.com");// ������
		message.setTo("weihui452@163.com");// �ռ���
		message.setSubject("sdfas Ema3il Test");// ����
		message.setText("asdfsdf world222");// ����
		mailSender.send(message);
		System.out.println("�ʼ��������");
	}

}