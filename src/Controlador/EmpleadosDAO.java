package Controlador;
import Conexion.ConexionDB;
import Modelo.Empleados;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpleadosDAO
{
    ConexionDB conexionDB = new ConexionDB();
    //Agregar

    public void agregar (Empleados empleados)
    {
        Connection con = conexionDB.getConnection();

        String query = "INSERT INTO empleados (nombre, cargo, salario) VALUES (?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, empleados.getNombre());
            pst.setString(2, empleados.getCargo());
            pst.setString(3, empleados.getSalario());

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

    public void actualizar (Empleados empleados) {
        Connection con = conexionDB.getConnection();

        String query = "UPDATE empleados SET nombre = ?, cargo = ?, salario = ?, WHERE id_empleados = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, empleados.getNombre());
            pst.setString(2, empleados.getCargo());
            pst.setString(3, empleados.getSalario());

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

