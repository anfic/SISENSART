/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PQ_VENTANAS;

import PQ_CONTROLADORES.CLS_Controlador;

/**
 *
 * @author pc
 */
public class DLG_Banco extends javax.swing.JDialog {

    /**
     * Creates new form DLG_Banco
     */
    CLS_Controlador ctrl=new CLS_Controlador();
    
    public DLG_Banco(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ctrl.CerrarVentanaESC(this);
        Cancelar();
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
        jLabel2 = new javax.swing.JLabel();
        TXdescripcion = new javax.swing.JTextField();
        TXabreviatura = new javax.swing.JTextField();
        BTsalir = new javax.swing.JButton();
        BTguardar = new javax.swing.JButton();
        BTm = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBbanco = new javax.swing.JTable();
        BTcancelar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mantenimiento de Banco");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Mantenimiento de Banco", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Descripción:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Abreviatura:");

        TXdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXdescripcionKeyPressed(evt);
            }
        });

        TXabreviatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXabreviaturaKeyPressed(evt);
            }
        });

        BTsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/SALIR.png"))); // NOI18N
        BTsalir.setText("Salir");
        BTsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTsalirActionPerformed(evt);
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

        BTm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/EDITAR.png"))); // NOI18N
        BTm.setText("Editar");
        BTm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTmActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Buscar:");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        TBbanco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo", "Descripción", "Abreviatura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBbanco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBbancoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBbanco);
        if (TBbanco.getColumnModel().getColumnCount() > 0) {
            TBbanco.getColumnModel().getColumn(0).setResizable(false);
            TBbanco.getColumnModel().getColumn(1).setResizable(false);
            TBbanco.getColumnModel().getColumn(2).setResizable(false);
        }

        BTcancelar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTcancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CANCELAR.png"))); // NOI18N
        BTcancelar1.setText("Cancelar");
        BTcancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTcancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TXabreviatura, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TXdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(BTguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTcancelar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTsalir)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TXdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXabreviatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(BTsalir)
                    .addComponent(BTcancelar1)
                    .addComponent(BTm)
                    .addComponent(BTguardar))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TXabreviaturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXabreviaturaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            ctrl.PulsarEnter(evt, BTguardar);
        }
    }//GEN-LAST:event_TXabreviaturaKeyPressed

    private void BTsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BTsalirActionPerformed

    private void BTguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTguardarActionPerformed
        // TODO add your handling code here:
        Guardar();
    }//GEN-LAST:event_BTguardarActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
        Cancelar();
        ctrl.VisualizarEnTabla("banco", TBbanco, "where descripcion like('%"+jTextField2.getText().trim()+"%')");
    }//GEN-LAST:event_jTextField2KeyReleased

    private void TXdescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXdescripcionKeyPressed
        // TODO add your handling code here:
      if(evt.getKeyCode()==evt.VK_ENTER)
        {
            ctrl.PulsarEnter(evt, TXabreviatura);
        }  
    }//GEN-LAST:event_TXdescripcionKeyPressed

    private void BTmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTmActionPerformed
        // TODO add your handling code here:
        Modificar();
    }//GEN-LAST:event_BTmActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void TBbancoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBbancoMouseClicked
        // TODO add your handling code here:
        PasarDatos();
    }//GEN-LAST:event_TBbancoMouseClicked

    private void BTcancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTcancelar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTcancelar1ActionPerformed

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
            java.util.logging.Logger.getLogger(DLG_Banco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DLG_Banco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DLG_Banco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DLG_Banco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DLG_Banco dialog = new DLG_Banco(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BTcancelar1;
    private javax.swing.JButton BTguardar;
    private javax.swing.JButton BTm;
    private javax.swing.JButton BTsalir;
    private javax.swing.JTable TBbanco;
    private javax.swing.JTextField TXabreviatura;
    private javax.swing.JTextField TXdescripcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private void Guardar() {
        if(TXdescripcion.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no ingresó una descripción del banco");
            TXdescripcion.requestFocus();
        }else if(TXabreviatura.getText().trim().length()==0){
            ctrl.mensaje.MensajeAlerta("Ud. no ingresó una abreviatura del banco");
            TXabreviatura.requestFocus();
        }
        else
        {
            ctrl.GrabarData("banco", "descripcion, abeviatura",  "'"+TXdescripcion.getText().trim()+"','"+TXabreviatura.getText().trim()+"'");
            Cancelar();
        }
    }
    private void ActivaBotones(boolean a,boolean b)
    {
        BTguardar.setEnabled(a);
        BTm.setEnabled(b);
    }
    private void Cancelar()
    {
      ctrl.VisualizarEnTabla("banco", TBbanco, "");
        TXdescripcion.setText("");
        TXabreviatura.setText("");
        ActivaBotones(true,false);
    }

    private void Modificar() {
         if(TXdescripcion.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no ingresó una descripción del banco");
            TXdescripcion.requestFocus();
        }else if(TXabreviatura.getText().trim().length()==0){
            ctrl.mensaje.MensajeAlerta("Ud. no ingresó una abreviatura del banco");
            TXabreviatura.requestFocus();
        }
        else
        {
            ctrl.ActualizarData("banco","descripcion='"+TXdescripcion.getText().trim()+"', abeviatura='"+TXabreviatura.getText().trim()+"'", "idbanco='"+TBbanco.getValueAt(TBbanco.getSelectedRow(), 0).toString().trim()+"'");
            Cancelar();            
        }
    }
    private void PasarDatos()
    {
        TXdescripcion.setText(TBbanco.getValueAt(TBbanco.getSelectedRow(), 1).toString().trim());
        TXabreviatura.setText(TBbanco.getValueAt(TBbanco.getSelectedRow(), 2).toString().trim());
        ActivaBotones(false, true);
        ctrl.Maracar(TXdescripcion);
    }
}
