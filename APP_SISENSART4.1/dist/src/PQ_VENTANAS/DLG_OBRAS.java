/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PQ_VENTANAS;

import PQ_CONTROLADORES.CLS_Controlador;

/**
 *
 * @author Andy Figueroa
 */
public class DLG_OBRAS extends javax.swing.JDialog {

    CLS_Controlador ctrl= new CLS_Controlador();
    /**
     * Creates new form DLG_OBRAS
     */
    public DLG_OBRAS(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ctrl.CerrarVentanaESC(this);
    }
    private void Guardar()
    {
        if(TXAdescripcion.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeError("Ud. no ingresó el nombre de la obra.");
            TXAdescripcion.requestFocus();
        }
        else if(TXdireccion.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeError("Ud. no ingresó la dirección de la obra");
            TXdireccion.requestFocus();
        }
        else
        {
            ctrl.GrabarData("OBRA","descripcion,direccion,estado", "'"+TXAdescripcion.getText().trim()+"','"+TXdireccion.getText().trim()+"',1");
            Cancelar();
        }
    }
    private void Cancelar()
    {
        TXAdescripcion.setText("");
        TXdireccion.setText("");
        TXAdescripcion.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TXAdescripcion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        TXdireccion = new javax.swing.JTextField();
        BTguardar = new javax.swing.JButton();
        BTcancelar = new javax.swing.JButton();
        BTeditar = new javax.swing.JButton();
        BTsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MANTENIMIENTO DE OBRAS.");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Datos de Obra:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Descripción:");

        TXAdescripcion.setColumns(20);
        TXAdescripcion.setLineWrap(true);
        TXAdescripcion.setRows(5);
        TXAdescripcion.setWrapStyleWord(true);
        TXAdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXAdescripcionKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TXAdescripcion);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Dirección:");

        TXdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXdireccionKeyPressed(evt);
            }
        });

        BTguardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/GUARDAR.png"))); // NOI18N
        BTguardar.setText("Guardar");
        BTguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTguardarActionPerformed(evt);
            }
        });

        BTcancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CANCELAR.png"))); // NOI18N
        BTcancelar.setText("Cancelar");
        BTcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTcancelarActionPerformed(evt);
            }
        });

        BTeditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTeditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/EDITAR.png"))); // NOI18N
        BTeditar.setText("Editar");
        BTeditar.setEnabled(false);

        BTsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/SALIR.png"))); // NOI18N
        BTsalir.setText("Salir");
        BTsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(TXdireccion)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BTguardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTcancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTeditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTsalir)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTguardar)
                    .addComponent(BTcancelar)
                    .addComponent(BTeditar)
                    .addComponent(BTsalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BTguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTguardarActionPerformed
        // TODO add your handling code here:
        Guardar();
    }//GEN-LAST:event_BTguardarActionPerformed

    private void BTcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTcancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_BTcancelarActionPerformed

    private void BTsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BTsalirActionPerformed

    private void TXAdescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXAdescripcionKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            TXdireccion.requestFocus();
        }
    }//GEN-LAST:event_TXAdescripcionKeyPressed

    private void TXdireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXdireccionKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            ctrl.PulsarEnter(evt, BTguardar);
        }
    }//GEN-LAST:event_TXdireccionKeyPressed

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
            java.util.logging.Logger.getLogger(DLG_OBRAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DLG_OBRAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DLG_OBRAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DLG_OBRAS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DLG_OBRAS dialog = new DLG_OBRAS(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BTcancelar;
    private javax.swing.JButton BTeditar;
    private javax.swing.JButton BTguardar;
    private javax.swing.JButton BTsalir;
    private javax.swing.JTextArea TXAdescripcion;
    private javax.swing.JTextField TXdireccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
