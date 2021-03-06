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
public class DLG_MATERIALES extends javax.swing.JDialog {

    CLS_Controlador ctrl=new CLS_Controlador();
    /**
     * Creates new form DLG_MATERIALES
     */
    public DLG_MATERIALES(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ctrl.CerrarVentanaESC(this);
        ctrl.LlenarCombo(CBtipo, "select * from tipo_material",2);
        ctrl.LlenarCombo(CBunidad, "select * from unidad",2);
        Activar(true, false);
        Cancelar();
    }
    private void Guardar()
    {
        if (TXAdescripcion.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeError("Ud. no ingresó la descripción del material.");
            TXAdescripcion.requestFocus();
        } 
        else if (CBunidad.getSelectedIndex()==-1)
        {
            ctrl.mensaje.MensajeError("Ud. no seleccionó la unidad de medida del material.");
            CBunidad.requestFocus();
        } else if (CBtipo.getSelectedIndex()==-1)
        {
            ctrl.mensaje.MensajeError("Ud. no seleccionó el tipo de material.");
            CBtipo.requestFocus();         
        } else 
        {
            String unidad=ctrl.ObtenerCodigo("unidad", "descripcion", CBunidad.getSelectedItem().toString().trim(), 1);
            String tipo=ctrl.ObtenerCodigo("tipo_material","descripcion", CBtipo.getSelectedItem().toString().trim(), 1);
            ctrl.GrabarData("material", "descripcion,precio_almacen,id_unidad,id_tipo","'"+TXAdescripcion.getText().trim()+"','"+TXprecio.getText().trim()+"','"+unidad+"','"+tipo+"'" );
            Cancelar();
        }
    }
    private void Cancelar()
    {
        TXAdescripcion.setText("");
        TXprecio.setText("0.0");
        CBunidad.setSelectedIndex(-1);
        CBtipo.setSelectedIndex(-1);
        TXAdescripcion.requestFocus();
        ctrl.VisualizarEnTabla("v_material", jTable1, "");
        Activar(true, false);
   }
    private void Pasar()
    {
        String uni=ctrl.ObtenerCodigo("unidad", "abreviatura", ctrl.ValorTabla(jTable1, 3).trim(),2);
        TXAdescripcion.setText(ctrl.ValorTabla(jTable1, 1));
        TXprecio.setText(ctrl.ValorTabla(jTable1, 2));
        CBunidad.setSelectedItem(uni);
        CBtipo.setSelectedItem(ctrl.ValorTabla(jTable1, 4));
        Activar(false, true);
    }
    private void Activar(boolean a,boolean b)
    {
        BTguardar.setEnabled(a);
        BTeditar.setEnabled(b);
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
        TXprecio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CBunidad = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CBtipo = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        BTguardar = new javax.swing.JButton();
        BTcancelar = new javax.swing.JButton();
        BTeditar = new javax.swing.JButton();
        BTsalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MANTENIMIENTO DE MATERIALES.");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Datos de Material:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

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
        jLabel2.setText("Precio:");

        TXprecio.setBackground(new java.awt.Color(255, 255, 102));
        TXprecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXprecio.setText("0.0");
        TXprecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXprecioFocusGained(evt);
            }
        });
        TXprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXprecioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXprecioKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Unidad:");

        CBunidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CBunidadFocusGained(evt);
            }
        });
        CBunidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CBunidadKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CARPETA1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tipo:");

        CBtipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CBtipoFocusGained(evt);
            }
        });
        CBtipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CBtipoKeyPressed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CARPETA1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
        BTeditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTeditarActionPerformed(evt);
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Precio", "Unidad", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Buscar:");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(22, 22, 22)
                        .addComponent(CBtipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBunidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addComponent(BTguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTcancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTeditar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTsalir))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TXprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jButton1)
                            .addComponent(CBunidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(CBtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTguardar)
                    .addComponent(BTcancelar)
                    .addComponent(BTeditar)
                    .addComponent(BTsalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DLG_UNIDAD und=new DLG_UNIDAD(null,true);
        und.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DLG_TIPO_MATERIAL tip=new DLG_TIPO_MATERIAL(null,true);
        tip.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BTsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BTsalirActionPerformed

    private void CBtipoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CBtipoFocusGained
        // TODO add your handling code here:
        ctrl.LlenarCombo(CBtipo, "select * from tipo_material",2);
    }//GEN-LAST:event_CBtipoFocusGained

    private void CBunidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CBunidadFocusGained
        // TODO add your handling code here:
        ctrl.LlenarCombo(CBunidad, "select * from unidad",2);
    }//GEN-LAST:event_CBunidadFocusGained

    private void TXprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXprecioKeyTyped
        // TODO add your handling code here:
        ctrl.SoloNumerosDecimales(evt);
        ctrl.Unpunto(evt, TXprecio);
    }//GEN-LAST:event_TXprecioKeyTyped

    private void TXAdescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXAdescripcionKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            ctrl.Maracar(TXprecio);
        } 
    }//GEN-LAST:event_TXAdescripcionKeyPressed

    private void TXprecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXprecioKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            CBunidad.requestFocus();
        } 
    }//GEN-LAST:event_TXprecioKeyPressed

    private void CBunidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBunidadKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            CBtipo.requestFocus();
        } 
    }//GEN-LAST:event_CBunidadKeyPressed

    private void CBtipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBtipoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            ctrl.PulsarEnter(evt, BTguardar);
        } 
    }//GEN-LAST:event_CBtipoKeyPressed

    private void BTguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTguardarActionPerformed
        // TODO add your handling code here:
        Guardar();
    }//GEN-LAST:event_BTguardarActionPerformed

    private void BTcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTcancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_BTcancelarActionPerformed

    private void TXprecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXprecioFocusGained
        // TODO add your handling code here:
        TXprecio.setText("0.0");
        ctrl.Maracar(TXprecio);
    }//GEN-LAST:event_TXprecioFocusGained

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        ctrl.VisualizarEnTabla("v_material", jTable1, " where material_descripcion like '%"+jTextField1.getText().trim()+"%'");
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        Pasar();
    }//GEN-LAST:event_jTable1MouseClicked

    private void BTeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTeditarActionPerformed
        // TODO add your handling code here:
        Editar();
    }//GEN-LAST:event_BTeditarActionPerformed

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
            java.util.logging.Logger.getLogger(DLG_MATERIALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DLG_MATERIALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DLG_MATERIALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DLG_MATERIALES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DLG_MATERIALES dialog = new DLG_MATERIALES(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox CBtipo;
    private javax.swing.JComboBox CBunidad;
    private javax.swing.JTextArea TXAdescripcion;
    private javax.swing.JTextField TXprecio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void Editar() 
    {
        if (TXAdescripcion.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeError("Ud. no ingresó la descripción del material.");
            TXAdescripcion.requestFocus();
        } 
        else if (CBunidad.getSelectedIndex()==-1)
        {
            ctrl.mensaje.MensajeError("Ud. no seleccionó la unidad de medida del material.");
            CBunidad.requestFocus();
        } else if (CBtipo.getSelectedIndex()==-1)
        {
            ctrl.mensaje.MensajeError("Ud. no seleccionó el tipo de material.");
            CBtipo.requestFocus();         
        } else 
        {
            String unidad=ctrl.ObtenerCodigo("unidad", "descripcion", CBunidad.getSelectedItem().toString().trim(), 1);
            String tipo=ctrl.ObtenerCodigo("tipo_material","descripcion", CBtipo.getSelectedItem().toString().trim(), 1);
            ctrl.ActualizarData("material", "descripcion='"+TXAdescripcion.getText().trim()+"',precio_almacen='"+TXprecio.getText().trim()+"',id_unidad='"+unidad+"',id_tipo='"+tipo+"'", "id_material='"+ctrl.ValorTabla(jTable1, 0)+"'");
            Cancelar();
        }
    }
}
