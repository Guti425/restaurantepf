package Vista;

import Conexion.ConexionDB;
import Modelo.Clientes;
import Controlador.ClientesDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientesGUI
{

    private JPanel main;
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton agregarButton;
    private JButton editarButton;
    private JButton eliminarButton;

    ClientesDAO clientesDAO = new ClientesDAO();

    public ClientesGUI()
    {
        agregarButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String nombre = textField2.getText();
                String telefono = textField3.getText();
                String correo = textField4.getText();

                Clientes clientes = new Clientes(1,nombre,telefono,correo);
                clientesDAO.agregar(clientes);
               obtenerDatos();
            }
        });

        editarButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String nombre = textField2.getText();
                String telefono = textField3.getText();
                String correo = textField4.getText();
                int id = Integer.parseInt(textField1.getText());

                Clientes clientes = new Clientes(id,nombre,telefono,correo);
                clientesDAO.actualizar(clientes);
                obtenerDatos();
            }
        });

        eliminarButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int id = Integer.parseInt(textField1.getText());
                clientesDAO.eliminar(id);
                obtenerDatos();
            }
        });


        table1.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);

                int selectFile = table1.getSelectedRow();

                if (selectFile >= 0)
                {
                    textField1.setText((String) table1.getValueAt(selectFile, 0));
                    textField2.setText((String) table1.getValueAt(selectFile, 1));
                    textField3.setText((String) table1.getValueAt(selectFile, 2));
                    textField4.setText((String) table1.getValueAt(selectFile, 3));
                }
            }
        });
    }

    ConexionDB conexionDB = new ConexionDB();
    public void obtenerDatos()
    {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID cliente");
        model.addColumn("Nombre");
        model.addColumn("Telefono");
        model.addColumn("Correo");

        table1.setModel(model);

        String[] dato = new String[4];

        Connection con = conexionDB.getConnection();

        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM clientes");

            while (rs.next())
            {
                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);

                model.addRow(dato);
            }
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
         JFrame frame = new JFrame("CRUD clientes");
         frame.setContentPane(new ClientesGUI().main);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack();
         frame.setVisible(true);
         frame.setSize(800,600);
         frame.setResizable(false);
    }
}
