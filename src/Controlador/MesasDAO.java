package Controlador;
import Conexion.ConexionDB;
import Modelo.Mesas;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MesasDAO
{
    //mesas
    ConexionDB conexionDB = new ConexionDB();
    //Agregar

    public void agregar (Mesas mesas)
    {
        Connection con = conexionDB.getConnection();

        String query = "INSERT INTO Mesas (capacidad, estado) VALUES (?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, mesas.getCapacidad());
            pst.setString(2, mesas.getEstado());


            int resultado = pst.executeUpdate();

            if (resultado > 0)
            {
                JOptionPane.showMessageDialog(null, "Registro agregado con exito.");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Regostro NO agreado con exito.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en la ejecucion");
        }
    }

    public void actualizar (Mesas mesas) {
        Connection con = conexionDB.getConnection();

        String query = "UPDATE mesas SET capacidad = ?, estado = ? WHERE id_mesas = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, mesas.getCapacidad());
            pst.setString(2, mesas.getEstado());


            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro actualizado con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "Regostro NO actualizado con exito.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en la ejecucion");
        }
    }

    public void eliminar(int id)
    {
        Connection con = conexionDB.getConnection();

        String query = "DELETE FROM mesas WHERE id_mesas = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1,id);


            int resultado = pst.executeUpdate();

            if (resultado > 0)
            {
                JOptionPane.showMessageDialog(null, "Registro eliminado con exito.");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Registro NO eliminado con exito.");
            }


        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en la ejecucion");
        }
    }
}
