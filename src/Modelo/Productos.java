package Modelo;

public class Productos
{
    //variables de productos
    int id_productos;
    String nombre;
    int precio;
    String disponibilidad;

    String categoria;

    public Productos(int id_empleados, String nombre, String disponibilidad, int precio, String categoria)
    {
        this.id_productos = id_productos;
        this.nombre = nombre;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.categoria = categoria;
    }

    public int getId_productos() {
        return id_productos;
    }

    public void setId_productos(int id_productos) {
        this.id_productos = id_productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
