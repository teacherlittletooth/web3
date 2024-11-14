package controller;

import java.sql.SQLException;
import database.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet(name = "UsuarioController", urlPatterns = {"/usuario-controller"})
public class UsuarioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pagina = request.getParameter("pagina");

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
