package com.nil.email.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author lianyou
 * @version 1.0
 * @date 2019/1/1 16:32
 */
@Service
public class EmailService {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  /** 程序启动时注入配置文件的变量 */
  @Value("${spring.mail.username}")
  private String from;

  @Autowired private JavaMailSender mailSender;

  public void sayHello() {
    System.out.println("hello world!!!");
  }

  /**
   * 普通邮件
   *
   * @param to
   * @param subject
   * @param context
   */
  public void sendSimpleMail(String to, String subject, String context) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(from);
    message.setTo(to);
    message.setSubject(subject);
    message.setText(context);

    mailSender.send(message);
  }

  /**
   * html邮件
   *
   * @param to
   * @param subject
   * @param context
   * @throws MessagingException
   */
  public void sendHtmlMail(String to, String subject, String context) {

    logger.info("发送静态邮件开始:{},{},{}", to, subject, context);
    MimeMessage message = mailSender.createMimeMessage();

    MimeMessageHelper helper = null;
    try {
      helper = new MimeMessageHelper(message, true);
      helper.setFrom(from);
      helper.setTo(to);
      helper.setSubject(subject);
      // true指的是html邮件
      helper.setText(context, true);

      mailSender.send(message);
      logger.info("发送静态邮件成功");
    } catch (MessagingException e) {
      logger.info("发送静态邮件失败:" + e);
    }
  }

  /**
   * 发送带附件的邮件
   *
   * @param to
   * @param subject
   * @param context
   * @param filePath
   * @throws MessagingException
   */
  public void sendHAttachmentMail(String to, String subject, String context, String[] filePath) {

    logger.info("发送带附件的邮件开始:{},{},{},{}", to, subject, context, filePath);
    MimeMessage message = mailSender.createMimeMessage();

    MimeMessageHelper helper = null;
    try {
      helper = new MimeMessageHelper(message, true);
      helper.setFrom(from);
      helper.setTo(to);
      helper.setSubject(subject);
      // true指的是html邮件
      helper.setText(context, true);
      for (String path : filePath) {
        FileSystemResource file = new FileSystemResource(new File(path));
        String fileName = file.getFilename();

        helper.addAttachment(fileName, file);
      }
      mailSender.send(message);
      logger.info("发送带附件的邮件成功");
    } catch (MessagingException e) {
      logger.info("发送带附件的邮件失败:" + e);
    }
  }

  /**
   * 图片邮件
   *
   * @param to
   * @param subject
   * @param context
   * @param rscPath
   * @param rscId
   */
  public void sendInlineResourceMail(
      String to, String subject, String context, String rscPath, String rscId) {
    logger.info("发送图片邮件开始:{},{},{},{}", to, subject, context, rscPath, rscId);
    MimeMessage message = mailSender.createMimeMessage();

    MimeMessageHelper helper = null;
    try {
      helper = new MimeMessageHelper(message, true);
      helper.setFrom(from);
      helper.setTo(to);
      helper.setSubject(subject);
      // true指的是html邮件
      helper.setText(context, true);

      FileSystemResource res = new FileSystemResource(new File(rscPath));
      helper.addInline(rscId, res);

      mailSender.send(message);
      logger.info("发送图片邮件成功");
    } catch (MessagingException e) {
      logger.info("发送图片邮件失败:" + e);
    }
  }
}
