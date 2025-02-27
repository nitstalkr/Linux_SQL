/**
 * @author Francisco Javier Gordillo Aguilar - S22120154
 *         Alejandro Padilla Aguirre - S22120151
 */
package DAOs;

import Conexion.Conexion;
import Models.Area;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class AreasDao {

    public static boolean registrarArea(Area area) {
        Conexion conAct = new Conexion();
        try {

            conAct.hacerConexion();

            String query = "INSERT INTO areas (nombre, ubicacion) VALUES (?,?);";
            PreparedStatement ps = conAct.getConx().prepareStatement(query);
            ps.setString(1, area.getNombre());
            ps.setString(2, area.getUbicacion());

            ps.executeUpdate();

            conAct.cerrrarConexion();

            JOptionPane.showMessageDialog(null, "Area insertada correctamente");
            
            return true;

        } catch (SQLException s) {
            System.out.println("Algo salio mal durante la operacion insert en sql");
            JOptionPane.showMessageDialog(null, "Area no insertada");
            System.out.println(s.getMessage());
            conAct.cerrrarConexion();
            return false;
        }

    }
    
    public static boolean modificarArea(Area area) {
        Conexion conAct = new Conexion();
        try {

            
            conAct.hacerConexion();

            String query = "UPDATE areas SET nombre = ?, ubicacion = ? WHERE id = ?;";
            PreparedStatement ps = conAct.getConx().prepareStatement(query);
            ps.setString(1, area.getNombre());
            ps.setString(2, area.getUbicacion());
            ps.setInt(3, area.getId());


            ps.executeUpdate();

            conAct.cerrrarConexion();

            JOptionPane.showMessageDialog(null, "Area actualizada correctamente");
            
            return true;

        } catch (SQLException s) {
            System.out.println("Algo salio mal durante la operacion update en sql");
            JOptionPane.showMessageDialog(null, "Area no actualizada");
            System.out.println(s.getMessage());
            conAct.cerrrarConexion();
            return false;
        }

    }
    
    public static boolean borrarArea(Area area) {
        Conexion conAct = new Conexion();
        try {

            
            conAct.hacerConexion();

            String query = "DELETE FROM areas WHERE id = ?";
            PreparedStatement ps = conAct.getConx().prepareStatement(query);
            ps.setInt(1, area.getId());
            
            ps.executeUpdate();

            conAct.cerrrarConexion();

            JOptionPane.showMessageDialog(null, "Area eliminada correctamente");
            
            return true;

        } catch (SQLException s) {
            System.out.println("Algo salio mal durante la operacion delete en sql");
            JOptionPane.showMessageDialog(null, "Area no borrada");
            System.out.println(s.getMessage());
            conAct.cerrrarConexion();
            return false;
        }

    }
    
    public static ArrayList<Area> buscarAreas(){
        ArrayList<Area> resultado = new ArrayList<>();
        
        Conexion conAct = new Conexion();
        try {            
            conAct.hacerConexion();

            String query = "SELECT * FROM areas;";
            PreparedStatement ps = conAct.getConx().prepareStatement(query);
            ResultSet res = ps.executeQuery();
        
            
            while(res.next()){
                int id = res.getInt("id");
                String nombre = res.getString("nombre");
                String ubicacion = res.getString("ubicacion");
                
                Area act = new Area(id, nombre, ubicacion);
                resultado.add(act);
            }
            
            
            conAct.cerrrarConexion();
            res.close();
            
            return resultado;

        } catch (SQLException s) {
            System.out.println("Algo salio mal al consultar las areas en sql");
            System.out.println(s.getMessage());
            conAct.cerrrarConexion();
            return null;
        }
    }
}
