package Demo;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {
    public static void Email(String receiver, String content) throws AddressException, MessagingException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "smtp.qq.com");
        properties.put("mail.smtp.port", 465);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        Session session = Session.getInstance(properties);
        session.setDebug(true);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("1319161135@qq.com"));
        InternetAddress to = new InternetAddress(receiver);
        message.setRecipient(MimeMessage.RecipientType.TO, to);
        message.setSubject("TBlog");
        message.setText(content);
        Transport transport = session.getTransport();
        transport.connect("1319161135@qq.com", "tucmgflrxaifjdfh");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
