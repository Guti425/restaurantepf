package Controlador;
import Modelo.Clientes;
import Conexion.ConexionDB;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientesDAO
{
    ConexionDB conexionDB = new ConexionDB();
    //Agregar

    public void agregar (Clientes clientes)
    {
        Connection con = conexionDB.getConnection();

        String query = "INSERT INTO clientes (nombre, telefono, correo) VALUES (?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, clientes.getNombre());
            pst.setString(2, clientes.getTelefono());
            pst.setString(3, clientes.getCorreo());

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

    public void actualizar (Clientes clientes) {
        Connection con = conexionDB.getConnection();

        String query = "UPDATE clientes SET nombre = ?, telefono = ?, correo = ?, WHERE id_clientes = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, clientes.getNombre());
            pst.setString(2, clientes.getTelefono());
            pst.setString(3, clientes.getCorreo());

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

        String query = "DELETE FROM clientes WHERE id_clientes = ?";

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
