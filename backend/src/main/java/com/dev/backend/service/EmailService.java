package com.dev.backend.service;

import freemarker.template.Configuration;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    @Value("${spring.mail.username}")
    private String remetente;

    @Autowired
    private Configuration fmConfiguration;
    
    public String enviarEmailTexto(String destinatario, String titulo, String mensagem) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(remetente);
            simpleMailMessage.setTo(destinatario);
            simpleMailMessage.setSubject(titulo);
            simpleMailMessage.setText(mensagem);

            javaMailSender.send(simpleMailMessage);
            
            return "Email enviado";

        } catch (Exception ex) {
            return "Erro ao envioar o email";
        }
    }

    public void enviarEmailTemplate(String destinatario, String titulo, Map<String, Object> propriedades) {
        MimeMessage mimeMessage =javaMailSender.createMimeMessage();
           try {
    
               MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

               mimeMessageHelper.setSubject(titulo);
               mimeMessageHelper.setFrom(remetente);
               mimeMessageHelper.setTo(destinatario);
               
               mimeMessageHelper.setText(getConteudoTemplate(propriedades), true);
    
               javaMailSender.send(mimeMessageHelper.getMimeMessage());
           } catch (MessagingException e) {
               e.printStackTrace();
           }
       }
    
       public String getConteudoTemplate(Map < String, Object >model)     { 
           StringBuffer content = new StringBuffer();
    
           try {
               content.append(FreeMarkerTemplateUtils.processTemplateIntoString(fmConfiguration.getTemplate("email-recuperacao-codigo.flth"), model));
           } catch (Exception e) {
               e.printStackTrace();
           }
           return content.toString();
       }    
}
