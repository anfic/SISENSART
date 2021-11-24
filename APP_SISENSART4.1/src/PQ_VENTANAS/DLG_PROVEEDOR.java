/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PQ_VENTANAS;

import PQ_CONTROLADORES.CLS_Controlador;


/**
 *
 * @author USUARIO
 */
public class DLG_PROVEEDOR extends javax.swing.JDialog {

    CLS_Controlador ctrl=new CLS_Controlador();
    /**
     * Creates new form DLG_Proveedor
     */
    public DLG_PROVEEDOR(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ctrl.CerrarVentanaESC(this);
        Limpiar();
    }
    private void Limpiar()
    {
        TXrazon.setText("");
        TXpersonal.setText("");
        TXruc.setText("");
        TXdireccion.setText("");
        TXciudad.setText("");
        TXtelefono.setText("");
        TXcorreo.setText("");
        ctrl.VisualizarEnTabla("proveedor", TBproveedor, "order by id_proveedor");
        Activabotones(true, false);
    }
    private void Grabar()
    {
        if(TXrazon.getText().trim().length()==0 && TXpersonal.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no registro la razon social o representante.");
            TXrazon.requestFocus();
        }
        else if(TXruc.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no ingresó el RUC de la empresa.");
            TXruc.requestFocus();
        }
        else if(TXdireccion.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no ingresó la dirección de la empresa.");
            TXdireccion.requestFocus();
        }
        else if(TXciudad.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no ingresó la ciudad de la empresa.");
            TXciudad.requestFocus();
        }
        else
        {
            ctrl.GrabarData("proveedor", "razon,representante,ruc,direccion,ciudad,telefono,correo", "'"+TXrazon.getText().trim().toUpperCase()+"','"+TXpersonal.getText().trim().toUpperCase()+"','"+TXruc.getText().trim().toUpperCase()+"','"+TXdireccion.getText().trim().toUpperCase()+"','"+TXciudad.getText().trim().toUpperCase()+"','"+TXtelefono.getText().trim().toUpperCase()+"','"+TXcorreo.getText().trim()+"'");
            Limpiar();
        }
    }
    private void Modificar()
    {
        if(TXrazon.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no ingresó la razón social.");
            TXrazon.requestFocus();
        }
        else if(TXruc.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no ingresó el RUC de la empresa.");
            TXruc.requestFocus();
        }
        else if(TXdireccion.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no ingresó la dirección de la empresa.");
            TXdireccion.requestFocus();
        }
        else if(TXciudad.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no ingresó la ciudad de la empresa.");
            TXciudad.requestFocus();
        }
        else
        {
            ctrl.ActualizarData("proveedor", "razon='"+TXrazon.getText().trim().toUpperCase()+"',representante='"+TXpersonal.getText().trim().toUpperCase()+"',"
                    + "ruc='"+TXruc.getText().trim().toUpperCase()+"',direccion='"+TXdireccion.getText().trim().toUpperCase()+"',ciudad='"+TXciudad.getText().trim().toUpperCase()+"',"
                    + "telefono='"+TXtelefono.getText().trim().toUpperCase()+"',correo='"+TXcorreo.getText().trim()+"'","id_proveedor='"+TBproveedor.getValueAt(TBproveedor.getSelectedRow(), 0).toString().trim()+"'" );
            Limpiar();
        }
    }
    private void PasarDatos()
    {
        TXrazon.setText(TBproveedor.getValueAt(TBproveedor.getSelectedRow(), 1).toString().trim());
        TXpersonal.setText(TBproveedor.getValueAt(TBproveedor.getSelectedRow(), 2).toString().trim());
        TXruc.setText(TBproveedor.getValueAt(TBproveedor.getSelectedRow(), 3).toString().trim());
        TXdireccion.setText(TBproveedor.getValueAt(TBproveedor.getSelectedRow(), 4).toString().trim());
        TXciudad.setText(TBproveedor.getValueAt(TBproveedor.getSelectedRow(), 5).toString().trim());
        TXtelefono.setText(TBproveedor.getValueAt(TBproveedor.getSelectedRow(), 6).toString().trim());
        TXcorreo.setText(TBproveedor.getValueAt(TBproveedor.getSelectedRow(), 7).toString().trim());
        Activabotones(false, true);
        ctrl.Maracar(TXrazon);
    }
    private void Activabotones(boolean a,boolean b)
    {
        BTgrabar.setEnabled(a);
        BTmodificar.setEnabled(b);
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
        TXrazon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TXpersonal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TXruc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TXdireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TXciudad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TXtelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TXcorreo = new javax.swing.JTextField();
        BTgrabar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        BTmodificar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        TXbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBproveedor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VENTANA DE MANTENIMIENTO DE PROVEEDORES.");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Datos del Proveedor:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Razón :");

        TXrazon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXrazonKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Persona:");

        TXpersonal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXpersonalKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("RUC:");

