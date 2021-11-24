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
public class DLG_Experiencia_Laboral extends javax.swing.JDialog {

    CLS_Controlador ctrl=new CLS_Controlador();
    public DLG_Experiencia_Laboral(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ctrl.CerrarVentanaESC(this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TXdni = new javax.swing.JTextField();
        LBpadre = new javax.swing.JLabel();
        BTbuscar = new javax.swing.JButton();
        LBestado = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TXpuesto = new javax.swing.JTextField();
        TXfecha = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBhijo = new javax.swing.JTable();
        BTelimnar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        BTadherir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TXfecha1 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventana de Experiencia Laboral");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Datos de Personal:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Ingrese DNI:");

        TXdni.setBackground(new java.awt.Color(255, 255, 102));
        TXdni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXdniKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXdniKeyTyped(evt);
            }
        });

        BTbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CARPETA1.png"))); // NOI18N
        BTbuscar.setText("Buscar");
        BTbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LBpadre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXdni, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTbuscar)
                .addContainerGap(36, Short.MAX_VALUE))
            .addComponent(LBestado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(TXdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTbuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBpadre, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LBestado, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Puesto:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Del:");

        TXpuesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXpuestoKeyPressed(evt);
            }
        });

        try {
            TXfecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXfecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXfechaKeyPressed(evt);
            }
        });

        TBhijo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Puesto", "F.Nac.", "DNI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBhijo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TBhijo);

        BTelimnar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/Eliminar.png"))); // NOI18N
        BTelimnar.setText("Eliminar");
        BTelimnar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTelimnarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/SALIR.png"))); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CANCELAR.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        BTadherir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/ADICIONAR.png"))); // NOI18N
        BTadherir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTadherirActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Hasta:");

        try {
            TXfecha1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TXfecha1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXfecha1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTelimnar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXpuesto)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TXfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BTadherir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TXpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(TXfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel5)
                        .addComponent(TXfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(BTadherir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BTelimnar)
                        .addComponent(jButton1))
                    .addComponent(jButton2)))
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

    private void TXdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXdniKeyTyped
        // TODO add your handling code here:
        ctrl.Limittxt(TXdni, evt, 7);
        ctrl.SoloNumeroEnteros(TXdni);
    }//GEN-LAST:event_TXdniKeyTyped

    private void BTbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTbuscarActionPerformed
        // TODO add your handling code here:
        Buscar();
    }//GEN-LAST:event_BTbuscarActionPerformed

    private void BTelimnarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTelimnarActionPerformed
        // TODO add your handling code here:
        if (TBhijo.getSelectedRow()==-1)
        {
            ctrl.mensaje.MensajeAlerta("Seleccione una fila");
        }
        else
        {
            if (ctrl.mensaje.MsjeConfirmacion("Está seguro que desea eliminar estos datos?")==0)
            {
                ctrl.EliminarData("puestos_ocupados", "where id_puesto='"+ctrl.ValorTabla(TBhijo, 0)+"'");
                Cancelar();
            }
            else
            {
                ctrl.mensaje.MensajeSimple("Proceso Cancelado.");
                ctrl.Maracar(TXpuesto);
            }
        }
    }//GEN-LAST:event_BTelimnarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Cancelar2();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BTadherirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTadherirActionPerformed
        // TODO add your handling code here:
        Adicionar();
    }//GEN-LAST:event_BTadherirActionPerformed

    private void TXdniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXdniKeyPressed
        // TODO add your handling code here:
        ctrl.PulsarEnter(evt, BTbuscar);
    }//GEN-LAST:event_TXdniKeyPressed

    private void TXpuestoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXpuestoKeyPressed
        // TODO add your handling code here:
        ctrl.PulsarEnter(evt, TXfecha);
    }//GEN-LAST:event_TXpuestoKeyPressed

    private void TXfechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXfechaKeyPressed
        // TODO add your handling code here:
        ctrl.PulsarEnter(evt, BTadherir);
    }//GEN-LAST:event_TXfechaKeyPressed

    private void TXfecha1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXfecha1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXfecha1KeyPressed

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
            java.util.logging.Logger.getLogger(DLG_Experiencia_Laboral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DLG_Experiencia_Laboral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DLG_Experiencia_Laboral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DLG_Experiencia_Laboral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DLG_Experiencia_Laboral dialog = new DLG_Experiencia_Laboral(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BTadherir;
    private javax.swing.JButton BTbuscar;
    private javax.swing.JButton BTelimnar;
    private javax.swing.JLabel LBestado;
    private javax.swing.JLabel LBpadre;
    private javax.swing.JTable TBhijo;
    private javax.swing.JTextField TXdni;
    private javax.swing.JFormattedTextField TXfecha;
    private javax.swing.JFormattedTextField TXfecha1;
    private javax.swing.JTextField TXpuesto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void Buscar()
    {
        String app,apm,nom,est;
        app=ctrl.ObtenerCodigo("personal", "dni", TXdni.getText().trim(), 2);
        apm=ctrl.ObtenerCodigo("personal", "dni", TXdni.getText().trim(), 3);
        nom=ctrl.ObtenerCodigo("personal", "dni", TXdni.getText().trim(), 4);
        est=ctrl.ObtenerCodigo("personal", "dni", TXdni.getText().trim(), 18);
        LBpadre.setText(app+" "+apm+" "+nom);
        LBestado.setText(est);
        Cancelar();
    }

     private void Adicionar()
    {
        if (LBpadre.getText().trim().length()*TXdni.getText().trim().length()*LBestado.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó los datos del personal");
            ctrl.Maracar(TXdni);
        }
        else if(TXpuesto.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no registró el puesto.");
            ctrl.Maracar(TXpuesto);
        }
        else if(TXfecha.getText().trim().length()>10)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no registró la fecha desde de laboración");
            TXfecha.requestFocus();
        }
        else if(TXfecha1.getText().trim().length()>10)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no registró la fecha hasta de laboración");
            TXfecha.requestFocus();
        }
        else
        {
            ctrl.GrabarData("puestos_ocupados", "descripcion,fecha_desde,dni,fecha_hasta", "'"+TXpuesto.getText().trim()+"','"+TXfecha.getText().trim()+"','"+TXdni.getText().trim()+"','"+TXfecha1.getText().trim()+"'");
            Cancelar();
        }
    }

    private void Cancelar()
    {
        TXpuesto.setText("");
        TXfecha.setText("");
        TXfecha1.setText("");
        ctrl.VisualizarEnTabla("puestos_ocupados", TBhijo, "where dni='"+TXdni.getText().trim()+"'");
    }

    private void Cancelar2()
    {
        TXdni.setText("");
        LBpadre.setText("");
        Cancelar();
    }
}
