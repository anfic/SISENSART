/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PQ_VENTANAS;

import PQ_CONTROLADORES.CLS_Controlador;

/**
 *
 * @author ANDY CLARK
 */
public class DLG_RequerimientoServicio extends javax.swing.JDialog {

    CLS_Controlador ctrl=new CLS_Controlador();
    /**
     * Creates new form DLG_RequerimientoServicio
     */
    public DLG_RequerimientoServicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ctrl.VisualizarDataEscogidaEnTabla("requerimiento_id_requerimiento,requerimiento_fecha,requerimiento_prioridad,obra_descripcion,usuario_nombres,requerimiento_estado", "v_requerimiento", TBrequerimientoServ, "where requerimiento_estado='APROBADO'");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPNreqServicio = new javax.swing.JPanel();
        LBreserv = new javax.swing.JLabel();
        TXrqserv = new javax.swing.JTextField();
        JSPrqserv = new javax.swing.JScrollPane();
        TBrequerimientoServ = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Requerimeinto Servicio.");

        JPNreqServicio.setBackground(new java.awt.Color(255, 255, 255));
        JPNreqServicio.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Requerimiento:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        LBreserv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LBreserv.setText("Buscar Requerimeinto:");

        TXrqserv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXrqservKeyReleased(evt);
            }
        });

        TBrequerimientoServ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "FECHA", "PRIORIDAD", "OBRA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBrequerimientoServ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBrequerimientoServMouseClicked(evt);
            }
        });
        JSPrqserv.setViewportView(TBrequerimientoServ);

        javax.swing.GroupLayout JPNreqServicioLayout = new javax.swing.GroupLayout(JPNreqServicio);
        JPNreqServicio.setLayout(JPNreqServicioLayout);
        JPNreqServicioLayout.setHorizontalGroup(
            JPNreqServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNreqServicioLayout.createSequentialGroup()
                .addComponent(LBreserv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXrqserv))
            .addComponent(JSPrqserv, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
        );
        JPNreqServicioLayout.setVerticalGroup(
            JPNreqServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNreqServicioLayout.createSequentialGroup()
                .addGroup(JPNreqServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(TXrqserv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBreserv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JSPrqserv, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPNreqServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPNreqServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TXrqservKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXrqservKeyReleased
        // TODO add your handling code here:
        ctrl.BuscarJtable(TXrqserv, TBrequerimientoServ, 4);
    }//GEN-LAST:event_TXrqservKeyReleased

    private void TBrequerimientoServMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBrequerimientoServMouseClicked
        // TODO add your handling code here:
        if (ctrl.ValidarRegistroTabla(TBrequerimientoServ)) {
            DLG_ORDEN_SERVICIO.txtCodReq.setText(ctrl.ValorTabla(TBrequerimientoServ, 0));
            DLG_ORDEN_SERVICIO.txtSolNom.setText(ctrl.ObtenerCodigo("v_requerimiento", "requerimiento_id_requerimiento", ctrl.ValorTabla(TBrequerimientoServ, 0), 6));
            DLG_ORDEN_SERVICIO.txtSolCorreo.setText(ctrl.ObtenerCodigo("v_requerimiento", "requerimiento_id_requerimiento", ctrl.ValorTabla(TBrequerimientoServ, 0), 7));
            this.dispose();
        }
    }//GEN-LAST:event_TBrequerimientoServMouseClicked

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
            java.util.logging.Logger.getLogger(DLG_RequerimientoServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DLG_RequerimientoServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DLG_RequerimientoServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DLG_RequerimientoServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DLG_RequerimientoServicio dialog = new DLG_RequerimientoServicio(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel JPNreqServicio;
    private javax.swing.JScrollPane JSPrqserv;
    private javax.swing.JLabel LBreserv;
    private javax.swing.JTable TBrequerimientoServ;
    private javax.swing.JTextField TXrqserv;
    // End of variables declaration//GEN-END:variables
}
