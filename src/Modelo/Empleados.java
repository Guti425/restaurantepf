package Modelo;

public class Empleados
{
    int id_empleados;
    String nombre;
    int salario;
    String cargo;

    public Empleados(int id_empleados, String nombre, String cargo, int salario)
    {
        this.id_empleados = id_empleados;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
    }

    public int getId_empleados() {
        return id_empleados;
    }

    public void setId_empleados(int id_empleados) {
        this.id_empleados = id_empleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


}
