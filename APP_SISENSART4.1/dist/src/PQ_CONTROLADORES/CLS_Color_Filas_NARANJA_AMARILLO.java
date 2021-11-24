/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PQ_CONTROLADORES;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author CLARK
 */
public class CLS_Color_Filas_NARANJA_AMARILLO extends DefaultTableCellRenderer
{
//    @Override
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )
    {        
        if(row % 2 == 0)
        {
            setBackground(Color.ORANGE);
        }
        else
        {
            setBackground(Color.YELLOW);
        }
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        return this;
 }
}
