/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PQ_CONTROLADORES;

import PQ_VENTANAS.FMR_Message;
import PQ_VENTANAS.FRM_Login;
import PQ_VENTANAS.FRM_Prueba;
import PQ_VENTANAS.MDI_PRINCIPAL;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.apache.commons.net.time.TimeTCPClient;

/**
 *
 * @author wilfredo
 */
public class InitClass {
    public static void main(String[]args){
        CLS_Controlador control = new CLS_Controlador();
        control.Base.Conectar();
        String mac = getMac();
        String username= System.getProperty("user.name");
        
        String _exists = control.RetornarConsulta("SELECT count(*) FROM empresa_equipos WHERE mac ='"+mac+"' and username='"+username+"'",1);
        System.out.println("Su direccion mac es :" +mac);
        System.out.println("Su nombre de usuario es :" +username);
        
        if("1".equals(_exists)){
        long tryTimeDifference = 0;
        
        //Configuracion prueba
        boolean _tryPhase = true;
        //
        String r_prueba = control.RetornarConsulta("select ce.start_prueba from configuracion_empresa ce inner join empresa_equipos ee on ce.idconfiguracion_empresa=ee.idconfiguracion_empresa where ee.mac='"+mac+"' and ee.username = '"+username+"';",1);
//        System.out.print(getDateInternet());
        String r_fecha = control.RetornarConsulta("select ce.fecha_prueba from configuracion_empresa ce inner join empresa_equipos ee on ce.idconfiguracion_empresa=ee.idconfiguracion_empresa where ee.mac='"+mac+"' and ee.username = '"+username+"';",1);
        
        System.out.println("Etapa de prueba? (1)SI (0)NO: "+ r_prueba);
        System.out.println("Fecha establecida: "+ r_fecha);
        try {
            
            if(r_prueba == null || r_fecha == null || r_prueba.isEmpty() || r_fecha.isEmpty()){
                String msg = "Usted no está registrado en el sistema.";
                FMR_Message mensaje = new FMR_Message(msg);
                mensaje.setVisible(true);
            }else{
                if(r_prueba.equals("1")){
                    _tryPhase = true;
                    Date dateInit=new SimpleDateFormat("yyyy-MM-dd").parse(r_fecha);
                    
                    //System.out.print(getDateInternet()+"  "+dateInit);
                    //
                    if((getDateInternet().getTime()/1000000) >=(dateInit.getTime()/1000000)-80){
                        Long tryTime = getDateInternet().getTime() - dateInit.getTime();
                        TimeUnit time = TimeUnit.DAYS;
                        tryTimeDifference = time.convert(tryTime,TimeUnit.MILLISECONDS);
                    }else{
                        tryTimeDifference = -1;
                    }
                }
                if(r_prueba.equals("0")){
                    _tryPhase = false;
                }
                //
                if(_tryPhase){
                    FRM_Prueba prueba = new FRM_Prueba(tryTimeDifference);
                    prueba.setVisible(true);
                }else{
                    try {
//                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                    if ("Nimbus".equals(info.getName())) {
//                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                        break;
//                    }
//                }
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(MDI_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(MDI_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(MDI_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(MDI_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                    FRM_Login login = new FRM_Login("");
                    login.setVisible(true);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(InitClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            String msg = "Usted no está registrado en el sistema.";
            FMR_Message mensaje = new FMR_Message(msg);
            mensaje.setVisible(true);
        }
    }
    
    public static Date getDateInternet(){
        List<String> hosts = Arrays.asList("0.south-america.pool.ntp.org","1.south-america.pool.ntp.org",
            "2.south-america.pool.ntp.org","3.south-america.pool.ntp.org","hora.roa.es");
        NTPUDPClient client = new NTPUDPClient();
        for(String h: hosts){
            client.setDefaultTimeout(10000);
            try {
                InetAddress hostAddr = InetAddress.getByName(h);
                TimeInfo info = client.getTime(hostAddr);
                Date date = new Date(info.getReturnTime());
                if(date != null){
                    client.close();
                    return date;
                }
                
            } catch (java.net.SocketException exp) {
                exp.printStackTrace();
            } catch(java.io.IOException exp){
                exp.printStackTrace();
            }
        }
        client.close();
        return null;
    }
    
    public static String getMac() {
        try{
            InetAddress localHost = InetAddress.getLocalHost();
        NetworkInterface ni = NetworkInterface.getByInetAddress(localHost);
        byte[] hardwareAddress = ni.getHardwareAddress();
        String[] hexadecimal = new String[hardwareAddress.length];
        for (int i = 0; i < hardwareAddress.length; i++) {
            hexadecimal[i] = String.format("%02X", hardwareAddress[i]);
        }
        String macAddress = String.join("-", hexadecimal);
        return macAddress;
        }catch(UnknownHostException e){
            return "";
        }catch(SocketException s){
            return "";
        }
    }
    
}
