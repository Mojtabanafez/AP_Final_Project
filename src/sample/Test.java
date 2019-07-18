package sample;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

class EmailSender {

    public static void main(String[] args) {
        String recipient = "t.abedini77@gmail.com";
        String sender = "nafezmojtan@gmail.com";
        String host = "localhost";

        Properties properties = System.getProperties();
        properties.setProperty( "mail.smtp.host", host );
        Properties prop=System.getProperties();
//prop.put("mail.smtp.host", "destinationHost");       //Before the Could not connect to port 25 error msg

        prop.put("mail.smtp.host", "localhost");       //Works well
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Hello World!");

            message.setContent("<h1>Message Header</h1>" +
                    "<p>This is a paragraph </p>" +
                    "<p>This is another paragraph</p>", "text/html");

            Transport.send(message);

        } catch (AddressException e){
            e.printStackTrace();
        } catch (MessagingException e){
            e.printStackTrace();
        }
    }
}