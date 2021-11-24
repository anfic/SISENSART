/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PQ_CONTROLADORES;

import PQ_VENTANAS.DLG_Login;
import PQ_VENTANAS.MDI_PRINCIPAL;
import java.awt.Image;
import java.awt.Toolkit;


/**
 *
 * @author ANDY
 */
public class Iniciar {

    public static CLS_Controlador ctrl=new CLS_Controlador();
    public static MDI_PRINCIPAL principal;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MDI_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDI_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDI_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDI_PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        Iniciar();
        DLG_Login dlg=new DLG_Login();
        dlg.setVisible(true);
        
        
        
    }
    
    public static void Iniciar()
    {
        ctrl.Base.Conectar();
    }      
}
