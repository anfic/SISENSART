/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PQ_CONTROLADORES;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.MailDateFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author USUARIO
 */
public class prueba extends DefaultTableCellRenderer
{
    CLS_Controlador ctrl=new CLS_Controlador();
    public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column )
    {
        if(column==0 || column==3 || column==5 || column==9)
        {
            try 
            {
                SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                Date fecha1=df.parse(table.getValueAt(row, 3).toString().trim());
                Date fecha2=df.parse(ctrl.Fecha());
                if(ctrl.diferenciasDeFechas(fecha2, fecha1)<=3 && ctrl.diferenciasDeFechas(fecha2, fecha1)>-1)
                {
                    this.setBackground(Color.ORANGE);
                }
                else if(table.getValueAt(row, 10).toString().trim().equalsIgnoreCase("caducado"))
                {
                    this.setBackground(Color.RED);
                }
            } 
            catch (ParseException ex) 
            {
                Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            }
        }
        else
        {
            this.setBackground(Color.white);
        }
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        return this;
    }
 }