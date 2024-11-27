package controller;

import org.apache.commons.codec.digest.DigestUtils;
import java.sql.SQLException;
import database.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

@WebServlet(name = "UsuarioController", urlPatterns = {"/usuario-controller"})
public class UsuarioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String pagina = request.getParameter("pagina");

        if (pagina.equals("login")) {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            Usuario u = new Usuario(email, DigestUtils.sha1Hex(senha));
            
            try {
                if( u.login() ) {
                    HttpSession session = request.getSession();
                    session.setAttribute("autenticado", true);
                    
                    response.sendRedirect("inicio.jsp");
                } else {
                    response.sendRedirect("index.html");
                }
            } catch(SQLException | ClassNotFoundException erro) {
                System.err.println( erro );
            }
        }
        
        if (pagina.equals("cadastro")) {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String nascimento = request.getParameter("nasc");
            String senha = request.getParameter("senha");
            boolean noticias = request.getParameter("noticias") != null;

            Usuario u = new Usuario(nome, email, nascimento, senha, noticias);

            try {
                UsuarioDAO uDao = new UsuarioDAO();
                uDao.setNewUser(u);

                response.sendRedirect("index.html");
            } catch (SQLException | ClassNotFoundException erro) {
                System.err.println(erro);
            }
        }
        
        
        if(pagina.equals("excluir")) {
            int id = Integer.parseInt( request.getParameter("id") );
            
            try {
                UsuarioDAO dao = new UsuarioDAO();
                dao.deleteUser(id);
                response.sendRedirect("inicio.jsp");
            } catch(ClassNotFoundException | SQLException erro) {
                System.err.println( erro );
            }
        }
        
        
        if(pagina.equals("editar")) {
            int id = Integer.parseInt( request.getParameter("id") );
            
            try {
                UsuarioDAO dao = new UsuarioDAO();
                Usuario u = dao.getOneUser(id);
                request.setAttribute("user", u);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
            } catch(ClassNotFoundException | SQLException erro) {
                System.err.println( erro );
            }
        }
        
        
        if (pagina.equals("atualizar")) {
            int id = Integer.parseInt( request.getParameter("id") );
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String nascimento = request.getParameter("nasc");
            boolean noticias = request.getParameter("noticias") != null;

            Usuario u = new Usuario(id, nome, email, nascimento, noticias);

            try {
                UsuarioDAO uDao = new UsuarioDAO();
                uDao.updateUser(u);

                response.sendRedirect("inicio.jsp");
            } catch (SQLException | ClassNotFoundException erro) {
                System.err.println(erro);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
