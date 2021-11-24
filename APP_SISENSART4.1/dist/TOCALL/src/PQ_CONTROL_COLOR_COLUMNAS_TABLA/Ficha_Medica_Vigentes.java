/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PQ_CONTROL_COLOR_COLUMNAS_TABLA;

import PQ_CONTROLADORES.CLS_Controlador;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Andy Figueroa
 */
public class Ficha_Medica_Vigentes extends DefaultTableCellRenderer
{
    CLS_Controlador ctrl=new CLS_Controlador();
    public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column )
    {
        if(column==0)
        {
            try 
            {
                SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                Date fecha1=df.parse(ctrl.Fecha());
                Date fecha2=df.parse(table.getValueAt(row, 3).toString().trim());
                if(ctrl.diferenciasDeFechas(fecha1, fecha2)<=5)
                {
                    this.setBackground(Color.RED);
                }
                else if(ctrl.diferenciasDeFechas(fecha1, fecha2)>5 && ctrl.diferenciasDeFechas(fecha1, fecha2)<=15)
                {
                    this.setBackground(Color.ORANGE);
                }
            } 
            catch (ParseException ex) 
            {
                Logger.getLogger(Ficha_Datos_Vigentes.class.getName()).log(Level.SEVERE, null, ex.getMessage());
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