        TXruc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXrucKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXrucKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Dirección:");

        TXdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXdireccionKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Ciudad:");

        TXciudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXciudadKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Telefono:");

        TXtelefono.setBackground(new java.awt.Color(255, 255, 102));
        TXtelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXtelefonoKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Correo:");

        TXcorreo.setBackground(new java.awt.Color(255, 255, 102));
        TXcorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXcorreoKeyPressed(evt);
            }
        });

        BTgrabar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTgrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/GUARDAR.png"))); // NOI18N
        BTgrabar.setText("Grabar");
        BTgrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTgrabarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CANCELAR.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        BTmodificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/EDITAR.png"))); // NOI18N
        BTmodificar.setText("Modificar");
        BTmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTmodificarActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/SALIR.png"))); // NOI18N
        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/VER.png"))); // NOI18N
        jLabel7.setText("Buscar:");

        TXbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXbuscarKeyReleased(evt);
            }
        });

        TBproveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Razón", "Persona", "RUC", "Dirección", "Ciudad", "Teléfono", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBproveedor.getTableHeader().setReorderingAllowed(false);
        TBproveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBproveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBproveedor);
        if (TBproveedor.getColumnModel().getColumnCount() > 0) {
            TBproveedor.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(TXrazon, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addComponent(TXpersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addGap(31, 31, 31)
                        .addComponent(TXruc, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(3, 3, 3)
                        .addComponent(TXtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(15, 15, 15)
                        .addComponent(TXcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(BTgrabar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BTmodificar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton4))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(1, 1, 1)
                            .addComponent(TXdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jLabel5)
                            .addGap(14, 14, 14)
                            .addComponent(TXciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXbuscar)
                .addGap(150, 150, 150))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(TXrazon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(TXpersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(TXruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(TXdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(TXciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(TXtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(TXcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(BTmodificar)
                    .addComponent(jButton2)
                    .addComponent(BTgrabar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TXbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
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

    private void TXrucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXrucKeyTyped
        // TODO add your handling code here:
        ctrl.SoloNumeroEnteros(TXruc);
    }//GEN-LAST:event_TXrucKeyTyped

    private void BTgrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTgrabarActionPerformed
        // TODO add your handling code here:
        Grabar();
    }//GEN-LAST:event_BTgrabarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BTmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTmodificarActionPerformed
        // TODO add your handling code here:
        Modificar();
    }//GEN-LAST:event_BTmodificarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void TXrazonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXrazonKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            TXpersonal.requestFocus();
        }
    }//GEN-LAST:event_TXrazonKeyPressed

    private void TXpersonalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXpersonalKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            TXruc.requestFocus();
        }
    }//GEN-LAST:event_TXpersonalKeyPressed

    private void TXrucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXrucKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            TXdireccion.requestFocus();
        }
    }//GEN-LAST:event_TXrucKeyPressed

    private void TXdireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXdireccionKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            TXciudad.requestFocus();
        }
    }//GEN-LAST:event_TXdireccionKeyPressed

    private void TXciudadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXciudadKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            TXtelefono.requestFocus();
        }
    }//GEN-LAST:event_TXciudadKeyPressed

    private void TXtelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXtelefonoKeyPressed
        // TODO add your handling code here:
        ctrl.PulsarEnter(evt, TXcorreo);
    }//GEN-LAST:event_TXtelefonoKeyPressed

    private void TXbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXbuscarKeyReleased
        // TODO add your handling code here:
        Limpiar();
        ctrl.VisualizarEnTabla("proveedor", TBproveedor, "WHERE  razon like('%"+TXbuscar.getText().trim()+"%') or ruc like('%"+TXbuscar.getText().trim()+"%')");
    }//GEN-LAST:event_TXbuscarKeyReleased

    private void TBproveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBproveedorMouseClicked
        // TODO add your handling code here:
        PasarDatos();
    }//GEN-LAST:event_TBproveedorMouseClicked

    private void TXcorreoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXcorreoKeyPressed
        // TODO add your handling code here:
        ctrl.PulsarEnter(evt, BTgrabar);
    }//GEN-LAST:event_TXcorreoKeyPressed

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
            java.util.logging.Logger.getLogger(DLG_PROVEEDOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DLG_PROVEEDOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DLG_PROVEEDOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DLG_PROVEEDOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DLG_PROVEEDOR dialog = new DLG_PROVEEDOR(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BTgrabar;
    private javax.swing.JButton BTmodificar;
    private javax.swing.JTable TBproveedor;
    private javax.swing.JTextField TXbuscar;
    private javax.swing.JTextField TXciudad;
    private javax.swing.JTextField TXcorreo;
    private javax.swing.JTextField TXdireccion;
    private javax.swing.JTextField TXpersonal;
    private javax.swing.JTextField TXrazon;
    private javax.swing.JTextField TXruc;
    private javax.swing.JTextField TXtelefono;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}