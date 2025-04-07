package Controlador;
import Conexion.ConexionDB;
import Modelo.Productos;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductosDAO
{
    //productos
    ConexionDB conexionDB = new ConexionDB();
    //Agregar

    public void agregar (Productos productos)
    {
        Connection con = conexionDB.getConnection();

        String query = "INSERT INTO Productos (nombre, categoria, precio, disponibilidad) VALUES (?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, productos.getNombre());
            pst.setString(2, productos.getCategoria());
            pst.setInt(3, productos.getPrecio());
            pst.setString(4, productos.getDisponibilidad());

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

    public void actualizar (Productos productos) {
        Connection con = conexionDB.getConnection();

        String query = "UPDATE productos SET nombre = ?, categoria = ?, precio = ?, disponibilidad = ? WHERE id_productos = ?";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, productos.getNombre());
            pst.setString(2, productos.getCategoria());
            pst.setInt(3, productos.getPrecio());
            pst.setString(4, productos.getDisponibilidad());

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

        String query = "DELETE FROM productos WHERE id_productos = ?";

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

