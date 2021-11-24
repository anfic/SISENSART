/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PQ_VENTANAS;

import PQ_CONTROLADORES.CLS_Controlador;
import PQ_CONTROLADORES.Iniciar;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author ANDY
 */
public class DLG_Login extends javax.swing.JFrame {

    CLS_Controlador ctrl;
//    MDI_PRINCIPAL principal;
    /**
     * Creates new form DLG_Login
     */
    public DLG_Login() {
        //super(parent, modal);
        initComponents();
        ctrl=new CLS_Controlador();
        //ctrl.CerrarVentanaESC(this);
        TXusuario.requestFocus();
    }
    
    @Override
         public Image getIconImage()
    {
        Image retValue = Toolkit.getDefaultToolkit().
        getImage(ClassLoader.getSystemResource("PQ_IMAGENES/logo54px.png"));
        return retValue;
        
    }
    private void IngresarMenu()
    {
        
        if(TXusuario.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeError("Ud. no ingreso el usuaio");
            TXusuario.requestFocus();
        }
        else if( TXcontraseña.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeError("Ud. no ingreso la contraseña");
            TXcontraseña.requestFocus();
        }
        else if(CBtipo.getSelectedIndex()==-1)
        {
            ctrl.mensaje.MensajeAlerta("no seleccionó el tipo de Usuario.");
            CBtipo.requestFocus();
        }
        else
        {
           if(ctrl.AccesoAlSistema("usuario","nick", TXusuario.getText().trim(),"pass", TXcontraseña, "and tipo_usuario='"+CBtipo.getSelectedItem().toString().trim()+"' and estado=1"))
           {
               
               ctrl.usuario=ctrl.ObtenerCodigo("usuario","nick", TXusuario.getText().trim(),2);
               ctrl.mensaje.MensajeSimple("Bienvenido:\n"+ctrl.usuario);
               Iniciar.principal =new MDI_PRINCIPAL();
               this.dispose();
               Iniciar.principal.setVisible(true);
               Iniciar.principal.TXusuario.setText(ctrl.ObtenerCodigo("v_usuario", "usuario_nick", TXusuario.getText().trim(), 2));
               Iniciar.principal.TXnick.setText(ctrl.ObtenerCodigo("v_usuario", "usuario_nick", TXusuario.getText().trim(), 4));
               Iniciar.principal.TXyipo.setText(ctrl.ObtenerCodigo("v_usuario", "usuario_nick", TXusuario.getText().trim(), 6));
               Iniciar.principal.TXcargo.setText(ctrl.ObtenerCodigo("v_usuario", "usuario_nick", TXusuario.getText().trim(), 8));
               Iniciar.principal.TXcargo1.setText(ctrl.ObtenerCodigo("usuario", "nick", TXusuario.getText().trim(), 10));
               if(Iniciar.principal.TXyipo.getText().trim().equalsIgnoreCase("administrador"))
               {
                   Iniciar.principal.jMenu8.setEnabled(false);
                   Iniciar.principal.jMenuItem17.setEnabled(false);
               }
               else if(Iniciar.principal.TXyipo.getText().trim().equalsIgnoreCase("solicitante"))
               {
                   Iniciar.principal.jMenu8.setEnabled(false);
                   Iniciar.principal.M2.setEnabled(false);
                   Iniciar.principal.M3.setEnabled(false);
                   Iniciar.principal.M4.setEnabled(false);
                   Iniciar.principal.M5.setEnabled(false);
                   Iniciar.principal.M6.setEnabled(false);
                   Iniciar.principal.M8.setEnabled(false);
                   Iniciar.principal.M9.setEnabled(false);
                   Iniciar.principal.M10.setEnabled(false);
                   Iniciar.principal.M11.setEnabled(false);
                   Iniciar.principal.jMenuItem17.setEnabled(false);
                   Iniciar.principal.B1.setEnabled(false);
                   Iniciar.principal.B2.setEnabled(false);
                   Iniciar.principal.B3.setEnabled(false);
                   Iniciar.principal.B4.setEnabled(false);
                   Iniciar.principal.jMenuItem2.setEnabled(false);
                   Iniciar.principal.jMenuItem7.setEnabled(false);
                   Iniciar.principal.jMenuItem1.setEnabled(false);
               }
           }
           else
            {
                ctrl.Veces++;
                if(ctrl.Veces==3)
                {
                    ctrl.mensaje.MensajeAlerta("La contraseña es erronea o su cuenta esta desactivada.\nPorfavor Comuniquese con el area de SISTEMAS.\nNúmero: 973782530\nING. de Sistemas: Andy Figueroa Castillo");
                    this.dispose();
                }
                else
                {
                    if(ctrl.Veces==1)
                    {
                        ctrl.mensaje.MensajeAlerta("Contraseña incorecta lleva 1 oportunidad.");
                        ctrl.MarcarPsw(TXcontraseña);
                    }
                    else
                    {
                        ctrl.mensaje.MensajeAlerta("Contraseña incorecta lleva "+ctrl.Veces+" oportunidades.");
                        ctrl.MarcarPsw(TXcontraseña);
                    }
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel1 = new javax.swing.JLabel();
        panelNice3 = new org.edisoncor.gui.panel.PanelNice();
        jLabel2 = new javax.swing.JLabel();
        TXusuario = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        jLabel3 = new javax.swing.JLabel();
        TXcontraseña = new org.edisoncor.gui.passwordField.PasswordFieldRoundIcon();
        jLabel4 = new javax.swing.JLabel();
        CBtipo = new org.edisoncor.gui.comboBox.ComboBoxRound();
        BTlogeo = new javax.swing.JButton();
        BTsalir = new javax.swing.JButton();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        panelCurves2 = new org.edisoncor.gui.panel.PanelCurves();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso al Sistema.");
        setUndecorated(true);
        setOpacity(0.85f);

        panel1.setColorPrimario(new java.awt.Color(0, 0, 0));
        panel1.setColorSecundario(new java.awt.Color(102, 102, 102));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/(white)logo426p.png"))); // NOI18N
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 130));

        panelNice3.setBackground(new java.awt.Color(145, 30, 30));

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario:");

        TXusuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXusuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TXusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXusuarioKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");

        TXcontraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXcontraseña.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TXcontraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXcontraseñaKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("T. de Usuario:");

        CBtipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SUPER ADMINISTRADOR", "ADMINISTRADOR", "SOLICITANTE" }));
        CBtipo.setSelectedIndex(-1);
        CBtipo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        CBtipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CBtipoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelNice3Layout = new javax.swing.GroupLayout(panelNice3);
        panelNice3.setLayout(panelNice3Layout);
        panelNice3Layout.setHorizontalGroup(
            panelNice3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNice3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNice3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(panelNice3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CBtipo, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(TXcontraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TXusuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelNice3Layout.setVerticalGroup(
            panelNice3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNice3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNice3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelNice3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelNice3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CBtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel1.add(panelNice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 138, 430, -1));

        BTlogeo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTlogeo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/Aceptar.png"))); // NOI18N
        BTlogeo.setText("INGRESAR");
        BTlogeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTlogeoActionPerformed(evt);
            }
        });
        panel1.add(BTlogeo, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 275, 130, 30));

        BTsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/SALIR.png"))); // NOI18N
        BTsalir.setText("SALIR");
        BTsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTsalirActionPerformed(evt);
            }
        });
        panel1.add(BTsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 274, -1, 30));
        panel1.add(panelCurves1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 30));
        panel1.add(panelCurves2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 430, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TXusuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXusuarioKeyPressed
        // TODO add your handling code here:
        ctrl.PulsarEnter(evt, TXcontraseña);
    }//GEN-LAST:event_TXusuarioKeyPressed

    private void TXcontraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXcontraseñaKeyPressed
        // TODO add your handling code here:
        ctrl.PulsarEnter(evt, CBtipo);
    }//GEN-LAST:event_TXcontraseñaKeyPressed

    private void CBtipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBtipoKeyPressed
        // TODO add your handling code here:
        ctrl.PulsarEnter(evt, BTlogeo);
    }//GEN-LAST:event_CBtipoKeyPressed

    private void BTlogeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTlogeoActionPerformed
        // TODO add your handling code here:
        IngresarMenu();
    }//GEN-LAST:event_BTlogeoActionPerformed

    private void BTsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTsalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_BTsalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DLG_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DLG_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DLG_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DLG_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DLG_Login dialog = new DLG_Login();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTlogeo;
    private javax.swing.JButton BTsalir;
    private org.edisoncor.gui.comboBox.ComboBoxRound CBtipo;
    private org.edisoncor.gui.passwordField.PasswordFieldRoundIcon TXcontraseña;
    private org.edisoncor.gui.textField.TextFieldRoundIcon TXusuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelCurves panelCurves2;
    private org.edisoncor.gui.panel.PanelNice panelNice3;
    // End of variables declaration//GEN-END:variables
}
