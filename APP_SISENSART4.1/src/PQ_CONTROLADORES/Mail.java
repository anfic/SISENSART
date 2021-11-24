/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PQ_CONTROLADORES;
import java.util.Date;
import javax.mail.Message;
import javax.mail.Session;
import java.util.Properties;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.swing.JOptionPane;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;
/**
 *
 * @author Construcctora LMS
 */
public class Mail
{
    JOptionPane dlg=new JOptionPane();
    private String from = "";//tu_correo@gmail.com
    private String password = "";//tu password: 123456
    // destinatario1@hotmail.com,destinatario2@hotmail.com, destinatario_n@hotmail.com
    private InternetAddress[] addressTo;
    private String Subject = "";//titulo del mensaje
    private String MessageMail = "";//contenido del mensaje

    public Mail(){}

    public void SEND()
    {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.mail.yahoo.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.user", "usuario");
            props.put("mail.smtp.port", 587);//puerto hotmail
            //
            SMTPAuthenticator auth = new SMTPAuthenticator( getFrom(), getPassword() );
            Session session = Session.getDefaultInstance(props, auth);
            session.setDebug(false);
            //Se crea destino y origen del mensaje
            MimeMessage mimemessage = new MimeMessage(session);
            InternetAddress addressFrom = new InternetAddress( getFrom() );
            mimemessage.setFrom(addressFrom);
            mimemessage.setRecipients(Message.RecipientType.TO, addressTo);
            mimemessage.setSubject( getSubject() );
            // Se crea el contenido del mensaje
            MimeBodyPart mimebodypart = new MimeBodyPart();
            mimebodypart.setText( getMessage() );
            mimebodypart.setContent( getMessage() , "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimebodypart);
            mimemessage.setContent(multipart);
            mimemessage.setSentDate(new Date());
            Transport.send(mimemessage);
            JOptionPane.showMessageDialog(null, "MENSAJE ENVIADO EXITOSAMENTE.\nMAXTER GYM");        } catch (MessagingException ex) {
            System.out.println(ex);
            dlg.showMessageDialog(null,ex.getMessage());
        }

    }
    //remitente
    public void setFrom(String mail){ this.from = mail; }
    public String getFrom(){ return this.from; }
    //Contraseña
    public void setPassword(String valor){
        this.password = valor;
    }
    public String getPassword(){ return this.password; }
    //destinatarios
    public void setTo(String mails){
        String[] tmp =mails.split(",");
        addressTo = new InternetAddress[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            try {
                addressTo[i] = new InternetAddress(tmp[i]);
            } catch (AddressException ex) {
                System.out.println(ex);
            }
        }
    }
    public InternetAddress[] getTo(){ return this.addressTo; }
    //titulo correo
    public void setSubject(String value){ this.Subject = value; }
    public String getSubject(){ return this.Subject; }
    //contenido del mensaje
    public void setMessage(String value){ this.MessageMail = value; }
    public String getMessage(){ return this.MessageMail; }
    /**
     * <strong>Nota:</strong>Este método permite enviar un correo electrónico.
     *<strong>Parametros:</strong> CorreoEmisor, Password, CorreoReceptor, NombreMensaje, Mensaje.
     *<p><strong>CorreoEmisor:</strong> Es el correo de donde se envia el mensaje (debe ser de yahoo); EJEMPLO: correo@yahoo.es
     *<p><strong>Password:</strong> Es la contraseña del CorreoEmisor.
     *<p><strong>CorreoReceptor:</strong> Es correo que recibe el mensaje enviado (puede ser cualquier correo); EJEMPLO: correoreceptor@gmail.com.
     * <p><strong>NombreMensaje:</strong> Etiqueta del Mensaje.
     * <p><strong>Mensaje:</strong> Es el mensaje en si del correo.
     */
    public void EnviarCorreo(String CorreoEmisor,String Password,String CorreoReceptor,String NombreMensaje,String Mensaje)
    {
        setFrom( CorreoEmisor);//EMISOR
        setPassword(Password );//PASSWORD  
        setTo(CorreoReceptor);//RECEPTOR
        setSubject( NombreMensaje );//ETIQUETA
        setMessage(Mensaje);//MENSAJE
        SEND();
    }
}
