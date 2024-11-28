package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;
import model.Tarefa;

public class TarefaDAO {
    private static Connection conn;
    
    public TarefaDAO() throws ClassNotFoundException, SQLException {
        conn = Conexao.getConn();
    }
    
    public ArrayList<Tarefa> getAllTasks(Usuario u) throws SQLException {
        
        ArrayList<Tarefa> list = new ArrayList();
        
        String query = "select * from tarefas where id_usuario = " + u.getId();
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        ResultSet res = prep.executeQuery();
        
        while( res.next() ) {
            Tarefa task = new Tarefa();
            
            task.setId( res.getInt("id") );
            task.setTitulo(res.getString("titulo") );
            task.setDescricao(res.getString("descricao") );
            task.setStatusTarefa(res.getString("status_tarefa") );
            task.setUsuario( u );
            
            list.add(task);
        }
        
        prep.close();
        return list;
    }
    
    
    public void setNewTask(Tarefa task, int id) throws SQLException {
        String query = "insert into tarefas(titulo, descricao, status_tarefa, id_usuario) "
                     + "values(?, ?, ?, ?)";
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        prep.setString(1, task.getTitulo() );
        prep.setString(2, task.getDescricao() );
        prep.setString(3, task.getStatusTarefa() );
        prep.setInt(4, id );
                
        prep.execute();
        prep.close();
    }
    
    
    public void deleteTask(int id) throws SQLException {
        String query = "delete from tarefas "
                     + "where id = " + id ;
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        prep.execute();
        prep.close();
    }
    
    
    public Tarefa getOneTask(int id) throws SQLException {
        String query = "select * from tarefas where id = " + id;
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        ResultSet res = prep.executeQuery();
        
        Tarefa t = new Tarefa();
        
        if( res.next() ) {
            t.setId(id);
            t.setTitulo(res.getString("titulo"));
            t.setDescricao(res.getString("descricao"));
            t.setStatusTarefa(res.getString("status_tarefa"));
        }
        
        prep.close();
        return t;
    }
    
    
    public void updateTask(Tarefa task) throws SQLException {
        String query = "update tarefas set titulo = ?, "
                     + "descricao = ?, status_tarefa = ? "
                     + "where id = ?";
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        prep.setString(1, task.getTitulo() );
        prep.setString(2, task.getDescricao() );
        prep.setString(3, task.getStatusTarefa() );
        prep.setInt(4, task.getId() );
        
        prep.execute();
        prep.close();
    }
}
