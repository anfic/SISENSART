/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PQ_CONTROLADORES;

/**
 *
 * @author ClarK
 */

import java.util.*;
import javax.swing.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
public class Reportes
{
    Conexion_BD cnx=new Conexion_BD();
    public String rta;
    public String rta1="src\\PQ_REPORTES\\";
    public void Ver_Reportes(String nmbrpte)
    {
        JasperPrint reporte_view;
        try
        {
            rta=rta1+nmbrpte;
             Map  parametros = new HashMap();
             parametros.clear();
             parametros.put("","");
             //-----------------------------------          
             reporte_view= JasperFillManager.fillReport(rta, parametros, cnx.getConnection());
             JasperViewer.viewReport( reporte_view , false);
	  }catch (JRException E)
          {
              JOptionPane.showMessageDialog(null,E.getMessage());
          }
        System.gc();
       }
    public void Ver_Reporte_Parametro(String nombre_parametro,String parametro,String nmbrpte)
     {
         JasperPrint reporte_view;
         try
         {
             rta=rta1+nmbrpte;
             Map  parametros = new HashMap();
             parametros.clear();
             parametros.put(nombre_parametro,parametro);
             //-----------------------------------          
             reporte_view= JasperFillManager.fillReport(rta, parametros, cnx.getConnection() );
             JasperViewer.viewReport( reporte_view , false);
             //terminamos la conexion a la base de datos
	  }catch (JRException E)
          {
              JOptionPane.showMessageDialog(null,E.getMessage());
          }
         System.gc();
       }
    public void Ver_Reporte_Con3Parametros_imagen(String nombre_parametro1,String nombre_parametro2,String nombre_parametro3,String parametro1,String parametro2,String parametro3,String nmbrpte,String nombre_logo,String Direccion_logo)
     {
     JasperPrint reporte_view;
     try
     {
         rta=rta1+nmbrpte;
          Map  parametros = new HashMap();
          parametros.clear();
          parametros.put(nombre_parametro1,parametro1);
          parametros.put(nombre_parametro2,parametro2);
          parametros.put(nombre_parametro3,parametro3);
          parametros.put(nombre_logo,this.getClass().getResourceAsStream(Direccion_logo));
          //-----------------------------------          
          reporte_view= JasperFillManager.fillReport(rta, parametros, cnx.getConnection() );
          JasperViewer.viewReport( reporte_view , false);
          //terminamos la conexion a la base de datos
	  }catch (JRException E)
          {
              JOptionPane.showMessageDialog(null,E.getMessage());
          }
     System.gc();
       }
    public void Reporte_1Parametro_Imagen(String nombre_reporte,String nomparametro1,String param1,String nombre_logo,String Direccion_logo)
    {
        JasperPrint reporte_view;
        try
        {
            rta=rta1+nombre_reporte;
            Map  parametros = new HashMap();
            parametros.clear();
            parametros.put(nomparametro1,param1);
            parametros.put(nombre_logo,this.getClass().getResourceAsStream(Direccion_logo));
            //-----------------------------------          
            reporte_view= JasperFillManager.fillReport(rta, parametros, cnx.getConnection() );
            JasperViewer.viewReport( reporte_view , false);
            //terminamos la conexion a la base de datos
	  }catch (JRException E)
          {
              E.printStackTrace();
              JOptionPane.showMessageDialog(null,E.getMessage()+": "+nombre_reporte);
          }
          System.gc();
    }
    public void Reporte_1Parametro(String nombre_reporte,String nomparametro1,String param1)
    {
        JasperPrint reporte_view;
        try
        {
            rta=rta1+nombre_reporte;
            Map  parametros = new HashMap();
            parametros.clear();
            parametros.put(nomparametro1,param1);
            //-----------------------------------          
            reporte_view= JasperFillManager.fillReport(rta, parametros, cnx.getConnection() );
            JasperViewer.viewReport( reporte_view , false);
            //terminamos la conexion a la base de datos
	  }catch (JRException E)
          {
              JOptionPane.showMessageDialog(null,E.getMessage());
          }
          System.gc();
    }
    public void Reporte_2Parametro_Imagen(String nombre_reporte,String nomparametro1,String param1,String nomparametro2,String param2,String nombre_logo,String Direccion_logo)
    {
        JasperPrint reporte_view;
        try
        {
            rta=rta1+nombre_reporte;
            Map  parametros = new HashMap();
            parametros.clear();
            parametros.put(nomparametro1,param1);
            parametros.put(nomparametro2,param2);
            parametros.put(nombre_logo,this.getClass().getResourceAsStream(Direccion_logo));
            //-----------------------------------          
            reporte_view= JasperFillManager.fillReport(rta, parametros, cnx.getConnection() );
            JasperViewer.viewReport( reporte_view , false);
            //terminamos la conexion a la base de datos
	  }catch (JRException E)
          {
              JOptionPane.showMessageDialog(null,E.getMessage());
          }
          System.gc();
    }
    public void Reporte_SIn_Parametro_con_1_Imagen(String nombre_reporte,String nombre_logo,String Direccion_logo)
    {
        JasperPrint reporte_view;
        try
        {
            rta=rta1+nombre_reporte;
            Map  parametros = new HashMap();
            parametros.clear();
            parametros.put(nombre_logo,this.getClass().getResourceAsStream(Direccion_logo));
            //-----------------------------------          
            reporte_view= JasperFillManager.fillReport(rta, parametros, cnx.getConnection() );
            JasperViewer.viewReport( reporte_view , false);
            //terminamos la conexion a la base de datos
	  }catch (JRException E)
          {
              JOptionPane.showMessageDialog(null,E.getMessage());
          }
          System.gc();
    }
    public void REP_4Param_1IMG(String nombre_parametro1,String nombre_parametro2,String nombre_parametro3,String nombre_parametro4,String parametro1,String parametro2,String parametro3,String parametro4,String nmbrpte,String nombre_logo,String Direccion_logo)
     {
     JasperPrint reporte_view;
     try
     {
         rta=rta1+nmbrpte;
          Map  parametros = new HashMap();
          parametros.clear();
          parametros.put(nombre_parametro1,parametro1);
          parametros.put(nombre_parametro2,parametro2);
          parametros.put(nombre_parametro3,parametro3);
          parametros.put(nombre_parametro4,parametro4);
          parametros.put(nombre_logo,this.getClass().getResourceAsStream(Direccion_logo));
          //-----------------------------------          
          reporte_view= JasperFillManager.fillReport(rta, parametros, cnx.getConnection() );
          JasperViewer.viewReport( reporte_view , false);
          //terminamos la conexion a la base de datos
	  }catch (JRException E)
          {
              JOptionPane.showMessageDialog(null,E.getMessage());
          }
     System.gc();
       }
}
