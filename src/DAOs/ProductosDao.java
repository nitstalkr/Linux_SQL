/**
 * @author Francisco Javier Gordillo Aguilar - S22120154
 *         Alejandro Padilla Aguirre - S22120151
 */
package DAOs;

import Models.Producto;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.time.LocalDate;

public class ProductosDao {

    public static boolean registrarProd(Producto prod) {
        Conexion conAct = new Conexion();
        try {

            conAct.hacerConexion();

            String query = "INSERT INTO productos (nombre, descripcion, serie, color, fechaAdq, tipoAdq, observaciones, area) VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement ps = conAct.getConx().prepareStatement(query);
            ps.setString(1, prod.getNombre());
            ps.setString(2, prod.getDescripcion());
            ps.setString(3, prod.getSerie());
            ps.setString(4, prod.getColor());
            ps.setDate(5, java.sql.Date.valueOf(prod.getFechaAdq()));
            ps.setString(6, prod.getTipoAdq());
            ps.setString(7, prod.getObservaciones());
            ps.setInt(8, prod.getArea());

            ps.executeUpdate();

            conAct.cerrrarConexion();

            JOptionPane.showMessageDialog(null, "Producto insertado correctamente");
            
            return true;

        } catch (SQLException s) {
            System.out.println("Algo salio mal durante la operacion insert en sql");
            JOptionPane.showMessageDialog(null, "Producto no insertado");
            System.out.println(s.getMessage());
            conAct.cerrrarConexion();
            return false;
        }

    }
    
    public static boolean modificarProd(Producto prod) {
        Conexion conAct = new Conexion();
        try {

            
            conAct.hacerConexion();

            String query = "UPDATE productos SET nombre = ?, descripcion = ?, serie = ?, color = ?, fechaAdq = ?, tipoAdq = ?, observaciones = ?, area = ? WHERE id = ?;";
            PreparedStatement ps = conAct.getConx().prepareStatement(query);
            ps.setString(1, prod.getNombre());
            ps.setString(2, prod.getDescripcion());
            ps.setString(3, prod.getSerie());
            ps.setString(4, prod.getColor());
            ps.setDate(5, java.sql.Date.valueOf(prod.getFechaAdq()));
            ps.setString(6, prod.getTipoAdq());
            ps.setString(7, prod.getObservaciones());
            ps.setInt(8, prod.getArea());
            ps.setInt(9, prod.getId());


            ps.executeUpdate();

            conAct.cerrrarConexion();

            JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
            
            return true;

        } catch (SQLException s) {
            System.out.println("Algo salio mal durante la operacion update en sql");
            JOptionPane.showMessageDialog(null, "Producto no actualizado");
            System.out.println(s.getMessage());
            conAct.cerrrarConexion();
            return false;
        }

    }
    
    public static boolean borrarProd(Producto prod) {
        Conexion conAct = new Conexion();
        try {

            
            conAct.hacerConexion();

            String query = "DELETE FROM productos WHERE id = ?";
            PreparedStatement ps = conAct.getConx().prepareStatement(query);
            ps.setInt(1, prod.getId());
            
            ps.executeUpdate();

            conAct.cerrrarConexion();

            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
            
            return true;

        } catch (SQLException s) {
            System.out.println("Algo salio mal durante la operacion delete en sql");
            JOptionPane.showMessageDialog(null, "Producto no borrado");
            System.out.println(s.getMessage());
            conAct.cerrrarConexion();
            return false;
        }

    }
    
    public static ArrayList<Producto> buscarProductos(){
        ArrayList<Producto> resultado = new ArrayList<>();
        
        Conexion conAct = new Conexion();
        try {            
            conAct.hacerConexion();

            String query = "SELECT * FROM productos;";
            PreparedStatement ps = conAct.getConx().prepareStatement(query);
            ResultSet res = ps.executeQuery();
        
            
            while(res.next()){
                int id = res.getInt("id");
                String nombre = res.getString("nombre");
                String descripcion = res.getString("descripcion");
                String serie = res.getString("serie");
                String color = res.getString("color");
                LocalDate fechaAdq = res.getDate("fechaAdq").toLocalDate();
                String tipoAdq = res.getString("tipoAdq");
                String observaciones = res.getString("observaciones");
                int area = res.getInt("area");
                Producto act = new Producto(id, nombre, descripcion, serie, color, fechaAdq, tipoAdq, observaciones, area);
                resultado.add(act);
            }
            
            
            conAct.cerrrarConexion();
            res.close();
            
            return resultado;

        } catch (SQLException s) {
            System.out.println("Algo salio mal al consultar los productos en sql");
            System.out.println(s.getMessage());
            conAct.cerrrarConexion();
            return null;
        }
    }
}
