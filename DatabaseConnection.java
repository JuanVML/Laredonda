package Vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
   private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Laredonda;encrypt=true;trustServerCertificate=true;";

    private static final String USER = "sa"; // Usuario predeterminado de SQL Server
    private static final String PASSWORD = "12345678"; //contraseña de mi usuario en sql server

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static boolean validateLogin(String username, String password) {
        String query = "SELECT COUNT(*) FROM Usuarios WHERE NombreUsuario = ? AND Contrasena = ?";
        
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
