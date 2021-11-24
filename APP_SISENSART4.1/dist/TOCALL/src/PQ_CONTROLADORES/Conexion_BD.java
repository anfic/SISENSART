/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PQ_CONTROLADORES;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDY
 */
public class Conexion_BD
{
    public  PreparedStatement prest=null;
    public  CallableStatement cllst=null;
    public ResultSetMetaData rsm=null;
    public static Connection conec=null;
    public  Connection conec1=null;
    public  Statement st=null;
    public  Statement st2=null;
    public  ResultSet rt=null; 
    public  ResultSet rt2=null;
    public  String usu;
    public  String contrasena; 
    public  String host;
    public  String db;
    public String URL=null;
    public void Conectar() 
    {
        try
        {
////            Ingreso Remoto desde host
//            usu="construc_anfic";
//            contrasena="18101987";
//            host="www.constructoramls.com";
//            db="construc_rrhh_v3";
            
            usu="root";
            contrasena="";
            host="localhost";
            db="bd_rrhh_v4";
            URL="jdbc:mysql://"+host+"/"+db;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conec=DriverManager.getConnection(URL, usu, contrasena);
            if(conec!=null)
            {
//                JOptionPane.showMessageDialog(null, "Coneccion a base de datos "+db+" listo");
                System.out.println("Coneccion a base de datos "+db+" listo");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        System.gc();
    }
    public void ConectarDinamyc(String us,String clv,String hs,String bs)
    {
        try
        {
            usu=us;contrasena=clv;host=hs;
            db=bs; String url="jdbc:mysql://"+host+"/"+db;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conec=DriverManager.getConnection(url, usu, contrasena);
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
    }
    public Connection getConnection()
    {
        return conec;
    }    
}