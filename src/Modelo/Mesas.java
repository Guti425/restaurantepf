package Modelo;

public class Mesas
{
    //variables de mesas

    String capacidad;

    String estado;

    int id_mesas;


    public Mesas(int id_mesas, String capacidad, String estado)
    {
        this.id_mesas = id_mesas;
        this.estado = estado;
        this.capacidad = capacidad;

    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_mesas() {
        return id_mesas;
    }

    public void setId_mesas(int id_mesas) {
        this.id_mesas = id_mesas;
    }
}
