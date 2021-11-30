/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PQ_CONTROLADORES;

import PQ_VENTANAS.DLG_CONSULTA_ACTIVOS;
import UpperEssential.UpperEssentialLookAndFeel;
import com.mxrck.autocompleter.TextAutoCompleter;
import com.toedter.calendar.JDateChooser;
import datechooser.beans.DateChooserCombo;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionListener;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author ANDY FC
 */
public class CLS_Controlador {

    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Imagen", "jpg");
    String RutaImagen;
    CLS_Mensajes msj = new CLS_Mensajes();
    public JComboBox combo = new JComboBox();
    public static DefaultTableModel dtm = new DefaultTableModel();
    public CLS_Mensajes mensaje = new CLS_Mensajes();
    public Conexion_BD Base = new Conexion_BD();
    public String SQL1, SQL2;
    public static String usuario;
    public int Veces = 0;
    private Image data;
    public Runtime r = Runtime.getRuntime();
    TextAutoCompleter textAutoCompleter;
    private TableRowSorter fil;

    /**
     *
     * Este método sirve para verificar si el InternalFrame se encuentra abierto
     *
     */
    /**
     * Este método sirve para darle un fondo al JDesktopPane con solo indicar la
     * dirección de la imagen como por
     * EJEMPLO:(JDesktopPane,/PKG_Imagenes/imagen.jpg)
     */
    public void ImagenFondo(JDesktopPane panel, String Direccion_Imagen) {
        panel.setBorder(new ImagenFondo(Direccion_Imagen));
    }

    public void GrabarData(String TABLA, String ATRIBUTOS, String REGISTROS) {
        try {
            Base.st = Base.conec.createStatement();
            SQL1 = "insert into " + TABLA.toLowerCase() + " (" + ATRIBUTOS.toUpperCase() + ") values(" + REGISTROS + ")";
            Base.st.executeUpdate(SQL1);
//            Base.st.close();
            System.out.println("Se guardó correctamente:\n" + SQL1);
        } catch (SQLException ex) {
            mensaje.MensajeError("Insertar valores de tabla: " + TABLA + ".\n" + ex.getMessage());
        }
        r.gc();
    }
    

    public void EliminarData(String TABLA, String Condicion) {
        try {
            Base.st = Base.conec.createStatement();
            SQL1 = "delete from " + TABLA.toLowerCase() + " " + Condicion + "";
            Base.st.executeUpdate(SQL1);
//            Base.st.close();
//            mensaje.MensajeSimple("Eliminó Correctamente:\n"+SQL1);
            System.out.println("Se eliminó correctamente:\n" + SQL1);
        } catch (SQLException ex) {
            mensaje.MensajeError("Insertar valores de tabla: " + TABLA + ".\n" + ex.getMessage());
        }
        r.gc();
    }

    public void NoEscribe(KeyEvent e) {
        e.consume();
    }

    public void ActualizarData(String TABLA, String ATRIBUTOS, String CONDICION) {
        try {
            Base.st = Base.conec.createStatement();
            SQL1 = "update " + TABLA.toLowerCase() + " set " + ATRIBUTOS.toUpperCase() + " WHERE " + CONDICION;
            Base.st.executeUpdate(SQL1);
//            Base.st.close();
            mensaje.MensajeSimple("Se actualizó correctamente:\n" + SQL1);
//            System.out.println("Se actualizó correctamente:\n"+SQL1);
        } catch (SQLException ex) {
            mensaje.MensajeError("Actualizar valores de tabla: " + TABLA + ".\n" + ex.getMessage());
        }
        r.gc();
    }

    public void LimpiTabla(DefaultTableModel md) {
        while (md.getRowCount() > 0) {
            md.removeRow(0);
        }
    }

