package Modelo;

public class Clientes
{
    int id_clientes;
    String nombre;
    String telefono;
    String correo;

    public Clientes(int id_clientes, String nombre, String telefono, String correo)
    {
        this.id_clientes = id_clientes;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId_clientes() {
        return id_clientes;
    }

    public void setId_clientes(int id_clientes) {
        this.id_clientes = id_clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
