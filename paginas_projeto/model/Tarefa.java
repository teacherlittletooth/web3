package model;

public class Tarefa {
    private int id;
    private String titulo;
    private String descricao;
    private String statusTarefa;
    private Usuario usuario;
    
    public Tarefa() {}

    public Tarefa(int id, String titulo, String descricao, String statusTarefa, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.statusTarefa = statusTarefa;
        this.usuario = usuario;
    }
    
    public Tarefa(String titulo, String descricao, String statusTarefa, Usuario usuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.statusTarefa = statusTarefa;
        this.usuario = usuario;
    }
    
    public Tarefa(int id, String titulo, String descricao, String statusTarefa) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.statusTarefa = statusTarefa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatusTarefa() {
        return statusTarefa;
    }

    public void setStatusTarefa(String statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", statusTarefa=" + statusTarefa + ", usuario=" + usuario + '}';
    }
            
}
