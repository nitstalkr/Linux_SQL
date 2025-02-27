/**
 * @author Francisco Javier Gordillo Aguilar - S22120154
 *         Alejandro Padilla Aguirre - S22120151
 */
package Models;

import java.time.LocalDate;

public class Producto {

    int id;
    String nombre;
    String descripcion;
    String serie;
    String color;
    LocalDate fechaAdq;
    String tipoAdq;
    String observaciones;
    int area;

    public Producto(int id, String nombre, String descripcion, String serie, String color, LocalDate fechaAdq, String tipoAdq, String observaciones, int area) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.serie = serie;
        this.color = color;
        this.fechaAdq = fechaAdq;
        this.tipoAdq = tipoAdq;
        this.observaciones = observaciones;
        this.area = area;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getFechaAdq() {
        return fechaAdq;
    }

    public void setFechaAdq(LocalDate fechaAdq) {
        this.fechaAdq = fechaAdq;
    }

    public String getTipoAdq() {
        return tipoAdq;
    }

    public void setTipoAdq(String tipoAdq) {
        this.tipoAdq = tipoAdq;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
