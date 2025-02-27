/**
 * @author Francisco Javier Gordillo Aguilar - S22120154
 *         Alejandro Padilla Aguirre - S22120151
 */
package Models;

public class Area {

    int id;
    String nombre;
    String ubicacion;

    public Area(int id, String nombre, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
   
}