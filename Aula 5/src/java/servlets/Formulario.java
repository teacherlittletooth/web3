package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Formulario", urlPatterns = {"/Formulario"})
public class Formulario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Recebendo parâmetros do formulário
        String data = request.getParameter("data");
        String idade = request.getParameter("idade");
        String descricao = request.getParameter("descricao");
        String turnos = ""; //Variável para receber os turnos
        
        //Validação: só irá criar o array "turno[]" se alguma caixa for marcada
        if(request.getParameterValues("turno[]") != null) {
            //Capturando parâmetro do tipo array (lista)
            String turno[] = request.getParameterValues("turno[]");
            
            //Varrendo lista e jogando dados para a variável turnos
            for(int i=0; i < turno.length; i++) {
                turnos += turno[i] + "<br>";
            }
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Formulário</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+ data +"</h1>");
            out.println("<h1>"+ idade +"</h1>");
            out.println("<h1>"+ turnos +"</h1>");
            out.println("<h1>"+ descricao +"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Formulário";
    }

}
