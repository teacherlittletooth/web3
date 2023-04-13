package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Formulario", urlPatterns = {"/Formulario"})
public class Formulario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Capturar dados do formulário, verificando se porventura são nulos
        String data;
        if(!request.getParameter("data").isEmpty()) {
             data = request.getParameter("data");
        } else {
            data = "Data não enviada";
        }
        
        String idade;
        if(!request.getParameter("idade").isEmpty()) {
             idade = request.getParameter("idade");
        } else {
            idade = "Idade não enviada";
        }
        
        String descricao;
        if(!request.getParameter("descricao").isEmpty()) {
             descricao = request.getParameter("descricao");
        } else {
            descricao = "Descrição não enviada";
        }
        
        String interesses = "";
        String interesse[];
        if(request.getParameterValues("interesse") != null) {
             interesse = request.getParameterValues("interesse");
             //Com a lista "interesse" preenchida, agora vamos varrê-la
             //e jogar cada valor desta na String interesses.
             for(int i=0; i < interesse.length; i++) {
                 interesses += "- " + interesse[i] + "<br>";
             }
        } else {
            interesses = "Nenhum interesse";
        }
        
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Formulário</title>");            
            out.println("<link rel='stylesheet' href='css/style.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+ data +"</h1>");
            out.println("<h1>"+ idade +"</h1>");
            out.println("<h1>"+ interesses +"</h1>");
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
        return "Validações de back-end";
    }

}
