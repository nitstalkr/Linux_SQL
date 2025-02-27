/**
 * @author Francisco Javier Gordillo Aguilar - S22120154
 *         Alejandro Padilla Aguirre - S22120151
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class Conexion {
    
    String user = "prueba";
    String password = "abc123";
    String url = "jdbc:mysql://158.23.136.238:3306/BD_Pruebas";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection conx;
    public Connection hacerConexion(){
        try{
            Class.forName(driver);
            conx = DriverManager.getConnection(url, user, password);
            return conx;
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "No se pudo hacer la conexion a BD");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void cerrrarConexion(){
        try{
            if (conx != null && !conx.isClosed()){
                conx.close();
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage()); 
        }
    }

    public Connection getConx() {
        return conx;
    }
    
}
