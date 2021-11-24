/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PQ_CONTROLADORES;

import javax.swing.JOptionPane;

/**
 *
 * @author ANDY FC
 */
public class CLS_Mensajes
{
    public void MensajeSimple(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
        System.gc();
    }
    public void MensajeAlerta(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje,"Atención.",JOptionPane.INFORMATION_MESSAGE);
        System.gc();
    }
    public void MensajePregunta(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje,"Elegir.",JOptionPane.QUESTION_MESSAGE);
        System.gc();
    }
    public void MensajeError(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje,"Error.",JOptionPane.ERROR_MESSAGE);
        System.gc();
    }
    public int MsjeConfirmacion(String msje)
    {
        int resp=JOptionPane.showConfirmDialog(null, msje,"Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        return resp;
    }
    public String IngresarMensaje(String Mensaje,String Msj)
    {
        String men=JOptionPane.showInputDialog(Mensaje, Msj);
        return men;
    }
}
