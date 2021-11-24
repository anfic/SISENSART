/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PQ_VENTANAS;

import PQ_CONTROLADORES.CLS_Controlador;

/**
 *
 * @author ANDY
 */
public class DLG_Mantenimiento_Almacen extends javax.swing.JDialog {

    CLS_Controlador ctrl=new CLS_Controlador();
    /**
     * Creates new form DLG_Mantenimiento_Almacen
     */
    public DLG_Mantenimiento_Almacen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TXdescripcion = new javax.swing.JTextField();
        TXdireccion = new javax.swing.JTextField();
        BTcancelar = new javax.swing.JButton();
        BTsalir = new javax.swing.JButton();
        BTgrabar = new javax.swing.JButton();
        BTmodificar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TXbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBalmacen = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mantenimiento de Almacenes.");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Mantenimiento de Almacenes:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setText("Decripción:");

        jLabel2.setText("Dirección:");

        BTcancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CANCELAR.png"))); // NOI18N
        BTcancelar.setText("Cancelar");
        BTcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTcancelarActionPerformed(evt);
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

        BTgrabar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTgrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/GUARDAR.png"))); // NOI18N
        BTgrabar.setText("Guardar");
        BTgrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTgrabarActionPerformed(evt);
            }
        });

        BTmodificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/EDITAR.png"))); // NOI18N
        BTmodificar.setText("Editar");
        BTmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTmodificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXdescripcion))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXdireccion)))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BTgrabar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTcancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTmodificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTsalir)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(TXdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTgrabar)
                    .addComponent(BTcancelar)
                    .addComponent(BTmodificar)
                    .addComponent(BTsalir))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Buscar:");

        TXbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXbuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXbuscarKeyTyped(evt);
            }
        });

        TBalmacen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Dirección", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBalmacen.getTableHeader().setReorderingAllowed(false);
        TBalmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBalmacenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBalmacen);
        if (TBalmacen.getColumnModel().getColumnCount() > 0) {
            TBalmacen.getColumnModel().getColumn(0).setResizable(false);
            TBalmacen.getColumnModel().getColumn(1).setResizable(false);
            TBalmacen.getColumnModel().getColumn(1).setPreferredWidth(200);
            TBalmacen.getColumnModel().getColumn(2).setResizable(false);
            TBalmacen.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TXbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
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

    private void BTgrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTgrabarActionPerformed
        // TODO add your handling code here:
        Guardar();
    }//GEN-LAST:event_BTgrabarActionPerformed

    private void BTcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTcancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_BTcancelarActionPerformed

    private void BTmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTmodificarActionPerformed
        // TODO add your handling code here:
        Editar();
    }//GEN-LAST:event_BTmodificarActionPerformed

    private void BTsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BTsalirActionPerformed

    private void TXbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXbuscarKeyReleased
        // TODO add your handling code here:
        //ctrl.VisualizarEnTabla("v_material", jTable1, " where material_descripcion like '%"+jTextField1.getText().trim()+"%'");
    }//GEN-LAST:event_TXbuscarKeyReleased

    private void TBalmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBalmacenMouseClicked
        // TODO add your handling code here:
        Pasar();
    }//GEN-LAST:event_TBalmacenMouseClicked

    private void TXbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXbuscarKeyTyped
        // TODO add your handling code here:
        ctrl.BuscarJtable(TXbuscar, TBalmacen, 1);
    }//GEN-LAST:event_TXbuscarKeyTyped

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
            java.util.logging.Logger.getLogger(DLG_Mantenimiento_Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DLG_Mantenimiento_Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DLG_Mantenimiento_Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DLG_Mantenimiento_Almacen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DLG_Mantenimiento_Almacen dialog = new DLG_Mantenimiento_Almacen(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BTgrabar;
    private javax.swing.JButton BTmodificar;
    private javax.swing.JButton BTsalir;
    private javax.swing.JTable TBalmacen;
    private javax.swing.JTextField TXbuscar;
    private javax.swing.JTextField TXdescripcion;
    private javax.swing.JTextField TXdireccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void Guardar() {
        if(TXdescripcion.getText().trim().length()==0 || TXdireccion.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no ingreso algún dato.");
            ctrl.Maracar(TXdescripcion);
        }
        else
        {
            ctrl.GrabarData("almacen","descripcion,direccion,estado","'"+TXdescripcion.getText().trim()+"','"+TXdireccion.getText().trim()+"','1'");
            Cancelar();
        }
    }

    private void Cancelar() {
        TXbuscar.setText("");
        TXdescripcion.setText("");
        TXdireccion.setText("");
        ctrl.VisualizarEnTabla("almacen", TBalmacen,"");
        Activabotones(true, false);
    }

    private void Editar() {
        if(TXdescripcion.getText().trim().length()==0 || TXdireccion.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no ingreso algún dato.");
            ctrl.Maracar(TXdescripcion);
        }
        else
        {
            ctrl.ActualizarData("almacen", "descripcion='"+TXdescripcion.getText().trim()+"',direccion='"+TXdireccion.getText().trim()+"'", "id_almacen='"+ctrl.ValorTabla(TBalmacen, 0)+"'");
            Cancelar();
        }
    }

    private void Pasar() {
        TXdescripcion.setText(TBalmacen.getValueAt(TBalmacen.getSelectedRow(), 1).toString().trim());
        TXdireccion.setText(TBalmacen.getValueAt(TBalmacen.getSelectedRow(), 2).toString().trim());
        Activabotones(false, true);
        ctrl.Maracar(TXdescripcion);
    }
    private void Activabotones(boolean a,boolean b)
    {
        BTgrabar.setEnabled(a);
        BTmodificar.setEnabled(b);
    }
}
