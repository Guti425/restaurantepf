package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB
{
    public Connection getConnection()
    {
        Connection con = null;

        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurantedb","root","");
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        return con;
    }
}
