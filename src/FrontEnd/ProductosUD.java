package FrontEnd;

import DAOs.AreasDao;
import DAOs.ProductosDao;
import Models.Area;
import Models.Producto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


/**
 * @author Francisco Javier Gordillo Aguilar - S22120154
 *         Alejandro Padilla Aguirre - S22120151
 */
public class ProductosUD extends javax.swing.JFrame {
    ArrayList <Area> areas;
    
    boolean tipoDeOperacion = true;
    /**
     * Crea una instancia de Editar pero con el objetivo de guardar
     */
    public ProductosUD() {
        initComponents();
        cargarAreas();
        this.txtID.setEditable(false);
        this.tipoDeOperacion = true;
        this.labelOperacion.setText("Guardar");
        
        setLocationRelativeTo(null); // Centra la ventana
    }
    
    /**
     * Crea una instancia de Editar para editar un producto
     * @param paraEditar
     */
    public ProductosUD(Producto paraEditar) {
        initComponents();
        cargarAreas();
        this.tipoDeOperacion = false;
        this.labelOperacion.setText("Editar");
        this.txtID.setEditable(false);
        setValores(paraEditar);
       
        setLocationRelativeTo(null); // Centra la ventana
    }
    public void cargarAreas(){
        this.areas = AreasDao.buscarAreas();
        this.CbxArea.removeAllItems();
        for(Area x : this.areas){
            this.CbxArea.addItem(x.getNombre());
        }
        this.CbxArea.revalidate();
        this.CbxArea.repaint();
    }
    public int buscarIdArea(String nombre){
        for(Area x : this.areas){
            if(x.getNombre().equals(nombre)) return x.getId();
        }
        return -1;
    }
    public String buscarNombreArea(int id){
        for(Area x : this.areas){
            if(x.getId() == id) return x.getNombre();
        }
        return null;
    }
    public void setValores(Producto act){
        this.txtID.setText(act.getId()+"");
        this.txtNombre.setText(act.getNombre());
        this.txtFecha.setText(arrFecha(act.getFechaAdq().format(DateTimeFormatter.ISO_DATE)));
        this.txtColor.setText(act.getColor());
        this.txtSerie.setText(act.getSerie());
        this.txtObservaciones.setText(act.getObservaciones());
        this.txtDescripcion.setText(act.getDescripcion());
        this.CbxAdquisicion.setSelectedItem(act.getTipoAdq());
        this.CbxArea.setSelectedItem(buscarNombreArea(act.getArea()));
    }    
    
    private String arrFecha(String x){
        String fechaArreglada = "";
        String datos [] = x.split("-");
        fechaArreglada += datos[2] + "/";
        fechaArreglada += datos[1] + "/";
        fechaArreglada += datos[0];
         return fechaArreglada;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        descripcion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtColor = new javax.swing.JTextField();
        txtSerie = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNombre3 = new javax.swing.JLabel();
        lblNombre4 = new javax.swing.JLabel();
        lblNombre5 = new javax.swing.JLabel();
        guardar = new javax.swing.JLabel();
        obv = new javax.swing.JLabel();
        CbxArea = new javax.swing.JComboBox<>();
        CbxAdquisicion = new javax.swing.JComboBox<>();
        txtFecha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BtnSalir = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        labelOperacion = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 120, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 120, -1));

        lblID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblID.setText("ID");
        jPanel1.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane1.setViewportView(txtObservaciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 210, 100));

        descripcion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        descripcion.setText("Descripcion");
        jPanel1.add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 210, 100));
        jPanel1.add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 110, -1));
        jPanel1.add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 110, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Color");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Serie");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        lblNombre3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre3.setText("Fecha.Ad");
        jPanel1.add(lblNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lblNombre4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre4.setText("Area");
        jPanel1.add(lblNombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));

        lblNombre5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre5.setText("Tipo adquisicion");
        jPanel1.add(lblNombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/verified_10812227.png"))); // NOI18N
        guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarMouseClicked(evt);
            }
        });
        jPanel1.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, -1, -1));

        obv.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        obv.setText("Observaciones");
        jPanel1.add(obv, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        CbxArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));
        jPanel1.add(CbxArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 110, -1));

        CbxAdquisicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COMPRA", "DONACION", "TRANSFERENCIA" }));
        jPanel1.add(CbxAdquisicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 170, -1));
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 120, -1));

        jLabel1.setText("(dd/mm/aaaa)");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnSalir.setBackground(new java.awt.Color(255, 204, 204));
        BtnSalir.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        BtnSalir.setText("Salir");
        BtnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSalirMouseClicked(evt);
            }
        });
        jPanel2.add(BtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 60, 20));

        cancelar.setBackground(new java.awt.Color(255, 204, 204));
        cancelar.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarMouseClicked(evt);
            }
        });
        jPanel2.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 90, 20));

        labelOperacion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelOperacion.setText("LABEL");
        jPanel2.add(labelOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 50));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/200w (1).gif"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 420));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseClicked
        mainProductos act = new mainProductos();
        act.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelarMouseClicked

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
        String nombreN = this.txtNombre.getText();
        String descripcionN = this.txtDescripcion.getText();
        String serieN = this.txtSerie.getText();
        String colorN = this.txtColor.getText();
        String datosFecha [] = this.txtFecha.getText().split("/");
        
        int dia=Integer.parseInt(datosFecha[0]);
        int mes=Integer.parseInt(datosFecha[1]);
        int anio=Integer.parseInt(datosFecha[2]);
        LocalDate fechaAdqN = LocalDate.of(anio, mes, dia);
        
        String tipoAdqN = this.CbxAdquisicion.getItemAt(this.CbxAdquisicion.getSelectedIndex());
        String observacionesN = this.txtObservaciones.getText();
        int areaN = buscarIdArea(this.CbxArea.getItemAt(this.CbxArea.getSelectedIndex()));
        
        if(tipoDeOperacion){
           Producto nuevo = new Producto(0, nombreN, descripcionN, serieN, colorN, fechaAdqN, tipoAdqN, observacionesN, areaN);
           ProductosDao.registrarProd(nuevo);
        }else{
           int id = Integer.parseInt(this.txtID.getText());
           Producto nuevo = new Producto(id, nombreN, descripcionN, serieN, colorN, fechaAdqN, tipoAdqN, observacionesN, areaN);
           ProductosDao.modificarProd(nuevo);
        }
        
        
        mainProductos act = new mainProductos();
        act.setVisible(true);
        dispose();
    }//GEN-LAST:event_guardarMouseClicked

    private void BtnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_BtnSalirMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSalir;
    private javax.swing.JComboBox<String> CbxAdquisicion;
    private javax.swing.JComboBox<String> CbxArea;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel descripcion;
    private javax.swing.JLabel guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelOperacion;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel obv;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
