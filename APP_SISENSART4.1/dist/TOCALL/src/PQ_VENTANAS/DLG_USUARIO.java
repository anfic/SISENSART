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
public class DLG_USUARIO extends javax.swing.JDialog {

    CLS_Controlador ctrl=new CLS_Controlador();

    public DLG_USUARIO(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ctrl.CerrarVentanaESC(this);
        Cancelar();
        ctrl.LlenarCombo(CBcago, "select * from cargo", 2);
        ctrl.LlenarCombo(CBcago1, "select * from area", 2);
    }
    private void Cancelar()
    {
        TXnombre.setText("");
        TXnick.setText("");
        TXcontraseña.setText("");
        CBtipo.setSelectedIndex(0);
        CBcago.setSelectedIndex(-1);
        CBcago1.setSelectedIndex(-1);
        TXurl.setText("");
        LBfoto.setIcon(null);
        ctrl.VisualizarDataEscogidaEnTabla("usuario_id_usuario,usuario_nombres_apellidos,usuario_nick,usuario_pass,usuario_tipo_usuario,usuario_estado,cargo_descripcion,area_descripcion", "v_usuario", TBusuario, "");
        Activabotones(true, false);
    }
    private void Pasar()
    {
        TXnombre.setText(ctrl.ValorTabla(TBusuario, 1));
        TXnick.setText(ctrl.ValorTabla(TBusuario, 2));
        TXcontraseña.setText(ctrl.ValorTabla(TBusuario, 3));
        CBtipo.setSelectedItem(ctrl.ValorTabla(TBusuario, 4));
        CBcago.setSelectedItem(ctrl.ValorTabla(TBusuario, 6));
        CBcago1.setSelectedItem(ctrl.ValorTabla(TBusuario, 7));
        Activabotones(false, true);
        ctrl.Maracar(TXnombre);
    }
    private void Grabar()
    {
        if(TXnombre.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Un no ingresó el nombre del usuario.");
            TXnombre.requestFocus();
        }
        else if(TXnick.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Un no ingresó el nick del usuario.");
            TXnick.requestFocus();
        }
        else if(TXcontraseña.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Un no ingresó la contraseña del usuario.");
            TXcontraseña.requestFocus();
        }
        else if(CBtipo.getSelectedIndex()==-1)
        {
            ctrl.mensaje.MensajeAlerta("Un no seleccionó el tipo de usuario.");
            CBtipo.requestFocus();
        }
        else if(CBcago.getSelectedIndex()==-1)
        {
            ctrl.mensaje.MensajeAlerta("Un no seleccionó el cargo del usuario.");
            CBcago.requestFocus();
        }
        else if(CBcago1.getSelectedIndex()==-1)
        {
            ctrl.mensaje.MensajeAlerta("Un no seleccionó el area del usuario.");
            CBcago.requestFocus();
        }
        else
        {
            String nom,nik,con,tipo,car,ar;
            nom=TXnombre.getText().trim();
            nik=TXnick.getText().trim();
            con=TXcontraseña.getText().trim();
            tipo=CBtipo.getSelectedItem().toString().trim();
            car=ctrl.ObtenerCodigo("cargo", "descripcion", CBcago.getSelectedItem().toString().trim(), 1);
            ar=ctrl.ObtenerCodigo("area", "descripcion", CBcago1.getSelectedItem().toString().trim(), 1);
            ctrl.GrabarData("usuario", "nombres_apellidos,nick,pass,tipo_usuario,estado,id_cargo,id_area", "'"+nom+"','"+nik+"','"+con+"','"+tipo+"',2,'"+car+"','"+ar+"'");
            Cancelar();
        }     
    }
    private void Editar()
    {
        if(TXnombre.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Un no ingresó el nombre del usuario.");
            TXnombre.requestFocus();
        }
        else if(TXnick.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Un no ingresó el nick del usuario.");
            TXnick.requestFocus();
        }
        else if(TXcontraseña.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Un no ingresó la contraseña del usuario.");
            TXcontraseña.requestFocus();
        }
        else if(CBtipo.getSelectedIndex()==-1)
        {
            ctrl.mensaje.MensajeAlerta("Un no seleccionó el tipo de usuario.");
            CBtipo.requestFocus();
        }
        else if(CBcago.getSelectedIndex()==-1)
        {
            ctrl.mensaje.MensajeAlerta("Un no seleccionó el cargo del usuario.");
            CBcago.requestFocus();
        }
        else
        {
            ctrl.ActualizarData("usuario", "nombres_apellidos='"+TXnombre.getText().trim()+"',nick='"+TXnick.getText().trim()+"',pass='"+TXcontraseña.getText().trim()+"',estado='2',tipo_usuario='"+CBtipo.getSelectedItem().toString().trim()+"',id_cargo='"+ctrl.ObtenerCodigo("cargo", "descripcion", CBcago.getSelectedItem().toString().trim(), 1)+"',id_area='"+ctrl.ObtenerCodigo("area", "descripcion", CBcago1.getSelectedItem().toString().trim(), 1)+"'", "id_usuario='"+ctrl.ValorTabla(TBusuario, 0)+"'");
            Cancelar();
        }     
    }
    private void Activabotones(boolean a,boolean b)
    {
        BTgrabar.setEnabled(a);
        BTeditar.setEnabled(b);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TXnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TXnick = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TXcontraseña = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        CBtipo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        CBcago = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LBfoto = new javax.swing.JLabel();
        TXurl = new javax.swing.JTextField();
        BTsubirFoto = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBusuario = new javax.swing.JTable();
        BTgrabar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        BTeditar = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        CBcago1 = new javax.swing.JComboBox();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VENTANA DE MANTENIMIENTO DE USUARIOS");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "REGISTRO DE USUARIOS:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nombres:");

        TXnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXnombreKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nick:");

        TXnick.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXnickKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Contraseña:");

        TXcontraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXcontraseñaKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Tipo de Usuario:");

        CBtipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SUPER ADMINISTRADOR", "ADMINISTRADOR", "SOLICITANTE" }));
        CBtipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CBtipoKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Cargo:");

        CBcago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CBcagoFocusGained(evt);
            }
        });
        CBcago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CBcagoKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("URL:");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Firma Digital:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LBfoto, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LBfoto, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
        );

        TXurl.setEditable(false);
        TXurl.setBackground(new java.awt.Color(255, 255, 102));
        TXurl.setColumns(13);

        BTsubirFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CARPETA1.png"))); // NOI18N
        BTsubirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTsubirFotoActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/ACTUALIZAR.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TBusuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Usuario", "Nick", "Contraseña", "Tipo", "Estado", "Cargo", "Area"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBusuario.getTableHeader().setReorderingAllowed(false);
        TBusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBusuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBusuario);

        BTgrabar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTgrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/GUARDAR.png"))); // NOI18N
        BTgrabar.setText("Grabar");
        BTgrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTgrabarActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CANCELAR.png"))); // NOI18N
        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/SALIR.png"))); // NOI18N
        jButton6.setText("Salir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CARPETA1.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Area:");

        CBcago1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CBcago1FocusGained(evt);
            }
        });
        CBcago1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CBcago1KeyPressed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CARPETA1.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBtipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TXnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(TXnick, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TXcontraseña))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CBcago1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CBcago, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BTgrabar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTeditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXurl, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTsubirFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6)
                            .addComponent(TXurl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTsubirFoto)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(TXnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(TXnick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(TXcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(CBtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel5)
                                    .addComponent(CBcago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7)))
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(CBcago1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTgrabar)
                    .addComponent(jButton4)
                    .addComponent(BTeditar)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BTsubirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTsubirFotoActionPerformed
        // TODO add your handling code here:
        ctrl.Foto(LBfoto, TXurl,280,114);
    }//GEN-LAST:event_BTsubirFotoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CBcagoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CBcagoFocusGained
        // TODO add your handling code here:
        ctrl.LlenarCombo(CBcago, "select * from cargo", 2);
    }//GEN-LAST:event_CBcagoFocusGained

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        DLG_CARGOS dlg=new DLG_CARGOS(null,true);
        dlg.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void TBusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBusuarioMouseClicked
        // TODO add your handling code here:
        Pasar();
        ctrl.ValidarFoto("usuario", "usuario.id_usuario", "firma",ctrl.ValorTabla(TBusuario, 0) , 3, LBfoto,280,114);
    }//GEN-LAST:event_TBusuarioMouseClicked

    private void TXnombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXnombreKeyPressed
        // TODO add your handling code here:
        ctrl.PulsarEnter(evt, TXnick);
    }//GEN-LAST:event_TXnombreKeyPressed

    private void TXnickKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXnickKeyPressed
        // TODO add your handling code here:
        ctrl.PulsarEnter(evt, TXcontraseña);
    }//GEN-LAST:event_TXnickKeyPressed

    private void TXcontraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXcontraseñaKeyPressed
        // TODO add your handling code here:
        ctrl.PulsarEnter(evt, CBtipo);
    }//GEN-LAST:event_TXcontraseñaKeyPressed

    private void CBtipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBtipoKeyPressed
        // TODO add your handling code here:
        ctrl.PulsarEnter(evt, CBcago);
    }//GEN-LAST:event_CBtipoKeyPressed

    private void CBcagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBcagoKeyPressed
        // TODO add your handling code here:
        ctrl.PulsarEnter(evt, CBcago1);
    }//GEN-LAST:event_CBcagoKeyPressed

    private void BTgrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTgrabarActionPerformed
        // TODO add your handling code here:
        Grabar();
    }//GEN-LAST:event_BTgrabarActionPerformed

    private void BTeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTeditarActionPerformed
        // TODO add your handling code here:
        Editar();
    }//GEN-LAST:event_BTeditarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(TBusuario.getSelectedRow()==-1 || TBusuario.getRowCount()==0)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó al usuario.");
        }
        else if(TXurl.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó la firma digital del usuario");
            BTsubirFoto.doClick();
        }
        else
        {
            ctrl.Actualizarfoto(TXurl.getText().trim(), "usuario", "firma","usuario.id_usuario", TBusuario, 0);
            Cancelar();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CBcago1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CBcago1FocusGained
        // TODO add your handling code here:
        ctrl.LlenarCombo(CBcago1, "select * from area", 2);
    }//GEN-LAST:event_CBcago1FocusGained

    private void CBcago1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBcago1KeyPressed
        // TODO add your handling code here:
        ctrl.PulsarEnter(evt, BTgrabar);
    }//GEN-LAST:event_CBcago1KeyPressed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        DLG_AREA dlg=new DLG_AREA(null, true);
        dlg.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(DLG_USUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DLG_USUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DLG_USUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DLG_USUARIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DLG_USUARIO dialog = new DLG_USUARIO(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BTeditar;
    private javax.swing.JButton BTgrabar;
    private javax.swing.JButton BTsubirFoto;
    private javax.swing.JComboBox CBcago;
    private javax.swing.JComboBox CBcago1;
    private javax.swing.JComboBox CBtipo;
    private javax.swing.JLabel LBfoto;
    private javax.swing.JTable TBusuario;
    private javax.swing.JPasswordField TXcontraseña;
    private javax.swing.JTextField TXnick;
    private javax.swing.JTextField TXnombre;
    private javax.swing.JTextField TXurl;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
