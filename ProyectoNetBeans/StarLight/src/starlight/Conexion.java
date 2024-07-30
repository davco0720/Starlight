package starlight;

import javax.swing.*;
import java.sql.*;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/BD_Expotec?useSSL=false";
    private static final String User = "root";
    private static final String Pass = "2890";

    public static Connection ConexionBD() {

        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, User, Pass);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado en la conexion" + e, "ERROR 1", 2);
        }
        return conexion;
    }
}
