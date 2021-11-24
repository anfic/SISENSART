/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PQ_VENTANAS;

import PQ_CONTROLADORES.CLS_Controlador;
import PQ_CONTROLADORES.Reportes;

/**
 *
 * @author anfic
 */
public class DLG_Emision_Certificados extends javax.swing.JDialog {

    CLS_Controlador ctrl=new CLS_Controlador();
    Reportes reporte=new Reportes();
    /**
     * Creates new form DLG_Emision_Certificados
     */
    public DLG_Emision_Certificados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Cancelar();
    }
    private void Cancelar()
    {
        ctrl.VisualizarDataEscogidaEnTabla("ficha_datos_id_ficha,ficha_datos_fecha_ingreso,ficha_datos_fecha_cese,ficha_datos_estado_ficha,"
                + "ficha_datos_entrega_certificado,ficha_datos_dni,obra_planta_descripcion", "v_ficha", TBficha, "where ficha_datos_estado_ficha='CESADO' and ficha_datos_entrega_certificado='NO'");
        jTextField1.setText("");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TBficha = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventana de emisión de Certificados de Trabajo");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Emisión de Certificados de Trabajo:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        TBficha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro. Ficha", "Ingreso", "Cese", "Estado", "Certificado", "DNI", "Obra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBficha.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TBficha);
        if (TBficha.getColumnModel().getColumnCount() > 0) {
            TBficha.getColumnModel().getColumn(0).setResizable(false);
            TBficha.getColumnModel().getColumn(1).setResizable(false);
            TBficha.getColumnModel().getColumn(2).setResizable(false);
            TBficha.getColumnModel().getColumn(3).setResizable(false);
            TBficha.getColumnModel().getColumn(4).setResizable(false);
            TBficha.getColumnModel().getColumn(5).setResizable(false);
            TBficha.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Ingrese el DNI de Interesado:");

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/ACTUALIZAR.png"))); // NOI18N
        jButton1.setText("Actualizar tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PQ_IMAGENES/GENERAR.png"))); // NOI18N
        jButton2.setText("Emitir Certificado");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(jButton2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
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

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        ctrl.BuscarJtable(jTextField1, TBficha, 5);
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Emitir();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(DLG_Emision_Certificados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DLG_Emision_Certificados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DLG_Emision_Certificados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DLG_Emision_Certificados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DLG_Emision_Certificados dialog = new DLG_Emision_Certificados(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable TBficha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void Emitir()
    {
        if(TBficha.getRowCount()==0)
        {
            ctrl.mensaje.MensajeAlerta("No hay nada que emitir.");
            Cancelar();
        }
        else if(TBficha.getSelectedRowCount()>1)
        {
            ctrl.mensaje.MensajeAlerta("Seleccione solo una fila.");
            Cancelar();
        }
        else if(TBficha.getSelectedRow()==-1)
        {
            ctrl.mensaje.MensajeAlerta("Ud. no seleccionó una fila");
            Cancelar();
        }
        else
        {
            int res=ctrl.mensaje.MsjeConfirmacion("Está seguro que desea emitir este certificado?");
            if(res==0)
            {
                String codigo="MLS-"+(Integer.parseInt(ctrl.ContarFilasTablasSQL("certificado", ""))+1)+"-"+ctrl.Fecha();
                ctrl.GrabarData("certificado", "fecha_emision,codigo_interno,id_ficha","'"+ctrl.Fecha()+"','"+codigo+"','"+ctrl.ValorTabla(TBficha, 0)+"'");
                ctrl.ActualizarData("ficha_datos", "entrega_certificado=1", "id_ficha='"+ctrl.ValorTabla(TBficha, 0)+"'");
                this.dispose();
                reporte.Reporte_1Parametro_Imagen("RPT_Certificado.jasper", "p_codigo", ctrl.UltimoCodigo("id_certificado", "certificado"), "p_logo", "/PQ_IMAGENES/LogoSantisimaCruzEdit.png");
                
            }
            else
            {
                ctrl.mensaje.MensajeAlerta("Emisión de certificado cancelado.");
                Cancelar();
            }
            
        }
        
    }
}
