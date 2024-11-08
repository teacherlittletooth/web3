package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public static Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/sistema_n" ,
                "root" ,
                "root"
        );
        
        System.out.println("Conectado!");
        return conn;
    }
    
}
