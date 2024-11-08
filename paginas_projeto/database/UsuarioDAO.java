package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioDAO {
    
    private static Connection conn;
    
    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        conn = Conexao.getConn();
    }
    
    public ArrayList<Usuario> getAllUsers() throws SQLException {
        
       ArrayList<Usuario> list = new ArrayList(); 
       
       String query = "select * from usuarios;";
       
       PreparedStatement prep = conn.prepareStatement(query);
       
       ResultSet res = prep.executeQuery();
       
       //Continua...
       
       return list;
    }
}
