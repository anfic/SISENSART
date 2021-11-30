/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PQ_VENTANAS;

import PQ_CONTROLADORES.CLS_Controlador;
import PQ_CONTROLADORES.Reportes;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Andy Figueroa
 */
public class IFRM_REQUERIMEINTO extends javax.swing.JInternalFrame {

    CLS_Controlador ctrl=new CLS_Controlador();
    Reportes reporte=new Reportes();
    /**
     * Creates new form IFRM_REQUERIMEINTO
     */
    public IFRM_REQUERIMEINTO() {
        initComponents();
        ctrl.ComboAutoCompletivo(CBsolicitante, "nombres", "usuario", "and estado=1");
        CancelarDatosGeneralesRequerimiento();
        ctrl.LlenarCombo(CBcolor, "select * from color", 2);
        ctrl.LlenarCombo(CBmarca, "select * from marcarq", 2);
        
    }
    private void CancelarDatosGeneralesRequerimiento()
    {
        CBprioridad.setSelectedIndex(0);
        ctrl.VisualizarEnTabla("v_requerimiento", TBrequerimiento, "where requerimiento_estado=1 or requerimiento_estado=2");
        ctrl.VisualizarEnTabla("obra", TBobra, "where estado=1");
        ctrl.VisualizarDataEscogidaEnTabla("material_id_material,material_descripcion,unidad_abreviatura,tipo_material_descripcion", "v_material", TBmaterial, "");
        CBsolicitante.setSelectedIndex(-1);
    }
    private void Generar()
    {
        if(CBsolicitante.getSelectedIndex()==-1)
        {
            ctrl.mensaje.MensajeError("Ud. no seleccionó al solicitante del requerimeinto");
            CBsolicitante.requestFocus();
        }
        else if(TBobra.getSelectedRow()==-1)
        {
            ctrl.mensaje.MensajeError("Ud. no seleccionó ninguna obra.");
            ctrl.Maracar(TXbuscar_obra);
        }
        else
        {
            String solicitante=ctrl.ObtenerCodigo("usuario", "nombres", CBsolicitante.getSelectedItem().toString().trim(), 1);
            String obra=TBobra.getValueAt(TBobra.getSelectedRow(), 0).toString().trim();
            String cronograma_envio = "";
            if(checkCronograma.isSelected()){
                cronograma_envio = "SI";
            }else{
                cronograma_envio = "NO";
            }
            ctrl.GrabarData("requerimiento", "fecha,prioridad,estado,id_usuario,id_obra,cronograma_envio,lugar_arribo", "'"+ctrl.Fecha()+" "+ctrl.Hora()+"','"+CBprioridad.getSelectedItem().toString().substring(0, 1).trim()+"',1,'"+solicitante+"','"+obra+"','"+cronograma_envio+"','"+txtArribo.getText()+"'");
            CancelarDatosGeneralesRequerimiento();
        }
    }
    private void Detallar()
    {
        if (TBrequerimiento.getSelectedRow()==-1)
        {
            ctrl.mensaje.MensajeError("Ud. no seleccionó un requerimeinto");
        }
        else
        {
            String codigo=TBrequerimiento.getValueAt(TBrequerimiento.getSelectedRow(), 0).toString().trim();
            ctrl.ActualizarData("REQUERIMIENTO", "estado=2", "id_requerimiento='"+codigo+"'");
            TXcodigo_requerimiento.setText(codigo);
            CancelarDatosGeneralesRequerimiento();
            jTabbedPane1.setSelectedIndex(1);
            CancelarDatosGeneralesRequerimiento();
            CancelarDetalle();
        }
    }
    public void NoEscribe(KeyEvent evt,JTextField tx)
    {
        int pos=TBmaterial.getSelectedRow();
        if(pos==-1 || TXcodigo_requerimiento.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Requerimiento o material no seleccionados");
            ctrl.NoEscribe(evt);
            TXbuscar_material.requestFocus();
        }
    }
    private void Adicionar()
    {
        if(TXcodigo_requerimiento.getText().toCharArray().length==0)
        {
            ctrl.mensaje.MensajeAlerta("No se seleccionó ningún requerimiento");
            jTabbedPane1.setSelectedIndex(0);
        }
        else if(TBmaterial.getSelectedRow()==-1)
        {
            ctrl.mensaje.MensajeAlerta("No se seleccionó ningún material.");
            ctrl.Maracar(TXbuscar_material);
        }
        else if(Double.parseDouble(TXcantidad.getText().trim())<=0.0)
        {
            ctrl.mensaje.MensajeAlerta("Cantidad incorrecta.");
            ctrl.Maracar(TXcantidad);
        }
        else
        {
            String mat=TBmaterial.getValueAt(TBmaterial.getSelectedRow(),0).toString().trim();
            String cod_req=TXcodigo_requerimiento.getText().trim();
            Double cantidad=Double.parseDouble(TXcantidad.getText().trim());
            String obs=TXAobservacion.getText().trim();
            String mmtteett=TXeett.getText().trim();
            String mar=ctrl.ObtenerCodigo("marcarq", "descripcion", CBmarca.getSelectedItem().toString().trim(), 1);
            String color=ctrl.ObtenerCodigo("color", "descripcion", CBcolor.getSelectedItem().toString().trim(), 1);
            String prior=CBpriori.getSelectedItem().toString().trim();
            ctrl.GrabarData("detalle_requerimiento", "id_material,id_requerimiento,cantidad,observacion,mm_tt_eett,marcarq_idmarcarq,color_idcolor,prioridad", "'"+mat+"','"+cod_req+"','"+cantidad+"','"+obs+"','"+mmtteett+"','"+mar+"','"+color+"','"+prior+"'");
            CancelarDetalle();
        }
    }
    private void CancelarDetalle()
    {
        TXbuscar_material.setText("");
        CancelarDatosGeneralesRequerimiento();
        TXcantidad.setText("0.0");
        TXAobservacion.setText("");
        TXeett.setText("");
        CBmarca.setSelectedIndex(-1);
        CBcolor.setSelectedIndex(-1);
        CBpriori.setSelectedIndex(0);
        ctrl.VisualizarEnTabla("v_detalle_requerimiento", TBdetalle, "where detalle_requerimiento_id_requerimiento='"+TXcodigo_requerimiento.getText().trim()+"'");
        TXbuscar_material.requestFocus();
    }
    private void Enviar()
    {
        if(TXcodigo_requerimiento.getText().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Para enviar un requerimiento Ud. debe de generarlo y luego detallarlo.");
            BTenviar.doClick();
        }
        else if(TBdetalle.getRowCount()==0)
        {
            ctrl.mensaje.MensajeAlerta("Al menos debe de haber un detalle como mínimo.");
            TXbuscar_material.requestFocus();
        }
        else
        {
            ctrl.ActualizarData("REQUERIMIENTO","estado=3", "id_requerimiento='"+TXcodigo_requerimiento.getText().trim()+"'");
            reporte.Reporte_1Parametro_Imagen("RPT_REQUERIMIENTOS.jasper", "p_codigo", TXcodigo_requerimiento.getText().trim(), "p_logo", "/PQ_IMAGENES/LogoSantisimaCruzEdit.png");
            BTcancelar.doClick();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CBprioridad = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        CBsolicitante = new javax.swing.JComboBox();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        lblArribo = new javax.swing.JLabel();
        txtArribo = new javax.swing.JTextField();
        checkCronograma = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBrequerimiento = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        TXbuscar_requerimiento = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        TXbuscar_obra = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        TBobra = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TXbuscar_material = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBmaterial = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        TXcantidad = new javax.swing.JTextField();
        BTadicionar = new javax.swing.JButton();
        BTquitar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TBdetalle = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        BTenviar = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        TXcodigo_requerimiento = new javax.swing.JTextField();
        BTcancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        TXeett = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        CBmarca = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        CBcolor = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        CBpriori = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        TXAobservacion = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("VENTANA DE SOLICITUD DE MATERIALES - REQUERIMIENTOS");
        setToolTipText(this.getTitle());

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Datos Generales de Requerimiento:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Fecha de Requerimiento:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Prioridad:");

        CBprioridad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 - ALTA", "2 - MEDIA", "3 - BAJA" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Solicitante (Nombres y Apellidos):");

        CBsolicitante.setEditable(true);
        CBsolicitante.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        dateChooserCombo1.setFormat(2);
        dateChooserCombo1.setEnabled(false);

        lblArribo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblArribo.setText("Lugar de Arribo");

        txtArribo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArriboActionPerformed(evt);
            }
        });

        checkCronograma.setText("Adjunta Cronograma de Envío");
        checkCronograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCronogramaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CBprioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(lblArribo))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtArribo)
                            .addComponent(CBsolicitante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dateChooserCombo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(checkCronograma)
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkCronograma))
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBprioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBsolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblArribo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtArribo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Vista de Requerimientos Generados:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        TBrequerimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Fecha", "Prioridad", "Estado", "Obra", "Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBrequerimiento.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TBrequerimiento);
        if (TBrequerimiento.getColumnModel().getColumnCount() > 0) {
            TBrequerimiento.getColumnModel().getColumn(0).setPreferredWidth(50);
            TBrequerimiento.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Buscar (Solicitante):");

        TXbuscar_requerimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXbuscar_requerimientoKeyReleased(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/DETALLAR.png"))); // NOI18N
        jButton2.setText("Detallar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("En esta tabla solo se visualizan los requerimientos GENERADOS y DETALLADOS.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXbuscar_requerimiento)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 425, Short.MAX_VALUE)
                .addComponent(jButton2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TXbuscar_requerimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel9)))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Selección de Obra:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/GENERAR.png"))); // NOI18N
        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Obra:");

        TXbuscar_obra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXbuscar_obraKeyReleased(evt);
            }
        });

        TBobra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBobra.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(TBobra);
        if (TBobra.getColumnModel().getColumnCount() > 0) {
            TBobra.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CARPETA1.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXbuscar_obra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(TXbuscar_obra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Datos de Requerimiento", jPanel4);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Detalle de requerimiento:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Material:");

        TXbuscar_material.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXbuscar_materialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXbuscar_materialKeyReleased(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CARPETA1.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        TBmaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Unidad", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBmaterial.getTableHeader().setReorderingAllowed(false);
        TBmaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TBmaterialKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(TBmaterial);
        if (TBmaterial.getColumnModel().getColumnCount() > 0) {
            TBmaterial.getColumnModel().getColumn(0).setResizable(false);
            TBmaterial.getColumnModel().getColumn(1).setResizable(false);
            TBmaterial.getColumnModel().getColumn(1).setPreferredWidth(300);
            TBmaterial.getColumnModel().getColumn(2).setResizable(false);
            TBmaterial.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Cantidad:");

        TXcantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXcantidad.setText("0.0");
        TXcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXcantidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXcantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXcantidadKeyTyped(evt);
            }
        });

        BTadicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/ADICIONAR.png"))); // NOI18N
        BTadicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTadicionarActionPerformed(evt);
            }
        });

        BTquitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/RESTAR.png"))); // NOI18N
        BTquitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTquitarActionPerformed(evt);
            }
        });

        TBdetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C. Mat.", "Material", "Requerimiento", "Cantidad", "Unidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBdetalle.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TBdetalle);
        if (TBdetalle.getColumnModel().getColumnCount() > 0) {
            TBdetalle.getColumnModel().getColumn(0).setResizable(false);
            TBdetalle.getColumnModel().getColumn(1).setResizable(false);
            TBdetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
            TBdetalle.getColumnModel().getColumn(2).setResizable(false);
            TBdetalle.getColumnModel().getColumn(3).setResizable(false);
            TBdetalle.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/VER.png"))); // NOI18N
        jButton6.setText("Vista Rápida");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        BTenviar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTenviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/ENVIAR.png"))); // NOI18N
        BTenviar.setText("Enviar");
        BTenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTenviarActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/SALIR.png"))); // NOI18N
        jButton8.setText("Salir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 204, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Código de Requerimiento:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        TXcodigo_requerimiento.setEditable(false);
        TXcodigo_requerimiento.setBackground(new java.awt.Color(255, 204, 0));
        TXcodigo_requerimiento.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TXcodigo_requerimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TXcodigo_requerimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TXcodigo_requerimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        BTcancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CANCELAR.png"))); // NOI18N
        BTcancelar.setText("Cancelar");
        BTcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTcancelarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("MM/TT/EETT:");

        TXeett.setBackground(new java.awt.Color(255, 255, 153));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Marca:");

        CBmarca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CBmarcaFocusGained(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Color:");

        CBcolor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CBcolorFocusGained(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Prioridad:");

        CBpriori.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CBpriori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NECESARIO", "PRIORITARIO", "EMERGENCIA" }));

        TXAobservacion.setColumns(20);
        TXAobservacion.setRows(5);
        TXAobservacion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Observación:"));
        jScrollPane6.setViewportView(TXAobservacion);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CARPETA1.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CARPETA1.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTcancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTenviar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(BTadicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTquitar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXbuscar_material, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CBpriori, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(CBmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CBcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(TXcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXeett, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(TXbuscar_material, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6)
                            .addComponent(TXcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(TXeett, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel11)
                            .addComponent(CBmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(CBcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel13)
                            .addComponent(CBpriori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTadicionar)
                    .addComponent(jButton8)
                    .addComponent(BTcancelar)
                    .addComponent(jButton6)
                    .addComponent(BTenviar)
                    .addComponent(BTquitar))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane1.addTab("Detalle de Requerimiento", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int resp=JOptionPane.showConfirmDialog(null, "Está seguro de generar este requerimiento.","Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(resp==0)
        {
            Generar();
            ctrl.VisualizarEnTabla("v_requerimiento", TBrequerimiento, "where requerimiento_estado=1 or requerimiento_estado=2");
        }
        else if(resp==1)
        {
            CancelarDatosGeneralesRequerimiento();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DLG_OBRAS ob=new DLG_OBRAS(null,true);
        ob.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void TXbuscar_obraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXbuscar_obraKeyReleased
        // TODO add your handling code here:
        ctrl.VisualizarEnTabla("obra", TBobra, "where estado=1 and descripcion like '%"+TXbuscar_obra.getText().trim()+"%'");
    }//GEN-LAST:event_TXbuscar_obraKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int resp=JOptionPane.showConfirmDialog(null, "Está seguro que desea detallar este requerimiento.\n¡El requerimiento cambiará de estado a detallado!","Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(resp==0)
        {
            Detallar();
        }
        else if(resp==1)
        {
            CancelarDatosGeneralesRequerimiento();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TXbuscar_requerimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXbuscar_requerimientoKeyReleased
        // TODO add your handling code here:
        ctrl.VisualizarEnTabla("v_requerimiento", TBrequerimiento, "where (requerimiento_estado=1 or requerimiento_estado=2) and (usuario_nombres like '%"+TXbuscar_requerimiento.getText().trim()+"%')");
    }//GEN-LAST:event_TXbuscar_requerimientoKeyReleased

    private void BTcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTcancelarActionPerformed
        // TODO add your handling code here:
        TXcodigo_requerimiento.setText("");
        CancelarDetalle();
        jTabbedPane1.setSelectedIndex(0);
        CancelarDatosGeneralesRequerimiento();
    }//GEN-LAST:event_BTcancelarActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void BTenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTenviarActionPerformed
        // TODO add your handling code here:
        int resp=JOptionPane.showConfirmDialog(null, "Desea enviar el requerimiento.","Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(resp==0)
        {
            Enviar();
        }
        else if(resp==1)
        {
            CancelarDatosGeneralesRequerimiento();
        }
    }//GEN-LAST:event_BTenviarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        reporte.Reporte_1Parametro_Imagen("RPT_REQUERIMIENTOS.jasper", "p_codigo", TXcodigo_requerimiento.getText().trim(), "p_logo", "/PQ_IMAGENES/LogoSantisimaCruzEdit.png");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void BTquitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTquitarActionPerformed
        // TODO add your handling code here:
        if(TBdetalle.getRowCount()==0)
        {
            ctrl.mensaje.MensajeAlerta("No hay nada que eliminar del detalle.");
            TXbuscar_material.requestFocus();
        }
        else if(TBdetalle.getSelectedRow()==-1)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó ningún articulo detallado.");
        }
        else
        {
            int pos=TBdetalle.getSelectedRow();
            ctrl.EliminarData("detalle_requerimiento", "where id_material='"+TBdetalle.getValueAt(pos, 0).toString().trim()+"' and id_requerimiento='"+TBdetalle.getValueAt(pos, 2).toString().trim()+"'");
            CancelarDetalle();
        }
    }//GEN-LAST:event_BTquitarActionPerformed

    private void BTadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTadicionarActionPerformed
        // TODO add your handling code here:
        int resp=JOptionPane.showConfirmDialog(null, "Desea adicionar este material.","Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(resp==0)
        {
            Adicionar();
        }
        else if(resp==1)
        {
            CancelarDatosGeneralesRequerimiento();
        }
    }//GEN-LAST:event_BTadicionarActionPerformed

    private void TXcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXcantidadKeyTyped
        // TODO add your handling code here:
        ctrl.SoloNumerosDecimales(evt);
        ctrl.Unpunto(evt, TXcantidad);
        NoEscribe(evt, TXcantidad);
    }//GEN-LAST:event_TXcantidadKeyTyped

    private void TXcantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXcantidadKeyReleased
        // TODO add your handling code here:
        if(TXcantidad.getText().trim().length()==0)
        {
            TXcantidad.setText("0.0");
            ctrl.Maracar(TXcantidad);
        }
    }//GEN-LAST:event_TXcantidadKeyReleased

    private void TXcantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXcantidadKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            TXAobservacion.requestFocus();
        }
    }//GEN-LAST:event_TXcantidadKeyPressed

    private void TBmaterialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBmaterialKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_UP && TBmaterial.getSelectedRow()==0)
        {
            ctrl.Maracar(TXbuscar_material);
        }
        else if(evt.getKeyCode()==evt.VK_RIGHT)
        {
            ctrl.Maracar(TXcantidad);
        }
    }//GEN-LAST:event_TBmaterialKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DLG_MATERIALES mat=new DLG_MATERIALES(null, true);
        mat.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void TXbuscar_materialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXbuscar_materialKeyReleased
        // TODO add your handling code here:
        ctrl.VisualizarDataEscogidaEnTabla("material_id_material,material_descripcion,unidad_abreviatura,tipo_material_descripcion", "v_material", TBmaterial, "where material_descripcion like '%"+TXbuscar_material.getText().trim()+"%'");
    }//GEN-LAST:event_TXbuscar_materialKeyReleased

    private void TXbuscar_materialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXbuscar_materialKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_DOWN && TBmaterial.getRowCount()>0)
        {
            TBmaterial.requestFocus();
        }
    }//GEN-LAST:event_TXbuscar_materialKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        DLG_MarcaRQ dlg=new DLG_MarcaRQ(null,true);
        dlg.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        DLG_ColorRQ dlg=new DLG_ColorRQ(null,true);
        dlg.setVisible(true);
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void CBcolorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CBcolorFocusGained
        // TODO add your handling code here:
        ctrl.LlenarCombo(CBcolor, "select * from color", 2);
    }//GEN-LAST:event_CBcolorFocusGained

    private void CBmarcaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CBmarcaFocusGained
        // TODO add your handling code here:
        ctrl.LlenarCombo(CBmarca, "select * from marcarq", 2);
    }//GEN-LAST:event_CBmarcaFocusGained

    private void txtArriboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArriboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArriboActionPerformed

    private void checkCronogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCronogramaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkCronogramaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTadicionar;
    private javax.swing.JButton BTcancelar;
    private javax.swing.JButton BTenviar;
    private javax.swing.JButton BTquitar;
    private javax.swing.JComboBox<String> CBcolor;
    private javax.swing.JComboBox<String> CBmarca;
    private javax.swing.JComboBox<String> CBpriori;
    private javax.swing.JComboBox CBprioridad;
    private javax.swing.JComboBox CBsolicitante;
    private javax.swing.JTable TBdetalle;
    private javax.swing.JTable TBmaterial;
    private javax.swing.JTable TBobra;
    private javax.swing.JTable TBrequerimiento;
    private javax.swing.JTextArea TXAobservacion;
    private javax.swing.JTextField TXbuscar_material;
    private javax.swing.JTextField TXbuscar_obra;
    private javax.swing.JTextField TXbuscar_requerimiento;
    private javax.swing.JTextField TXcantidad;
    private javax.swing.JTextField TXcodigo_requerimiento;
    private javax.swing.JTextField TXeett;
    private javax.swing.JCheckBox checkCronograma;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblArribo;
    private javax.swing.JTextField txtArribo;
    // End of variables declaration//GEN-END:variables
}
