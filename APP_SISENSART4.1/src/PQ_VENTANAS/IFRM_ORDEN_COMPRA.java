/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PQ_VENTANAS;

import PQ_CONTROLADORES.CLS_Controlador;
import PQ_CONTROLADORES.CLS_Leer_Numeros;
import PQ_CONTROLADORES.Reportes;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTextField;

/**
 *
 * @author Andy Figueroa
 */
public class IFRM_ORDEN_COMPRA extends javax.swing.JInternalFrame {

    CLS_Controlador ctrl = new CLS_Controlador();
    CLS_Leer_Numeros leer = new CLS_Leer_Numeros();
    Reportes reporte = new Reportes();

    /**
     * Creates new form IFRM_ORDEN_COMPRA
     */
    public IFRM_ORDEN_COMPRA() {
        initComponents();
        ctrl.VisualizarEnTabla("material", TBmaterial, "");
        Ver();
    }

    private void MovimientoEntradas() {
        ctrl.GrabarData("movimiento", "fecha,tipo_movimiento,motivo,documento,nro_documento,estado,placa,proveedor", "'" + TXfecha.getText().trim() + "','INGRESO X COMPRA','" + TXobra.getText().trim() + "','NRO DE ORDEN DE COMPRA','" + TXorden.getText().trim() + "',2,'"+TXtransporte.getText().trim()+"','"+LBproveedor.getText()+"'");
        String Ucodigo = ctrl.UltimoCodigo("id_movimiento", "movimiento");
        String Almacen = ctrl.ObtenerCodigo("almacen", "descripcion", CBalmacen.getSelectedItem().toString().trim(), 1);
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        try {
            ctrl.Base.conec.setAutoCommit(false);
            stmt = ctrl.Base.conec.prepareStatement("insert into detalle_movimiento values(?,?,?,?,?,?,?,?);");
            stmt2 = ctrl.Base.conec.prepareStatement("update movimiento set estado=? where id_movimiento=?;");
            //Transaccion de detalle de movimiento
            for (int i = 0; i < TBdetalle_orden.getRowCount(); i++) {
                stmt.setString(1, TBdetalle_orden.getValueAt(i, 1).toString().trim());
                stmt.setString(2, Ucodigo);
                stmt.setString(3, TBdetalle_orden.getValueAt(i, 4).toString().trim());
                stmt.setString(4, "");
                stmt.setString(5, "");
                stmt.setString(6, Almacen);
                stmt.setString(7, TBdetalle_orden.getValueAt(i, 3).toString().trim());
                stmt.setString(8, TBdetalle_orden.getValueAt(i, 5).toString().trim());
                stmt.executeUpdate();
            }
            //Transaccion de movimiento
            stmt2.setString(1, "2");
            stmt2.setString(2, Ucodigo);
            stmt2.executeUpdate();
            ctrl.Base.conec.commit();
            ctrl.mensaje.MensajeSimple("Transacción de entradas finalizado.");
            reporte.Reporte_1Parametro_Imagen("RPT_Movimiento.jasper", "p_id", Ucodigo, "p_logo", "/PQ_IMAGENES/LogoSantisimaCruzEdit.png");
        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getMessage());
            if (ctrl.Base.conec != null) {
                System.out.println("Rollback");
                try {
                    ctrl.Base.conec.rollback();
                } catch (SQLException ex) {
                    System.err.println("No se pudo deshacer" + ex.getMessage());
                }
            }
        } finally {
            System.out.println("cierra conexion a la base de datos");
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (stmt2 != null) {
                    stmt2.close();
                }
//                if (ctrl.Base.conec != null) {
//                    ctrl.Base.conec.close();
//                }
//                ctrl.Base.Conectar();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    private void MovimientoSalidas() {
        ctrl.GrabarData("movimiento", "fecha,tipo_movimiento,motivo,documento,nro_documento,estado,placa,proveedor", "'" + TXfecha.getText().trim() + "','SALIDA','" + TXobra.getText().trim() + "','NRO DE ORDEN DE COMPRA','" + TXorden.getText().trim() + "',2,'"+TXtransporte.getText().trim()+"','"+LBproveedor.getText()+"'");
        String Ucodigo = ctrl.UltimoCodigo("id_movimiento", "movimiento");
        String Almacen = ctrl.ObtenerCodigo("almacen", "descripcion", CBalmacen.getSelectedItem().toString().trim(), 1);
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        try {
            ctrl.Base.conec.setAutoCommit(false);
            stmt = ctrl.Base.conec.prepareStatement("insert into detalle_movimiento values(?,?,?,?,?,?,?,?);");
            stmt2 = ctrl.Base.conec.prepareStatement("update movimiento set estado=? where id_movimiento=?;");
            //Transaccion de detalle de movimiento
            for (int i = 0; i < TBdetalle_orden.getRowCount(); i++) {
                stmt.setString(1, TBdetalle_orden.getValueAt(i, 1).toString().trim());
                stmt.setString(2, Ucodigo);
                stmt.setString(3, TBdetalle_orden.getValueAt(i, 4).toString().trim());
                stmt.setString(4, "");
                stmt.setString(5, "");
                stmt.setString(6, Almacen);
                stmt.setString(7, TBdetalle_orden.getValueAt(i, 3).toString().trim());
                stmt.setString(8, TBdetalle_orden.getValueAt(i, 5).toString().trim());
                stmt.executeUpdate();
            }
            //Transaccion de movimiento
            stmt2.setString(1, "2");
            stmt2.setString(2, Ucodigo);
            stmt2.executeUpdate();
            ctrl.Base.conec.commit();
            ctrl.mensaje.MensajeSimple("Transacción de salidas finalizado.");
            reporte.Reporte_1Parametro_Imagen("RPT_Movimiento.jasper", "p_id", Ucodigo, "p_logo", "/PQ_IMAGENES/LogoSantisimaCruzEdit.png");
        } catch (SQLException e) {
            System.err.println("ERROR: " + e.getMessage());
            if (ctrl.Base.conec != null) {
                System.out.println("Rollback");
                try {
                    ctrl.Base.conec.rollback();
                } catch (SQLException ex) {
                    System.err.println("No se pudo deshacer" + ex.getMessage());
                }
            }
        } finally {
            System.out.println("cierra conexion a la base de datos");
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (stmt2 != null) {
                    stmt2.close();
                }
                if (ctrl.Base.conec != null) {
                    ctrl.Base.conec.close();
                }
                ctrl.Base.Conectar();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
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

        jScrollPane5 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBorden = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        CBserie = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        TXbuscar = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TXorden = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TXfecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TXserie = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TXnro = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        TXrequerimiento = new javax.swing.JTextField();
        BTrequerimiento = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        TXsolicitante = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TXobra = new javax.swing.JTextArea();
        BTrequerimiento1 = new javax.swing.JButton();
        BTobra = new javax.swing.JButton();
        CBreq = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        CBdocumento = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        CBmoneda = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        CBpago = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        TXproveedor = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        CBigv = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        LBproveedor = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TXtransporte = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TXobservacion = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        TXbuscar_material = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TBmaterial = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        TXcantidad = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        TXunitario = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        TXtotal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        CBunidad = new javax.swing.JComboBox();
        jButton8 = new javax.swing.JButton();
        BTadicionar = new javax.swing.JButton();
        CH_por_requerimiento = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TBdetalle_orden = new javax.swing.JTable();
        BTcalcular = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        TXsub = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        TXigv = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        TXtot = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        LBnumeros = new javax.swing.JLabel();
        BTcancelar = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        TXdescuento = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        CBalmacen = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        CBtipo_documento = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("VENTANA DE ORDEN DE COMRPA.");
        setToolTipText("VENTANA DE ORDEN DE COMRPA.");

        jScrollPane5.setAutoscrolls(true);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TBorden.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TBorden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Fecha", "Número", "Estado", "Serie", "Nro Actual."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBorden.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TBorden);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Serie de orden de Compra:");

        CBserie.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CBserieFocusGained(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CARPETA1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/GENERAR.png"))); // NOI18N
        jButton2.setText("Emitir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CANCELAR.png"))); // NOI18N
        jButton3.setText("Anular");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/DETALLAR.png"))); // NOI18N
        jButton4.setText("Detallar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel25.setText("Ingrese el código de Orden:");

        TXbuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXbuscarKeyTyped(evt);
            }
        });

        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton9.setText("Visualizar todos");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/ACTUALIZAR.png"))); // NOI18N
        jButton11.setText("Fecha");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBserie, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(TXbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(CBserie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addComponent(jButton3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jButton11))))
        );

        jTabbedPane1.addTab("Orden de Compra", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Datos de Orden de Compra:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos Emitidos:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel2.setText("Código:");

        TXorden.setEditable(false);
        TXorden.setBackground(new java.awt.Color(255, 204, 102));
        TXorden.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setText("Fecha:");

        TXfecha.setEditable(false);
        TXfecha.setBackground(new java.awt.Color(255, 204, 102));
        TXfecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setText("Serie:");

        TXserie.setEditable(false);
        TXserie.setBackground(new java.awt.Color(255, 204, 102));
        TXserie.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setText("Nro.:");

        TXnro.setEditable(false);
        TXnro.setBackground(new java.awt.Color(255, 204, 102));
        TXnro.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXorden, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXserie, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXfecha, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(TXnro))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXorden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(TXfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TXserie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(TXnro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos de Requerimiento:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel8.setText("Obra:");

        TXrequerimiento.setEditable(false);
        TXrequerimiento.setBackground(new java.awt.Color(255, 255, 153));
        TXrequerimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXrequerimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXrequerimientoKeyTyped(evt);
            }
        });

        BTrequerimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CARPETA1.png"))); // NOI18N
        BTrequerimiento.setEnabled(false);
        BTrequerimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTrequerimientoActionPerformed(evt);
            }
        });

        jLabel7.setText("Solicitante:");

        TXsolicitante.setBackground(new java.awt.Color(255, 255, 153));

        TXobra.setEditable(false);
        TXobra.setBackground(new java.awt.Color(255, 255, 153));
        TXobra.setColumns(20);
        TXobra.setLineWrap(true);
        TXobra.setRows(5);
        TXobra.setWrapStyleWord(true);
        TXobra.setNextFocusableComponent(TXbuscar_material);
        jScrollPane2.setViewportView(TXobra);

        BTrequerimiento1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CARPETA1.png"))); // NOI18N
        BTrequerimiento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTrequerimiento1ActionPerformed(evt);
            }
        });

        BTobra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CARPETA1.png"))); // NOI18N
        BTobra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTobraActionPerformed(evt);
            }
        });

        CBreq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RQCE", "NRQ", "RQU" }));
        CBreq.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CBreq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBreqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(CBreq, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXrequerimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTrequerimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXsolicitante)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTrequerimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTobra, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(TXrequerimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTrequerimiento)
                    .addComponent(jLabel7)
                    .addComponent(TXsolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTrequerimiento1)
                    .addComponent(CBreq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap())
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(BTobra)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Datos Complementarios:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel9.setText("Documento:");

        CBdocumento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 - BOLETA", "2 - FACTURA" }));

        jLabel10.setText("Moneda:");

        CBmoneda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 - SOLES", "2 - DOLARES AMERICANOS" }));

        jLabel11.setText("Tipo de Pago:");

        CBpago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 - CREDITO", "2 - CONTADO" }));

        jLabel13.setText("Proveedor:");

        TXproveedor.setEditable(false);
        TXproveedor.setBackground(new java.awt.Color(255, 204, 102));
        TXproveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXproveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TXproveedorMouseClicked(evt);
            }
        });
        TXproveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXproveedorKeyPressed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CARPETA1.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        CBigv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "17", "18", "19" }));
        CBigv.setSelectedIndex(1);

        jLabel19.setText("IGV:");

        jLabel6.setText("Unidad:");

        TXtransporte.setBackground(new java.awt.Color(204, 204, 204));
        TXtransporte.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBproveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6))
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXtransporte)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(CBdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBmoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBpago, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBigv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(TXproveedor, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(LBproveedor, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TXtransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(CBdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(CBmoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(CBpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBigv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setText("OBSERVACIONES:");

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/GENERAR.png"))); // NOI18N
        jButton7.setText("Confirmar Compra");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXobservacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(TXobservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(97, 97, 97))
        );

        jLabel14.setText("Buscar Material:");

        TXbuscar_material.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXbuscar_materialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXbuscar_materialKeyReleased(evt);
            }
        });

        TBmaterial.setModel(new javax.swing.table.DefaultTableModel(
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
        TBmaterial.getTableHeader().setReorderingAllowed(false);
        TBmaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TBmaterialKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(TBmaterial);
        if (TBmaterial.getColumnModel().getColumnCount() > 0) {
            TBmaterial.getColumnModel().getColumn(1).setPreferredWidth(600);
        }

        jLabel15.setText("Cantidad:");

        TXcantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXcantidad.setText("0.0");
        TXcantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXcantidadFocusGained(evt);
            }
        });
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

        jLabel16.setText("P. Unitario:");

        TXunitario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXunitario.setText("0.0");
        TXunitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXunitarioFocusGained(evt);
            }
        });
        TXunitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TXunitarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXunitarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXunitarioKeyTyped(evt);
            }
        });

        jLabel17.setText("P. Total:");

        TXtotal.setEditable(false);
        TXtotal.setBackground(new java.awt.Color(255, 255, 153));
        TXtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXtotal.setText("0.0");
        TXtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXtotalKeyReleased(evt);
            }
        });

        jLabel18.setText("Unidad:");

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

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CARPETA1.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        BTadicionar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTadicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/ADICIONAR.png"))); // NOI18N
        BTadicionar.setText("Adicionar");
        BTadicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTadicionarActionPerformed(evt);
            }
        });

        CH_por_requerimiento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CH_por_requerimiento.setText("Por Requerimiento");
        CH_por_requerimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CH_por_requerimientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXbuscar_material, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CH_por_requerimiento)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TXcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CBunidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(TXunitario, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TXtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                                .addComponent(BTadicionar))))))
            .addComponent(jScrollPane3)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(TXbuscar_material, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CH_por_requerimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(CBunidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(TXtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(TXunitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(TXcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(BTadicionar)))
        );

        jTabbedPane2.addTab("Asignación de Materiales", jPanel7);

        TBdetalle_orden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orden", "C.Material", "Material", "Unidad", "Cantida", "P.Unitario", "P.Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBdetalle_orden.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TBdetalle_orden);
        if (TBdetalle_orden.getColumnModel().getColumnCount() > 0) {
            TBdetalle_orden.getColumnModel().getColumn(2).setPreferredWidth(250);
        }

        BTcalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CALCULAR.png"))); // NOI18N
        BTcalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTcalcularActionPerformed(evt);
            }
        });

        jLabel20.setText("Sub Total:");

        TXsub.setEditable(false);
        TXsub.setBackground(new java.awt.Color(255, 255, 153));
        TXsub.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXsub.setText("0.0");

        jLabel21.setText("IGV:");

        TXigv.setEditable(false);
        TXigv.setBackground(new java.awt.Color(255, 255, 153));
        TXigv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXigv.setText("0.0");

        jLabel22.setText("Total:");

        TXtot.setEditable(false);
        TXtot.setBackground(new java.awt.Color(255, 255, 153));
        TXtot.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXtot.setText("0.0");

        jLabel23.setText("Son:");

        BTcancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BTcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/CANCELAR.png"))); // NOI18N
        BTcancelar.setText("Cancelar");
        BTcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTcancelarActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/Eliminar.png"))); // NOI18N
        jButton10.setText("Eliminar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        TXdescuento.setBackground(new java.awt.Color(102, 153, 255));
        TXdescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXdescuento.setText("0.0");
        TXdescuento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TXdescuentoFocusGained(evt);
            }
        });
        TXdescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXdescuentoActionPerformed(evt);
            }
        });
        TXdescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXdescuentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TXdescuentoKeyTyped(evt);
            }
        });

        jLabel24.setText("Almacén de Destino:");

        CBalmacen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CBalmacenFocusGained(evt);
            }
        });
        CBalmacen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CBalmacenKeyPressed(evt);
            }
        });

        jLabel26.setText("Descuento:");

        CBtipo_documento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "R", "F" }));

        jLabel27.setText("Tipo Documento:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXtot, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXsub, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXigv, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBnumeros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CBtipo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CBalmacen, 0, 422, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTcalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTcancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jLabel22)
                .addGap(18, 18, 18))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(TXsub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26)
                                    .addComponent(TXdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CBtipo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(TXigv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24)
                                    .addComponent(CBalmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BTcancelar)
                                .addComponent(jButton10))
                            .addComponent(BTcalcular))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(LBnumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(TXtot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        jTabbedPane2.addTab("Vista de Detalle", jPanel8);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Detalle de Orden", jPanel2);

        jScrollPane5.setViewportView(jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBalmacenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBalmacenKeyPressed
        // TODO add your handling code here:
        ctrl.PulsarEnter(evt, TXobservacion);
    }//GEN-LAST:event_CBalmacenKeyPressed

    private void CBalmacenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CBalmacenFocusGained
        // TODO add your handling code here:
        ctrl.LlenarCombo(CBalmacen, "select * from almacen", 2);
    }//GEN-LAST:event_CBalmacenFocusGained

    private void TXdescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXdescuentoKeyTyped
        // TODO add your handling code here:
        ctrl.SoloNumerosDecimales(evt);
        ctrl.Unpunto(evt, TXdescuento);
    }//GEN-LAST:event_TXdescuentoKeyTyped

    private void TXdescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXdescuentoKeyReleased
        // TODO add your handling code here:
        if (TXdescuento.getText().trim().length() == 0) {
            TXdescuento.setText("0.0");
            ctrl.Maracar(TXdescuento);
        }
    }//GEN-LAST:event_TXdescuentoKeyReleased

    private void TXdescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXdescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXdescuentoActionPerformed

    private void TXdescuentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXdescuentoFocusGained
        // TODO add your handling code here:
        ctrl.Maracar(TXdescuento);
    }//GEN-LAST:event_TXdescuentoFocusGained

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        EliminarDetalle();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void BTcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTcancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_BTcancelarActionPerformed

    private void BTcalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTcalcularActionPerformed
        // TODO add your handling code here:
        CalcularDetalle();
    }//GEN-LAST:event_BTcalcularActionPerformed

    private void CH_por_requerimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CH_por_requerimientoActionPerformed
        // TODO add your handling code here:
        if (CH_por_requerimiento.isSelected() && TXorden.getText().trim().length() > 0) {
            DLG_DETALLE_ORDEN_POR_EVALUACION DLG = new DLG_DETALLE_ORDEN_POR_EVALUACION(null, true);
            DLG.setVisible(true);
        } else {
            ctrl.mensaje.MensajeSimple("Seleccione una numeracion de orden de Compra.");
            CH_por_requerimiento.setSelected(false);
            jTabbedPane1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_CH_por_requerimientoActionPerformed

    private void BTadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTadicionarActionPerformed
        // TODO add your handling code here:
        Adicionar();
    }//GEN-LAST:event_BTadicionarActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void CBunidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CBunidadKeyPressed
        // TODO add your handling code here:
        ctrl.PulsarEnter(evt, TXcantidad);
    }//GEN-LAST:event_CBunidadKeyPressed

    private void CBunidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CBunidadFocusGained
        // TODO add your handling code here:
        ctrl.LlenarCombo(CBunidad, "select * from unidad", 2);
    }//GEN-LAST:event_CBunidadFocusGained

    private void TXtotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXtotalKeyReleased
        // TODO add your handling code here:
        ctrl.PulsarEnter(evt, BTadicionar);
    }//GEN-LAST:event_TXtotalKeyReleased

    private void TXunitarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXunitarioKeyTyped
        // TODO add your handling code here:
        ctrl.SoloNumerosDecimales(evt);
        ctrl.Unpunto(evt, TXunitario);
        NoEscribe(evt, TXunitario);
    }//GEN-LAST:event_TXunitarioKeyTyped

    private void TXunitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXunitarioKeyReleased
        // TODO add your handling code here:
        if (TXunitario.getText().trim().length() == 0) {
            TXunitario.setText("0.0");
            ctrl.Maracar(TXunitario);
        }
        CalcularCompraArticulos();
    }//GEN-LAST:event_TXunitarioKeyReleased

    private void TXunitarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXunitarioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            TXtotal.requestFocus();
        }
    }//GEN-LAST:event_TXunitarioKeyPressed

    private void TXunitarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXunitarioFocusGained
        // TODO add your handling code here:
        ctrl.Maracar(TXunitario);
    }//GEN-LAST:event_TXunitarioFocusGained

    private void TXcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXcantidadKeyTyped
        // TODO add your handling code here:
        ctrl.SoloNumerosDecimales(evt);
        ctrl.Unpunto(evt, TXcantidad);
        NoEscribe(evt, TXcantidad);
    }//GEN-LAST:event_TXcantidadKeyTyped

    private void TXcantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXcantidadKeyReleased
        // TODO add your handling code here:
        if (TXcantidad.getText().trim().length() == 0) {
            TXcantidad.setText("0.0");
            ctrl.Maracar(TXcantidad);
        }
        CalcularCompraArticulos();
    }//GEN-LAST:event_TXcantidadKeyReleased

    private void TXcantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXcantidadKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            ctrl.Maracar(TXunitario);
        }
    }//GEN-LAST:event_TXcantidadKeyPressed

    private void TXcantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXcantidadFocusGained
        // TODO add your handling code here:
        ctrl.Maracar(TXcantidad);
    }//GEN-LAST:event_TXcantidadFocusGained

    private void TBmaterialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBmaterialKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_UP && TBmaterial.getSelectedRow() == 0) {
            ctrl.Maracar(TXbuscar_material);
        } else if (evt.getKeyCode() == evt.VK_RIGHT) {
            CBunidad.requestFocus();
        }
    }//GEN-LAST:event_TBmaterialKeyPressed

    private void TXbuscar_materialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXbuscar_materialKeyReleased
        // TODO add your handling code here:
        ctrl.VisualizarEnTabla("material", TBmaterial, "where descripcion like('%" + TXbuscar_material.getText().trim() + "%')");
    }//GEN-LAST:event_TXbuscar_materialKeyReleased

    private void TXbuscar_materialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXbuscar_materialKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_DOWN && TBmaterial.getRowCount() > 0) {
            TBmaterial.requestFocus();
        }
    }//GEN-LAST:event_TXbuscar_materialKeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        ConfirmarOrden();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        DLG_PROVEEDOR dlg = new DLG_PROVEEDOR(null, true);
        dlg.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void TXproveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXproveedorKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            DLG_PROVEEDOR_ORDEN dlg = new DLG_PROVEEDOR_ORDEN(null, true);
            dlg.setVisible(true);
        }
    }//GEN-LAST:event_TXproveedorKeyPressed

    private void TXproveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TXproveedorMouseClicked
        // TODO add your handling code here:
        DLG_PROVEEDOR_ORDEN dlg = new DLG_PROVEEDOR_ORDEN(null, true);
        dlg.setVisible(true);
    }//GEN-LAST:event_TXproveedorMouseClicked

    private void CBreqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBreqActionPerformed
        // TODO add your handling code here:
        if (CBreq.getSelectedIndex() == 0) {
            TXrequerimiento.setText("");
            TXrequerimiento.setEditable(false);
            BTrequerimiento.setEnabled(false);
        } else {
            TXrequerimiento.setText("");
            TXrequerimiento.setEditable(true);
            BTrequerimiento.setEnabled(true);
            TXrequerimiento.requestFocus();
        }
    }//GEN-LAST:event_CBreqActionPerformed

    private void BTobraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTobraActionPerformed
        // TODO add your handling code here:
        DLG_Obra_Orden dlg = new DLG_Obra_Orden(null, true);
        dlg.setVisible(true);
    }//GEN-LAST:event_BTobraActionPerformed

    private void BTrequerimiento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTrequerimiento1ActionPerformed
        // TODO add your handling code here:
        DLG_Solicitante_orden dñg = new DLG_Solicitante_orden(null, true);
        dñg.setVisible(true);
    }//GEN-LAST:event_BTrequerimiento1ActionPerformed

    private void BTrequerimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTrequerimientoActionPerformed
        // TODO add your handling code here:
        ctrl.EliminarData("detalle_orden", "where id_orden='" + TXorden.getText().trim() + "'");
        ctrl.VisualizarEnTabla("v_detalle_orden", TBdetalle_orden, "where detalle_orden_id_orden='" + TXorden.getText().trim() + "'");
        TXsub.setText("0.0");
        TXigv.setText("0.0");
        TXtot.setText("0.0");
        DLG_ORDEN_REQUERIMIENTO dlg = new DLG_ORDEN_REQUERIMIENTO(null, true);
        dlg.setVisible(true);
    }//GEN-LAST:event_BTrequerimientoActionPerformed

    private void TXrequerimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXrequerimientoKeyTyped
        // TODO add your handling code here:
        ctrl.SoloNumerosEnteros(evt);
    }//GEN-LAST:event_TXrequerimientoKeyTyped

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        ActualizarFecha();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        ctrl.VisualizarEnTabla("v_orden_compra", TBorden, "where orden_compra_estado=1 or orden_compra_estado=2 order by orden_compra_id_orden");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (TXbuscar.getText().trim().length() == 0) {
            ctrl.mensaje.MensajeAlerta("Ud. no ingresó ningún código a buscar");
            TXbuscar.requestFocus();
        } else {
            ctrl.VisualizarEnTabla("v_orden_compra", TBorden, "where (orden_compra_id_orden='" + TXbuscar.getText().trim() + "') and (orden_compra_estado=1 or orden_compra_estado=2) order by orden_compra_id_orden");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void TXbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXbuscarKeyTyped
        // TODO add your handling code here:
        ctrl.SoloNumerosEnteros(evt);
    }//GEN-LAST:event_TXbuscarKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Detallar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Anular();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (ctrl.mensaje.MsjeConfirmacion("Desea Emitir esta Orden e Compra?") == 0) {
            Emitir();
        } else {
            ctrl.mensaje.MensajeSimple("Proceso Cancelado.");
            Ver();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DLG_SERIES dgl = new DLG_SERIES(null, true);
        dgl.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CBserieFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CBserieFocusGained
        // TODO add your handling code here:
        ctrl.LlenarCombo(CBserie, "select * from serie_orden", 2);
    }//GEN-LAST:event_CBserieFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTadicionar;
    public static javax.swing.JButton BTcalcular;
    private javax.swing.JButton BTcancelar;
    private javax.swing.JButton BTobra;
    private javax.swing.JButton BTrequerimiento;
    private javax.swing.JButton BTrequerimiento1;
    private javax.swing.JComboBox<String> CBalmacen;
    private javax.swing.JComboBox CBdocumento;
    private javax.swing.JComboBox CBigv;
    private javax.swing.JComboBox CBmoneda;
    private javax.swing.JComboBox CBpago;
    public static javax.swing.JComboBox<String> CBreq;
    private javax.swing.JComboBox CBserie;
    private javax.swing.JComboBox<String> CBtipo_documento;
    private javax.swing.JComboBox CBunidad;
    public static javax.swing.JCheckBox CH_por_requerimiento;
    private javax.swing.JLabel LBnumeros;
    public static javax.swing.JLabel LBproveedor;
    private javax.swing.JTable TBdetalle_orden;
    private javax.swing.JTable TBmaterial;
    private javax.swing.JTable TBorden;
    private javax.swing.JTextField TXbuscar;
    private javax.swing.JTextField TXbuscar_material;
    private javax.swing.JTextField TXcantidad;
    private javax.swing.JTextField TXdescuento;
    private javax.swing.JTextField TXfecha;
    private javax.swing.JTextField TXigv;
    private javax.swing.JTextField TXnro;
    public static javax.swing.JTextArea TXobra;
    private javax.swing.JTextField TXobservacion;
    public static javax.swing.JTextField TXorden;
    public static javax.swing.JTextField TXproveedor;
    public static javax.swing.JTextField TXrequerimiento;
    private javax.swing.JTextField TXserie;
    public static javax.swing.JTextField TXsolicitante;
    private javax.swing.JTextField TXsub;
    private javax.swing.JTextField TXtot;
    private javax.swing.JTextField TXtotal;
    private javax.swing.JTextField TXtransporte;
    private javax.swing.JTextField TXunitario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables

    private void Emitir() {
        if (CBserie.getSelectedIndex() == -1) {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó ninguna serie.");
            CBserie.requestFocus();
        } else {
            String fecha = ctrl.Fecha();
            String serie = ctrl.ObtenerCodigo("serie_orden", "serie", CBserie.getSelectedItem().toString().trim(), 1);
            String nro = ctrl.ObtenerCodigo("serie_orden", "serie", CBserie.getSelectedItem().toString().trim(), 3);
            double nros = Double.parseDouble(nro) + 1;
            ctrl.ActualizarData("serie_orden", "actual='" + nros + "'", "id_serie='" + serie + "'");
            ctrl.GrabarData("orden_compra", "fecha,nro_orden,estado,id_serie", "'" + fecha + "','" + nros + "',1,'" + serie + "'");
            Ver();
        }
    }

    private void Ver() {
        CBserie.setSelectedIndex(-1);
        ctrl.VisualizarEnTabla("v_orden_compra", TBorden, "where orden_compra_estado=1 or orden_compra_estado=2 order by orden_compra_id_orden");
    }

    private void Anular() {
        if (TBorden.getRowCount() == 0) {
            ctrl.mensaje.MensajeAlerta("No hay nada que anular");
            Ver();
        } else if (TBorden.getSelectedRow() == -1) {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó ninguna Orden");
            Ver();
        } else if (TBorden.getSelectedRowCount() > 1) {
            ctrl.mensaje.MensajeAlerta("Seleccione solo una fila.");
            Ver();
        } else if (ctrl.mensaje.MsjeConfirmacion("Está seguro de anular la Orden: " + ctrl.ValorTabla(TBorden, 4) + "-" + ctrl.ValorTabla(TBorden, 2)) == 0) {
            ctrl.ActualizarData("orden_compra", "estado=3", "id_orden='" + ctrl.ValorTabla(TBorden, 0) + "'");
            Ver();
        } else {
            ctrl.mensaje.MensajeAlerta("Proceso Cancelado.");
            Ver();
        }
    }

    private void Detallar() {
        if (TBorden.getRowCount() == 0) {
            ctrl.mensaje.MensajeAlerta("No hay nada que Detallar");
            Ver();
        } else if (TBorden.getSelectedRow() == -1) {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó ninguna Orden");
            Ver();
        } else if (TBorden.getSelectedRowCount() > 1) {
            ctrl.mensaje.MensajeAlerta("Seleccione solo una fila.");
            Ver();
        } else if (ctrl.mensaje.MsjeConfirmacion("Está seguro de detallar la Orden: " + ctrl.ValorTabla(TBorden, 4) + "-" + ctrl.ValorTabla(TBorden, 2)) == 0) {
            if (ctrl.ValorTabla(TBorden, 3).equalsIgnoreCase("detallado")) {
                TXorden.setText(ctrl.ValorTabla(TBorden, 0));
                TXfecha.setText(ctrl.ValorTabla(TBorden, 1));
                TXserie.setText(ctrl.ObtenerCodigo("serie_orden", "serie", ctrl.ValorTabla(TBorden, 4), 2));
                TXnro.setText(ctrl.ValorTabla(TBorden, 2));
                LimpiarCompra();
                ctrl.VisualizarEnTabla("v_detalle_orden", TBdetalle_orden, "where detalle_orden_id_orden='" + TXorden.getText().trim() + "'");
                BTcalcular.doClick();
                Ver();
                jTabbedPane1.setSelectedIndex(1);
            } else {
                TXorden.setText(ctrl.ValorTabla(TBorden, 0));
                TXfecha.setText(ctrl.ValorTabla(TBorden, 1));
                TXserie.setText(ctrl.ObtenerCodigo("serie_orden", "serie", ctrl.ValorTabla(TBorden, 4), 2));
                TXnro.setText(ctrl.ValorTabla(TBorden, 2));
                LimpiarCompra();
                ctrl.VisualizarEnTabla("v_detalle_orden", TBdetalle_orden, "where detalle_orden_id_orden='" + TXorden.getText().trim() + "'");
                BTcalcular.doClick();
                ctrl.ActualizarData("orden_compra", "estado=2", "id_orden='" + ctrl.ValorTabla(TBorden, 0) + "'");
                Ver();
                jTabbedPane1.setSelectedIndex(1);
            }
        } else {
            ctrl.mensaje.MensajeAlerta("Proceso Cancelado.");
            ctrl.VisualizarEnTabla("material", TBmaterial, "");
            TXbuscar_material.requestFocus();
        }
    }

    public void NoEscribe(KeyEvent evt, JTextField tx) {
        int pos = TBmaterial.getSelectedRow();
        if (TXorden.getText().trim().length() == 0) {
            ctrl.mensaje.MensajeAlerta("No seleccionó ninguna Orden de Compra generada.");
            jTabbedPane1.setSelectedIndex(0);
            CBserie.requestFocus();
            ctrl.NoEscribe(evt);
        } else if (pos == -1) {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó un artículo");
            ctrl.Maracar(TXbuscar_material);
            ctrl.NoEscribe(evt);
        } else if (CBunidad.getSelectedIndex() == -1) {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó la unidad");
            CBunidad.requestFocus();
            ctrl.NoEscribe(evt);
        }
    }

    private void CalcularCompraArticulos() {
        try {
            double a, b, c;
            a = Double.parseDouble(TXcantidad.getText().trim());
            b = Double.parseDouble(TXunitario.getText().trim());
            c = a * b;
            TXtotal.setText("" + ctrl.Redondear(c, 2));
        } catch (NumberFormatException e) {
            ctrl.mensaje.MensajeAlerta("Números incoherentes.");
        }
    }

    private void LimpiarCompra() {
        ctrl.VisualizarEnTabla("material", TBmaterial, "");
        CBunidad.setSelectedIndex(-1);
        TXcantidad.setText("0.0");
        TXunitario.setText("0.0");
        TXtotal.setText("0.0");
        TXbuscar_material.setText("");
        TXbuscar_material.requestFocus();
    }

    private void Adicionar() {
        if (TBmaterial.getSelectedRow() == -1) {
            ctrl.mensaje.MensajeAlerta("Seleccione un material.");
            ctrl.Maracar(TXbuscar_material);
        } else if (CBunidad.getSelectedIndex() == -1) {
            ctrl.mensaje.MensajeAlerta("Seleccione la unidad de medida.");
            CBunidad.requestFocus();
        }
//        else if (TXtotal.getText().trim().equalsIgnoreCase("0.0")) {
//            ctrl.mensaje.MensajeAlerta("Verifique las cantidades.\nDeben ser mayores a 0");
//            ctrl.Maracar(TXcantidad);
//        } 
        else if (ctrl.mensaje.MsjeConfirmacion("Está seguro que desea agregar este material?") == 0) {
            ctrl.GrabarData("detalle_orden", "id_material,id_orden,cantidad,p_unitario,p_total,asiganado,unidad", "'" + ctrl.ValorTabla(TBmaterial, 0) + "','" + TXorden.getText().trim() + "','" + TXcantidad.getText().trim() + "','" + TXunitario.getText().trim() + "','" + TXtotal.getText().trim() + "',2,'" + ctrl.ObtenerCodigo("unidad", "descripcion", CBunidad.getSelectedItem().toString().trim(), 3) + "'");
            LimpiarCompra();
            ctrl.VisualizarEnTabla("v_detalle_orden", TBdetalle_orden, "where detalle_orden_id_orden='" + TXorden.getText().trim() + "'");
            BTcalcular.doClick();
        } else {
            ctrl.mensaje.MensajeSimple("Proceso Cancelado");
            ctrl.VisualizarEnTabla("material", TBmaterial, "");
            LimpiarCompra();
        }
    }

    private void CalcularDetalle() {
        ctrl.VisualizarEnTabla("v_detalle_orden", TBdetalle_orden, "where detalle_orden_id_orden='" + TXorden.getText().trim() + "'");
        if (TBdetalle_orden.getRowCount() > 0) {
            double total = 0, sub, igv;
            for (int i = 0; i < TBdetalle_orden.getRowCount(); i++) {
                total = total + Double.parseDouble(TBdetalle_orden.getValueAt(i, 6).toString());
            }
            igv = (total / Double.parseDouble("1." + CBigv.getSelectedItem().toString().trim())) * (Double.parseDouble(CBigv.getSelectedItem().toString().trim()) / 100);
            sub = total - igv;
            TXsub.setText("" + ctrl.Redondear(sub, 4));
            TXigv.setText("" + ctrl.Redondear(igv, 4));
            TXtot.setText("" + ctrl.Redondear(total - Double.parseDouble(TXdescuento.getText().trim()), 2));
            LBnumeros.setText(leer.Convertir(TXtot.getText().trim(), true) + " " + CBmoneda.getSelectedItem().toString().substring(4, CBmoneda.getSelectedItem().toString().trim().length()) + ".");
        } else {
            ctrl.mensaje.MensajeAlerta("Ud. debe de insertar Artículos con precios a calcular.");
            TXsub.setText("0.0");
            TXigv.setText("0.0");
            TXtot.setText("0.0");
            LBnumeros.setText("");
        }
    }

    private void EliminarDetalle() {
        if (TBdetalle_orden.getRowCount() == 0) {
            ctrl.mensaje.MensajeAlerta("No hay nada que eliminar");
            jTabbedPane2.setSelectedIndex(0);
            ctrl.Maracar(TXbuscar_material);
        } else if (TBdetalle_orden.getSelectedRow() == -1) {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó ningún material");
            TBdetalle_orden.requestFocus();
        } else if (TBdetalle_orden.getSelectedRowCount() > 1) {
            ctrl.mensaje.MensajeAlerta("Elija solo una fila");
            TBdetalle_orden.requestFocus();
        } else {
            ctrl.EliminarData("detalle_orden", "where id_material='" + ctrl.ValorTabla(TBdetalle_orden, 1) + "' and id_orden='" + ctrl.ValorTabla(TBdetalle_orden, 0) + "'");
            ctrl.VisualizarEnTabla("v_detalle_orden", TBdetalle_orden, "where detalle_orden_id_orden='" + TXorden.getText().trim() + "'");
            CalcularDetalle();
        }
    }

    private void Cancelar() {
        if (ctrl.mensaje.MsjeConfirmacion("Desea cancelar?.\nTodos los detalles serán eliminados") == 0) {
            ctrl.EliminarData("detalle_orden", "where id_orden='" + TXorden.getText().trim() + "'");
            this.dispose();
        } else {
            ctrl.mensaje.MensajeSimple("Proceso negado.");
        }

    }

    private void ConfirmarOrden() {
        if (TXorden.getText().trim().length() == 0) {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó una orden generada");
            jTabbedPane1.setSelectedIndex(0);
        } else if (CBreq.getSelectedIndex() > 0 && TXrequerimiento.getText().trim().length() == 0) {
            ctrl.mensaje.MensajeAlerta("Ud. no ingresó una numeración de requerimiento");
            TXrequerimiento.requestFocus();
        } else if (TXsolicitante.getText().trim().length() == 0) {
            ctrl.mensaje.MensajeAlerta("Ud. no registró al solicitante");
            TXsolicitante.requestFocus();
        } else if (TXobra.getText().trim().length() == 0) {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó una obra");
            BTobra.requestFocus();
        } else if (TXproveedor.getText().trim().length() == 0) {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó un proveedor.\nSi no se encuentra en la lista registre uno nuevo.");
        } else if (TXsub.getText().trim().equalsIgnoreCase("0.0") || TXigv.getText().trim().equalsIgnoreCase("0.0") || TXtot.getText().trim().equalsIgnoreCase("0.0") || LBnumeros.getText().trim().length() == 0) {
            ctrl.mensaje.MensajeAlerta("Calculo incoherente.");
            BTcalcular.doClick();
        } else if (TBdetalle_orden.getRowCount() == 0) {
            ctrl.mensaje.MensajeAlerta("No se puede detallar porque no hay ningún arículo asignado.");
            ctrl.Maracar(TXbuscar_material);
        } else if (CBalmacen.getSelectedIndex() == -1) {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó un almacen de destino");
            CBalmacen.requestFocus();
        } else {
            ctrl.ActualizarData("orden_compra", "documento='" + CBdocumento.getSelectedItem().toString().substring(0, 1).trim() + "',sub_total='" + TXsub.getText().trim() + "',"
                    + "igv='" + TXigv.getText().trim() + "',total='" + TXtot.getText().trim() + "',moneda='" + CBmoneda.getSelectedItem().toString().substring(0, 1).trim() + "',"
                    + "precio_letras='" + LBnumeros.getText().trim() + "',tipo_pago='" + CBpago.getSelectedItem().toString().substring(0, 1).trim() + "',"
                    + "observacion='" + TXobservacion.getText().trim() + "',estado=3,id_proveedor='" + TXproveedor.getText().trim() + "',id_requerimiento='" + CBreq.getSelectedItem().toString().trim() + "-" + TXrequerimiento.getText().trim() + "',solicitante='" + TXsolicitante.getText().trim() + "',obra='" + TXobra.getText().trim() + "',placa='" + TXtransporte.getText().trim() + "',descuento='" + TXdescuento.getText().trim() + "',tipo_documento='"+CBtipo_documento.getSelectedItem().toString().trim()+"'", "id_orden='" + TXorden.getText().trim() + "'");
            if (CBdocumento.getSelectedIndex() == 0) {
                reporte.Reporte_1Parametro_Imagen("ORDEN_COMPRA_BOLETA.jasper", "p_codigo", TXorden.getText().trim(), "p_logo", "/PQ_IMAGENES/LogoSantisimaCruzEdit.png");
            } else {
                reporte.Reporte_1Parametro_Imagen("ORDEN_COMPRA_FACTURA.jasper", "p_codigo", TXorden.getText().trim(), "p_logo", "/PQ_IMAGENES/LogoSantisimaCruzEdit.png");
            }
            MovimientoEntradas();
            MovimientoSalidas();
            this.dispose();
        }
    }

    private void ActualizarFecha() {
        if (TBorden.getRowCount() == 0) {
            ctrl.mensaje.MensajeAlerta("No hay nada que Detallar");
            Ver();
        } else if (TBorden.getSelectedRow() == -1) {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó ninguna Orden");
            Ver();
        } else if (TBorden.getSelectedRowCount() > 1) {
            ctrl.mensaje.MensajeAlerta("Seleccione solo una fila.");
            Ver();
        } else if (ctrl.mensaje.MsjeConfirmacion("Está seguro de detallar la Orden: " + ctrl.ValorTabla(TBorden, 4) + "-" + ctrl.ValorTabla(TBorden, 2)) == 0) {
            ctrl.ActualizarData("orden_compra","fecha='"+ctrl.ValorTabla(TBorden, 1)+"'", "id_orden='"+ctrl.ValorTabla(TBorden, 0)+"'");
            Ver();
        }
    }
}
