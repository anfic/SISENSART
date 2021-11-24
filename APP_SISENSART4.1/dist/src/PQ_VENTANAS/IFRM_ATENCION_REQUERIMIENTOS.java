/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PQ_VENTANAS;

import PQ_CONTROLADORES.CLS_Controlador;
import PQ_CONTROLADORES.Reportes;
import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Andy Figueroa
 */
public class IFRM_ATENCION_REQUERIMIENTOS extends javax.swing.JInternalFrame {

    CLS_Controlador ctrl=new CLS_Controlador();
    Reportes reporte=new Reportes();
    /**
     * Creates new form IFRM_RECEPCION_EVALUACION_REQUERIMIENTOS
     */
    public IFRM_ATENCION_REQUERIMIENTOS() {
        initComponents();
        Visualizar();
    }
    private void Salir()
    {
        if(TXevaluacion.getText().trim().length()>0)
        {
            ctrl.mensaje.MensajeAlerta("El sistema detectó un proceso en ejecución.\nLa ventana no se cerrará hasta culminar la evaluación de materiales.");
            this.setDefaultCloseOperation(0);            
        }
        else
        {
            this.dispose();
        }
        
    }
    private void Visualizar()
    {
        ctrl.VisualizarEnTabla("v_requerimiento", TBrequerimiento, "where requerimiento_estado=3");
        ctrl.VisualizarEnTabla("v_requerimiento", TBrequerimiento1, "where requerimiento_estado=4");
    }
    private void Recepcionar()
    {
        if(TBrequerimiento.getRowCount()==0)
        {
            ctrl.mensaje.MensajeAlerta("No hay ningún requerimeinto para Recepcionar.");
            this.dispose();
        }
        else if(TBrequerimiento.getSelectedRow()==-1)
        {
            ctrl.mensaje.MensajeError("Ud. no seleccionó ningún requerimeinto a recepcionar.");
        }
        else
        {
            int resp=JOptionPane.showConfirmDialog(null,"¿Desea recepcionar este requerimiento -"+TBrequerimiento.getValueAt(TBrequerimiento.getSelectedRow(), 0).toString()+"-?.","Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(resp==0)
            {
                ctrl.ActualizarData("requerimiento", "estado=4", "id_requerimiento='"+TBrequerimiento.getValueAt(TBrequerimiento.getSelectedRow(), 0).toString()+"'");
                reporte.Reporte_1Parametro_Imagen("RPT_REQUERIMIENTOS.jasper", "p_codigo", TBrequerimiento.getValueAt(TBrequerimiento.getSelectedRow(), 0).toString().trim(), "p_logo", "/PQ_IMAGENES/LogoSantisimaCruzEdit.png");
                Visualizar();
            }
            else
            {
                Visualizar();
            }
        }
    }
    private void MaterialEvaluado()
    {
        if(TBdetalle.getRowCount()==0)
        {
            ctrl.mensaje.MensajeAlerta("No hay nada para evaluar.");
            jTabbedPane1.setSelectedIndex(0);
        }
        else if(TBdetalle.getSelectedRow()==-1)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó ningún material para ser evaluado.");
        }
        else if(TBdetalle.getValueAt(TBdetalle.getSelectedRow(), 3).toString().trim().length()==0)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no ingrsó la cantidad del material evaluado.");
        }
        else
        {
            int pos=TBdetalle.getSelectedRow();
            String material=TBdetalle.getValueAt(pos, 0).toString().trim();
            String req=TBdetalle.getValueAt(pos, 2).toString().trim();
            String can=TBdetalle.getValueAt(pos, 3).toString().trim();
            String obs=TXobservacion.getText().trim();
            ctrl.GrabarData("detalle_evaluacion", "evaluacion_requerimiento_id_evaluacion,detalle_requerimiento_id_material,detalle_requerimiento_id_requerimiento,cantidad,observacion", "'"+TXevaluacion.getText().trim()+"','"+material+"','"+req+"','"+can+"','"+obs+"'");
            ctrl.VisualizarEnTabla("v_detalle_evaluacion", TBevaluacion, "where detalle_evaluacion_evaluacion_requerimiento_id_evaluacion='"+TXevaluacion.getText().trim()+"'");
            TXobservacion.setText("");
        }
    }
    private void Seleccionar()
    {
        if(TBrequerimiento1.getRowCount()==0)
        {
            ctrl.mensaje.MensajeAlerta("No hay nada que seleccionar");
        }
        else if(TBrequerimiento1.getSelectedRow()==-1)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó ningún requerimiento recepcionado.");
        }
        else
        {
            TXrequerimiento.setText(TBrequerimiento1.getValueAt(TBrequerimiento1.getSelectedRow(), 0).toString());
            ctrl.ActualizarData("requerimiento", "estado=5", "id_requerimiento='"+TBrequerimiento1.getValueAt(TBrequerimiento1.getSelectedRow(), 0).toString()+"'");
            ctrl.VisualizarDataEscogidaEnTabla("detalle_requerimiento_id_material,material_descripcion,detalle_requerimiento_id_requerimiento,detalle_requerimiento_cantidad,unidad_abreviatura", "v_detalle_requerimiento", TBdetalle, "where detalle_requerimiento_id_requerimiento='"+TBrequerimiento1.getValueAt(TBrequerimiento1.getSelectedRow(),0).toString().trim()+"'");
            Visualizar();
            jTabbedPane1.setSelectedIndex(1);
            ctrl.GrabarData("evaluacion_requerimiento", "fecha_evaluacion", "'"+ctrl.Fecha()+" "+ctrl.Hora()+"'");
            TXevaluacion.setText(ctrl.UltimoCodigo("id_evaluacion", "evaluacion_requerimiento"));
            jTabbedPane1.setEnabled(false);
        }
    }
    private void Aprobar()
    {
        if(TBevaluacion.getRowCount()==0)
        {
            ctrl.mensaje.MensajeAlerta("No hay nada que aprobar.\n Verifique por favor.");
        }
        else
        {
            int resp=JOptionPane.showConfirmDialog(null,"Desea aprobar estos ... "+TBevaluacion.getRowCount()+" ... requerimientos?","Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
            if(resp==JOptionPane.YES_OPTION)
            {
                ctrl.ActualizarData("requerimiento", "estado=6", "id_requerimiento='"+TBdetalle.getValueAt(0, 2).toString().trim()+"'");
                reporte.Reporte_1Parametro_Imagen("RPT_EVALUACION.jasper", "p_codigo", TXevaluacion.getText().trim(), "p_logo", "/PQ_IMAGENES/LogoSantisimaCruzEdit.png");
                LimpiarSeleccion();
            }
        }
    }
    public void LimpiarSeleccion()
    {
        TXevaluacion.setText("");
        ctrl.LimpiarTabla(TBdetalle);
        TXobservacion.setText("");
        ctrl.LimpiarTabla(TBevaluacion);
        jTabbedPane1.setEnabled(true);
        jTabbedPane1.setSelectedIndex(0);
        TXrequerimiento.setText("");
        Visualizar();
    }
    private void Desaprobar()
    {
        if(TBevaluacion.getRowCount()>0)
        {
            ctrl.mensaje.MensajeAlerta("No se puede desaprobar la evaluacion ya que hay evaluaciones agregadas.");
        }
        else
        {
            ctrl.ActualizarData("requerimiento", "estado=8", "id_requerimiento='"+TBdetalle.getValueAt(0, 2).toString().trim()+"'");
            LimpiarSeleccion();
        }
    }
    private void Quitar()
    {
        if(TBevaluacion.getRowCount()==0)
        {
            ctrl.mensaje.MensajeAlerta("No hay nada que quitar de la evaluación.");
        }
        else if(TBevaluacion.getSelectedRow()==-1)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó ninguna fila a quitar de la evaluación");
        }
        else
        {
            int pos=TBevaluacion.getSelectedRow();
            String ev=TBevaluacion.getValueAt(pos, 0).toString().trim();
            String mat=TBevaluacion.getValueAt(pos, 1).toString().trim();
            String req=TBevaluacion.getValueAt(pos, 3).toString().trim();
            ctrl.EliminarData("detalle_evaluacion", "where evaluacion_requerimiento_id_evaluacion='"+ev+"' and detalle_requerimiento_id_material='"+mat+"' and detalle_requerimiento_id_requerimiento='"+req+"'");
            ctrl.VisualizarEnTabla("v_detalle_evaluacion", TBevaluacion, "where detalle_evaluacion_evaluacion_requerimiento_id_evaluacion='"+TXevaluacion.getText().trim()+"'");
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TBrequerimiento1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBrequerimiento = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TBdetalle = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        TXevaluacion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBevaluacion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TXobservacion = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        TXbuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TXrequerimiento = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("VENTANA DE ATENCIÓN DE REQUERIMIENTOS.");
        setToolTipText(this.title);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jTabbedPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Selección de Requerimientos Recepcionados:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        TBrequerimiento1.setModel(new javax.swing.table.DefaultTableModel(
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
        TBrequerimiento1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TBrequerimiento1);
        if (TBrequerimiento1.getColumnModel().getColumnCount() > 0) {
            TBrequerimiento1.getColumnModel().getColumn(4).setPreferredWidth(250);
        }

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/Aceptar.png"))); // NOI18N
        jButton2.setText("Seleccionar para evaluación");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Recepción de Requerimientos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

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
            TBrequerimiento.getColumnModel().getColumn(4).setPreferredWidth(250);
        }

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/GENERAR.png"))); // NOI18N
        jButton1.setText("Recepcionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/ACTUALIZAR.png"))); // NOI18N
        jButton7.setText("Actualizar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton7)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2))
        );

        jTabbedPane1.addTab("Evaluación de Requerimientos", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        TBdetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C. Mat.", "Material", "Requerimiento", "Cantidad", "Unidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBdetalle.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TBdetalle);
        if (TBdetalle.getColumnModel().getColumnCount() > 0) {
            TBdetalle.getColumnModel().getColumn(1).setPreferredWidth(350);
        }

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/Aceptar.png"))); // NOI18N
        jButton3.setText("Material Evaluado");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        TXevaluacion.setEditable(false);
        TXevaluacion.setBackground(new java.awt.Color(255, 204, 0));
        TXevaluacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TXevaluacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXevaluacion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Código de Evaluación", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        TBevaluacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Evaluación", "C. Mat.", "Material", "Requerimiento", "Cantidad", "Observación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TBevaluacion);
        if (TBevaluacion.getColumnModel().getColumnCount() > 0) {
            TBevaluacion.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        jLabel1.setText("Para Evaluar el material, seleccione una fila y si es necesario modifique la cantidad y registre su observación, luego presionar MATERIAL EVALUADO");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Observación:");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/GENERAR.png"))); // NOI18N
        jButton4.setText("Aprobar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CANCELAR.png"))); // NOI18N
        jButton5.setText("Desaprobar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/RESTAR.png"))); // NOI18N
        jButton6.setText("Quitar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        TXbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXbuscarKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Buacar Material:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Requerimiento:");

        TXrequerimiento.setBackground(new java.awt.Color(255, 255, 153));
        TXrequerimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXobservacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3))
            .addComponent(jScrollPane2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(TXevaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXrequerimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TXevaluacion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TXbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(TXrequerimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(TXobservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)))
        );

        jTabbedPane1.addTab("Selección de Materiales", jPanel3);

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
        Recepcionar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Seleccionar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        Salir();
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        MaterialEvaluado();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Aprobar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(ctrl.mensaje.MsjeConfirmacion("Está seguro de desaprobar este requerimeinto?")==0)
        {
            Quitar();
        }
        else
        {
            ctrl.mensaje.MensajeSimple("Operación Cancelada.");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Visualizar();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //TODO add your handling code here:
//        int resp=JOptionPane.showConfirmDialog(null, "Está seguro de desaprobar este requerimeinto?","Confirmar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(ctrl.mensaje.MsjeConfirmacion("Está seguro de desaprobar este requerimeinto?")==0)
        {
            Desaprobar();
        }
        else
        {
            ctrl.mensaje.MensajeSimple("Operación Cancelada.");
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void TXbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXbuscarKeyReleased
        // TODO add your handling code here:
        ctrl.VisualizarDataEscogidaEnTabla("detalle_requerimiento_id_material,material_descripcion,detalle_requerimiento_id_requerimiento,detalle_requerimiento_cantidad,unidad_abreviatura", "v_detalle_requerimiento", TBdetalle, "where (material_descripcion like '%"+TXbuscar.getText().trim()+"%') and detalle_requerimiento_id_requerimiento='"+TXrequerimiento.getText().trim()+"'");
    }//GEN-LAST:event_TXbuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TBdetalle;
    private javax.swing.JTable TBevaluacion;
    private javax.swing.JTable TBrequerimiento;
    private javax.swing.JTable TBrequerimiento1;
    private javax.swing.JTextField TXbuscar;
    public static javax.swing.JTextField TXevaluacion;
    private javax.swing.JTextField TXobservacion;
    private javax.swing.JTextField TXrequerimiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