    public void VisualizarEnTabla(String TABLA, JTable jtable, String Condicion) {
        try {
            Base.st = Base.conec.createStatement();
            SQL1 = "select * from " + TABLA.toLowerCase() + " " + Condicion;
            Base.rt = Base.st.executeQuery(SQL1);
            Base.rsm = Base.rt.getMetaData();
            ArrayList<Object[]> data = new ArrayList<>();
            while (Base.rt.next()) {
                Object[] rows = new Object[Base.rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    rows[i] = Base.rt.getObject(i + 1);
                }
                data.add(rows);
            }
            dtm = (DefaultTableModel) jtable.getModel();
            LimpiTabla(dtm);
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
            }
        } catch (SQLException ex) {
            mensaje.MensajeError("Insertar valores de tabla: " + TABLA + ".\n" + ex.getMessage());
        }
        r.gc();
    }

    public void VisualizarDataEscogidaEnTabla(String Atributos, String TABLA, JTable jtable, String Condicion) {

        try {
            Base.st = Base.conec.createStatement();
            SQL1 = "select " + Atributos + " from " + TABLA.toLowerCase() + " " + Condicion;
            Base.rt = Base.st.executeQuery(SQL1);
            Base.rsm = Base.rt.getMetaData();
            ArrayList<Object[]> data = new ArrayList<>();
            while (Base.rt.next()) {
                Object[] rows = new Object[Base.rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    rows[i] = Base.rt.getObject(i + 1);
                }
                data.add(rows);

            }
            dtm = (DefaultTableModel) jtable.getModel();
            LimpiTabla(dtm);
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
            }
        } catch (SQLException ex) {
            mensaje.MensajeError("Insertar valores de tabla: " + TABLA + ".\n" + ex.getMessage());
        }
        r.gc();
    }

    public void Limpiar1Componente(Component componente) {
        if (componente instanceof JTextField) {
            JTextField texto = (JTextField) componente;
            texto.setText("");
        } else if (componente instanceof JComboBox) {
            JComboBox combo = (JComboBox) componente;
            combo.setSelectedIndex(-1);
        }
    }

    public void SoloNumerosEnteros(KeyEvent E) {
        int k = E.getKeyChar();
        if (k < 48 || k > 57) {
            E.consume();
        }
    }

    public void SoloNumerosDecimales(KeyEvent E) {
        int k = E.getKeyChar();
        if (k < 46 || k > 57 || k == 47) {
            E.consume();
        }
    }

    public void Maracar(JTextField tx) {
        tx.setSelectionStart(0);
        tx.setSelectionEnd(tx.getText().length());
        tx.requestFocus();
    }

    public String ObtenerCodigo(String Tabla, String Cmp, String vl, int ps) {
        String rt = "", Sql = "";
        Sql = "Select * from " + Tabla.toLowerCase() + " where " + Cmp + "='" + vl + "'";
        try {
            Base.st = Base.conec.createStatement();
            Base.rt = Base.st.executeQuery(Sql);
            if (Base.rt.next()) {
                rt = Base.rt.getString(ps);
            }
//            Base.rt.close();
//            Base.st.close();
        } catch (Exception E) {
            E.getMessage();
        }
        return rt;
    }

    public String ConsultaCamposEspecificosSQL(String Tabla, String Condicion, int ps) {
        String rt = "", Sql = "";
        Sql = "Select * from " + Tabla.toLowerCase() + " where " + Condicion + "";
        try {
            Base.st = Base.conec.createStatement();
            Base.rt = Base.st.executeQuery(Sql);
            while (Base.rt.next()) {
                rt = Base.rt.getString(ps);
            }
            Base.rt.close();
            Base.st.close();
        } catch (Exception E) {
            mensaje.MensajeSimple("Error: " + E.getMessage());
        }
        return rt;
    }

    public String Fecha() {
        String fec = "";
        try {
            Base.st = Base.conec.createStatement();
            Base.rt = Base.st.executeQuery("select curdate()");
            if (Base.rt.next()) {
                fec = Base.rt.getString(1);
            }
            Base.st.close();
            Base.rt.close();
        } catch (Exception e) {
            mensaje.MensajeError("Error controlador fecha:\n" + e.getMessage());
        }
        return fec;
    }

    public void ConsultaSQLAutocompletar(String consulta, JTextField tx, int pos) {
        textAutoCompleter = new TextAutoCompleter(tx);
        try {
            Base.st = Base.conec.createStatement();
            Base.rt = Base.st.executeQuery(consulta.toLowerCase());
            while (Base.rt.next()) {
                textAutoCompleter.addItem(Base.rt.getString(pos).toString());
            }
            Base.st.close();
            Base.rt.close();
        } catch (Exception ex) {
            Logger.getLogger(DLG_CONSULTA_ACTIVOS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            /*
                CERRAMOS el resultset ya no lo necesitamos 
             */
            if (Base.rt != null) {
                try {
                    Base.rt.close();
                } catch (Exception e) {
                }
            }
        }
//        catch(Exception e)
//        {
//            mensaje.MensajeError("Error controlador consulta:\n"+e.getMessage());
//        }
    }
    
    public String RetornarConsulta(String consulta, int pos) {
        String return_string = "";
        try {
            Base.st = Base.conec.createStatement();
            Base.rt = Base.st.executeQuery(consulta.toLowerCase());
            while (Base.rt.next()) {
                return_string = Base.rt.getString(pos);
            }
            Base.st.close();
            Base.rt.close();
        } catch (Exception E) {
            mensaje.MensajeSimple("Error: " + E.getMessage());
        }
        return return_string;
    }

    public String Hora() {
        String hra = "";
        try {
            Base.st = Base.conec.createStatement();
            Base.rt = Base.st.executeQuery("select curtime()");
            if (Base.rt.next()) {
                hra = Base.rt.getString(1);
            }
            Base.st.close();
            Base.rt.close();
        } catch (Exception e) {
            mensaje.MensajeError("Error controlador hora:\n" + e.getMessage());
        }
        return hra;
    }

    public void MarcarPsw(JPasswordField ps) {
        ps.setSelectionStart(0);
        ps.setSelectionEnd(ps.getText().length());
        ps.requestFocus();
    }

    public void SoloNumeroEnteros(JTextField texto) {
        if (!texto.getText().matches("[0-9--]*")) {
            msj.MensajeAlerta("solo se aceptan números");
            texto.setText("");
            texto.requestFocus();
        }
    }

    /*fichero para jalar fotos a un Jlabael
     */
    public void Foto(JLabel lb, JTextField tx) {
        RutaImagen = "";
        JFileChooser dlg2 = new JFileChooser();
        dlg2.setFileFilter(filter);
        int opcion = dlg2.showOpenDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            String fil = dlg2.getSelectedFile().getPath();
            ImageIcon icon = new ImageIcon(fil);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(155, 175, java.awt.Image.SCALE_SMOOTH);
            //se genera el imageicon con la nueva imagen
            ImageIcon newicon = new ImageIcon(newimg);
            lb.setIcon(newicon);
//            lb.setSize(155,175);
            tx.setText(fil);
            RutaImagen = "";
        }
        r.gc();
    }

    public void CerrarVentanaESC(final JDialog form) {
        form.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0), "Cancel");
        form.getRootPane().getActionMap().put("Cancel", new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                form.dispose();
            }
        });
        r.gc();
    }

    public void CerrarVentanaFRMESC(final JFrame form) {
        form.getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0), "Cancel");
        form.getRootPane().getActionMap().put("Cancel", new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                form.dispose();
            }
        });
        r.gc();
    }

    public boolean AccesoAlSistema(String Tabla, String Campo_usuario, String usuario, String Campo_Password, JPasswordField password, String OtraCondicion) {
        boolean b = false;
        try {
            SQL1 = "select * from " + Tabla.toLowerCase() + " where " + Campo_usuario + "='" + usuario.trim() + "' and " + Campo_Password + "='" + password.getText().trim() + "' " + OtraCondicion + "";
            Base.st = Base.conec.createStatement();
            Base.rt = Base.st.executeQuery(SQL1);
            if (Base.rt.next()) {
                b = true;
            }
            Base.st.close();
            Base.rt.close();
        } catch (Exception E) {
            E.getMessage();
        }
        return b;
    }

    public String InvertirFecha(String f) {
        String ano, mes, dia;
        ano = f.substring(6, 10);
        mes = f.substring(3, 5);
        dia = f.substring(0, 2);
        return ano + "-" + mes + "-" + dia;
    }

    public String CalcularEdad(String fecha_nac) {
        String edad = "";
        try {

            int fecha1 = Integer.parseInt(fecha_nac.substring(6, 10)), fecha2 = Integer.parseInt(Fecha().substring(0, 4));
            edad = "" + (fecha2 - fecha1);
        } catch (NumberFormatException e) {
        }
        return edad;
    }

    public Image ConvertirImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        return reader.read(0, param);
    }

    public void Substance(JFrame frm) {
        try {
            frm.setDefaultLookAndFeelDecorated(true);
            frm.setDefaultLookAndFeelDecorated(true);
//            SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");//apariencia de las ventanas
//            SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceMixTheme");
//            SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceMarbleVeinWatermark");
            SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");//apariencia de las ventanas
            SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceMixTheme");
            SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceMagneticFieldWatermark");
        } catch (Exception e) {
            System.out.println("Error substance:\n" + e.getMessage());
        }
    }

    public void LlenarCombo(JComboBox cbo, String Consulta, int pos) {
        try {
            cbo.removeAllItems();
            Base.st = Conexion_BD.conec.createStatement();
            Base.rt = Base.st.executeQuery(Consulta.toLowerCase());
            while (Base.rt.next()) {
                cbo.addItem(Base.rt.getString(pos));
            }
            cbo.setSelectedIndex(-1);
            Base.rt.close();
            Base.st.close();
        } catch (Exception e) {
            mensaje.MensajeError("Error llenar combos: " + e.getMessage());
        }
        r.gc();
    }

    public void LlenarCombo2Elementos(JComboBox cbo, String Consulta, int pos, int pos2) {
        try {
            cbo.removeAllItems();
            Base.st = Conexion_BD.conec.createStatement();
            Base.rt = Base.st.executeQuery(Consulta.toLowerCase());
            while (Base.rt.next()) {
                cbo.addItem(Base.rt.getString(pos) + "                  " + Base.rt.getString(pos2));
            }
            cbo.setSelectedIndex(-1);
            Base.rt.close();
            Base.st.close();
        } catch (Exception e) {
            e.getMessage();
        }
        r.gc();
    }

    public DefaultComboBoxModel getLista(String ListaVer, String Tabla, String cadenaEscrita, String condicion2) {

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            //"SELECT ARTICULO_descripcion,DETALLE_ALMACEN_stock FROM  v_detalle_almacen  WHERE (ARTICULO_descripcion LIKE 'b%' and ALMACEN_descripcion='central' and DETALLE_ALMACEN_stock>0 )";
            String query = "SELECT " + ListaVer + " FROM " + Tabla.toLowerCase() + " WHERE (" + ListaVer + " LIKE '" + cadenaEscrita + "%'  " + condicion2 + ")";
            Base.st = Base.conec.createStatement();
            Base.rt = (ResultSet) Base.st.executeQuery(query);
            while (Base.rt.next()) {
                modelo.addElement(Base.rt.getString(ListaVer));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CLS_Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelo;

    }

    public void ComboAutoCompletivo(final JComboBox cb, final String ListaVer, final String Tabla, final String condicion2) {
        cb.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = cb.getEditor().getItem().toString();

                if (evt.getKeyCode() >= 65 && evt.getKeyCode() <= 90 || evt.getKeyCode() >= 96 && evt.getKeyCode() <= 105 || evt.getKeyCode() == 8) {
                    cb.setModel(getLista(ListaVer, Tabla, cadenaEscrita, condicion2));
                    if (cb.getItemCount() > 0) {

                        cb.showPopup();
                        if (evt.getKeyCode() != 8) {
                            ((JTextComponent) cb.getEditor().getEditorComponent()).select(cadenaEscrita.length(), cb.getEditor().getItem().toString().length());

                        } else {
                            cb.getEditor().setItem(cadenaEscrita);
                        }

                    } else {

                        cb.addItem(cadenaEscrita);
                    }
                }
            }
        });
        r.gc();
    }

    public String ContarFilasTablasSQL(String Tabla, String Condicion) {
        String can = "";
        try {
            Base.st = Base.conec.createStatement();
            Base.rt = Base.st.executeQuery("select count(*) from " + Tabla.toLowerCase() + " " + Condicion);
            if (Base.rt.next()) {
                can = Base.rt.getString(1);
            }
            Base.rt.close();
            Base.st.close();
        } catch (Exception e) {

            mensaje.MensajeError("Error controlador contar filas:\n" + e.getMessage());
        }
        return can;
    }

    public boolean ConsultaSQL(String consulta, String Condicion) {
        boolean resp = false;
        try {
            Base.st = Base.conec.createStatement();
            Base.rt = Base.st.executeQuery(consulta.toLowerCase() + " " + Condicion);
            if (Base.rt.next()) {
                resp = true;
            }
            Base.rt.close();
            Base.st.close();
        } catch (Exception e) {

            mensaje.MensajeError("Error controlador contar filas:\n" + e.getMessage());
        }
        return resp;
    }

    public void LLenarComboJtableConBase_Datos(JComboBox Nombre_Combo, String ConsultaSQL, int PosicionA_Visualisar, JTable nombre_Tabla, int Posicion_combo_tabla) {
        LlenarCombo(Nombre_Combo, ConsultaSQL, PosicionA_Visualisar);
        DefaultCellEditor tabla_combo = new DefaultCellEditor(Nombre_Combo);
        nombre_Tabla.getColumnModel().getColumn(Posicion_combo_tabla).setCellEditor(tabla_combo);
    }

    public String InvertirChooserCombo(DateChooserCombo f) {
        String año, mes, dia;
        año = f.getText().substring(6, 10);
        mes = f.getText().substring(3, 5);
        dia = f.getText().substring(0, 2);
        return año + "-" + mes + "-" + dia;
    }

    public String DevolverFechaJDateChooser(JDateChooser dc) {
        String fecha = "";
        try {
            String formato = dc.getDateFormatString();
            Date date = dc.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            fecha = sdf.format(date);
        } catch (Exception e) {
            mensaje.MensajeAlerta("Error:\nElija una fecha valida.\n" + e.getMessage());
        }
        return fecha;
    }

    public static synchronized int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }

    public void SumarDias_A_Fecha(JDateChooser dt1, JDateChooser dt2, int yy, int mm, int dd) {
        try {
            int dia = dt1.getCalendar().get(Calendar.DAY_OF_MONTH);
            int mes = dt1.getCalendar().get(Calendar.MONTH) + 1;
            int año = dt1.getCalendar().get(Calendar.YEAR);
            String fecha = ((año + yy) + "-" + (mes + mm) + "-" + (dia + dd));
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaDate;
            fechaDate = formato.parse(fecha);
            dt2.setDate(fechaDate);
        } catch (ParseException ex) {
            Logger.getLogger(CLS_Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            mensaje.MensajeAlerta(ex.getMessage());
        }
    }

    public void Diseño_Ventanas_UpperEssential(String Tema) {
        try {
            UIManager.setLookAndFeel(new UpperEssentialLookAndFeel(Tema));
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CLS_Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String UltimoCodigo(String id, String tabla) {
        String codigo = "No hay códigos registrador";
        try {
            Base.st = Base.conec.createStatement();
            Base.rt = Base.st.executeQuery("Select " + id + " from " + tabla.toLowerCase() + " order by " + id + " DESC LIMIT 1");
            if (Base.rt.next()) {
                codigo = Base.rt.getString(1);
            }
//            Base.rt.close();
//            Base.st.close();

        } catch (SQLException e) {
            mensaje.MensajeAlerta("Error al identificar codigos: " + e.getMessage());
        }
        return codigo;
    }

    public void PulsarEnter(KeyEvent evento, JButton boton) {
        if (evento.getKeyCode() == evento.VK_ENTER) {
            boton.doClick();
        }
    }

    public void nomover(JInternalFrame f) {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) f.getUI();
        Component north = ui.getNorthPane();
        MouseMotionListener[] actions = (MouseMotionListener[]) north.getListeners(MouseMotionListener.class);
        for (int i = 0; i < actions.length; i++) {
            north.removeMouseMotionListener(actions[i]);
        }
        r.gc();
    }

    public void Limittxt(JTextField tx, KeyEvent e, int a) {

        if (tx.getText().length() > a) {
            e.consume();
        }
    }

    public void Unpunto(KeyEvent e, JTextField tpc) {
        char c;
        int i, j = 0;
        char t = e.getKeyChar();
        if ((tpc.getText().trim().length() == 0) && ((t == 46) /*|| (t == 48)*/)) {
            e.consume();
        } else {
            for (i = 1; i < tpc.getText().trim().length(); i++) {
                c = tpc.getText().charAt(i);
                if (c == '.') {
                    j++;
                }
                if ((j == 1) && (t == 46)) {
                    e.consume();
                    i = tpc.getText().length();
                }
            }
        }
        r.gc();
    }

    public double Redondear(double num, int candec) {
        long mlt = (long) Math.pow(10, candec);
        double rst = (Math.round(num * mlt) / (double) mlt);
        return rst;
    }

    public void AbrirInternalFrame(JInternalFrame InternalFra, JDesktopPane ContenedorFormularios) {
        String k = "";
        JInternalFrame[] a = ContenedorFormularios.getAllFrames();
        int filas = a.length;
        for (int i = 0; i < filas; i++) {
            String c = a[i].getToolTipText();
            if (InternalFra.getToolTipText().compareTo(c) == 0) {
                k = "Abierto";
            } else {
            }
        }
        if (k.compareTo("") == 0) {
            ContenedorFormularios.add(InternalFra);
            ContenedorFormularios.updateUI();
            InternalFra.show();
//             nomover(InternalFra);
        } else {
            mensaje.MensajeAlerta("La Ventana ---" + InternalFra.getToolTipText() + "--- ya se encuentra abierta.");
        }
        r.gc();
    }

    public void LimpiarTabla(JTable tabla) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    public void Foto(JLabel lb, JTextField tx, int ancho, int alto) {
        RutaImagen = "";
        JFileChooser dlg2 = new JFileChooser();
        dlg2.setFileFilter(filter);
        int opcion = dlg2.showOpenDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            String fil = dlg2.getSelectedFile().getPath();
            ImageIcon icon = new ImageIcon(fil);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
            //se genera el imageicon con la nueva imagen
            ImageIcon newicon = new ImageIcon(newimg);
            lb.setIcon(newicon);
//            lb.setSize(155,175);
            tx.setText(fil);
            RutaImagen = "";
        }
    }

    public int PosicionTabla(JTable tb) {
        int pos;
        pos = tb.getSelectedRow();
        return pos;
    }

    public String ValorTabla(JTable tb, int p1) {
        String valor;
        valor = tb.getValueAt(PosicionTabla(tb), p1).toString().trim();
        return valor;
    }

    public void PulsarEnter(KeyEvent evt, JComboBox cb) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            cb.requestFocus();
        }
    }

    public void PulsarEnter(KeyEvent evt, JTextField tx) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            tx.requestFocus();
        }
    }

    public void PulsarEnter(KeyEvent evt, JPasswordField tx) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            tx.requestFocus();
        }
    }

    public void Actualizarfoto(String DireccionFoto, String Tabla, String NombreAtribFoto, String CodigoIdentificador, JTable TBtabla, int posicion) {
        FileInputStream fis = null;
        try {
            File file = new File(DireccionFoto);
            fis = new FileInputStream(file);
            Base.prest = Base.getConnection().prepareStatement("update " + Tabla.toLowerCase() + " set " + NombreAtribFoto + "=? where " + CodigoIdentificador + "='" + TBtabla.getValueAt(TBtabla.getSelectedRow(), posicion).toString().trim() + "'");
            Base.prest.setBinaryStream(1, fis, (int) file.length());
            Base.prest.execute();
            mensaje.MensajeAlerta("Grabó exitosamente:\n" + Base.prest);
            Base.prest.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CLS_Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(CLS_Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void ValidarFoto(String Tabla, String IdentificadorFoto, String AtributoFoto, String ValorComparacion, int posicion, JLabel label, int ancho, int largo) {
        String a = ObtenerCodigo(Tabla, IdentificadorFoto, ValorComparacion, posicion);
        if (a == null) {
            label.setIcon(null);
            mensaje.MensajeAlerta("Esta persona no cuenta con una " + AtributoFoto);
        } else {
            CargarFotoJLabel(AtributoFoto, Tabla.toLowerCase(), IdentificadorFoto, ValorComparacion, label, ancho, largo);
        }
    }

    public void CargarFotoJLabel(String Fotografia, String Tabla, String IdentificadorFoto, String id, JLabel jlabel, int ancho, int alto) {
        Image dtCat = Devolverfoto(Fotografia, Tabla.toLowerCase(), IdentificadorFoto, id);
        Icon icon;
        if (dtCat != null) {
            icon = new ImageIcon(dtCat.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH));
            jlabel.setIcon(icon);
        } else {
            jlabel.setIcon(null);
        }
    }

    public Image Devolverfoto(String Fotografia, String Tabla, String IdentificadorFoto, String id) {
        try {
            Base.prest = Base.getConnection().prepareStatement("SELECT " + Fotografia + " from " + Tabla.toLowerCase() + " where " + IdentificadorFoto + " = ? ");
            Base.prest.setString(1, id);
            Base.rt = Base.prest.executeQuery();
            while (Base.rt.next()) {
                byte[] b = Base.rt.getBytes(Fotografia);
                if (b != null) {
                    data = ConvertirImagen(b);
                } else {
                    mensaje.MensajeError("Esta persona no cuenta con una Imagen");
                }
            }
            Base.rt.close();
        } catch (IOException ex) {
            Logger.getLogger(CLS_Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            mensaje.MensajeError("Error:\n" + e.getMessage());
        }
        return data;
    }

    public void AbrirRuta(JTextField Caja_texto, String tipo_archivo, String estencion_archivo) {
        File archivo;
        JFileChooser flcAbrirArchivo = new JFileChooser();
        flcAbrirArchivo.setFileFilter(new FileNameExtensionFilter(tipo_archivo, estencion_archivo));
        int resp = flcAbrirArchivo.showOpenDialog(null);
        if (resp == JFileChooser.APPROVE_OPTION) {
            archivo = flcAbrirArchivo.getSelectedFile();
            Caja_texto.setText(archivo.getAbsolutePath().replace('\\', '/'));
        }
    }

    public void Excel_A_MySQL(String Direccion_archivo, String Nombre_Tabla) {
        try {
            Base.st = Base.conec.createStatement();
            SQL1 = "LOAD DATA INFILE '" + Direccion_archivo + "' INTO TABLE " + Nombre_Tabla + " FIELDS TERMINATED BY ';' LINES TERMINATED BY '\n';";
            Base.st.executeQuery(SQL1);
            mensaje.MensajeAlerta("Inserto correctamente de Excel A MySQL.\n" + SQL1);
            Base.st.close();
        } catch (SQLException e) {
            mensaje.MensajeAlerta("Error:\n" + e.getMessage());
        }
    }

    public void EjecutarSentenciaSQL(String Sentencia) {
        try {
            Base.st = Base.conec.createStatement();
            SQL1 = Sentencia;
            Base.st.executeUpdate(SQL1.toUpperCase());
            Base.st.close();
            System.out.println("Sentencia Ejecutada:\n" + SQL1.toLowerCase());
        } catch (SQLException ex) {
            mensaje.MensajeError("Error al ejecutar sentencia:\n" + ex.getMessage());
        }
        r.gc();
    }

    private void FiltrarTabla(JTextField TXbuscar, int FilaTabla) {
        fil.setRowFilter(RowFilter.regexFilter(TXbuscar.getText().trim(), FilaTabla));
    }

    public void BuscarJtable(JTextField TXbuscar, JTable TB, int FilaTabla) {
        TXbuscar.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (TXbuscar.getText()).toUpperCase();
                TXbuscar.setText(cadena);
                FiltrarTabla(TXbuscar, FilaTabla);
            }
        });
        fil = new TableRowSorter(TB.getModel());
        TB.setRowSorter(fil);
    }

    public boolean VerificarRepiteEnTabla(JTable tabladetalle, JTable tablacomparacion, int columnadetalle, int columnacomparacion, JComboBox com) {
        boolean resp = false;
        for (int i = 0; i < tabladetalle.getRowCount(); i++) {
            if (tabladetalle.getValueAt(i, columnadetalle).toString().trim().equalsIgnoreCase(tablacomparacion.getValueAt(tablacomparacion.getSelectedRow(), columnacomparacion).toString().trim()) && tabladetalle.getValueAt(i, 7).toString().trim().equalsIgnoreCase(ObtenerCodigo("almacen", "descripcion", com.getSelectedItem().toString().trim(), 1))) {
                resp = true;
            }
        }
        return resp;
    }

    public void DescargarArchivoPDF_ServidorWEB(String Servidor, String Usuario, String Pss, String NomArchServ, String DirLocalDescarga) {
        String server = Servidor;
//        int port = 21;
        String user = Usuario;
        String pass = Pss;

        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(server);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // APPROACH #1: using retrieveFile(String, OutputStream)
            String remoteFile1 = "/oportunidadlaboral.constructoramls.com/PDF/" + NomArchServ;
            File downloadFile1 = new File(DirLocalDescarga);
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();

            if (success) {
                System.out.println("File #1 has been downloaded successfully.");
            }

            // APPROACH #2: using InputStream retrieveFileStream(String)
//            String remoteFile2 = "/oportunidadlaboral.constructoramls.com/PDF/prueba2.pdf";
//            File downloadFile2 = new File("D:/PRUEBA/prueba2.pdf");
//            OutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(downloadFile2));
//            InputStream inputStream = ftpClient.retrieveFileStream(remoteFile2);
//            byte[] bytesArray = new byte[4096];
//            int bytesRead = -1;
//            while ((bytesRead = inputStream.read(bytesArray)) != -1) {
//                outputStream2.write(bytesArray, 0, bytesRead);
//            }
//
//            success = ftpClient.completePendingCommand();
//            if (success) {
//                System.out.println("File #2 has been downloaded successfully.");
//            }
//            outputStream2.close();
//            inputStream.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Double RedondearDecimales(Double numero, Integer numeroDecimales) {
        return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
    }
}
