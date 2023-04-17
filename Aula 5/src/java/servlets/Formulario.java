package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "Form", urlPatterns = {"/Form"})
public class Formulario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String data;
        if(request.getParameter("data").isEmpty()) {
            data = "Nenhuma data informada";
        } else {
            data = request.getParameter("data");
        }
               
        String idade;
        if(request.getParameter("idade") == null) {
            idade = "Idade não informada";
        } else {
            idade = request.getParameter("idade");
        }
        
        String descricao;
        if(request.getParameter("descricao").isEmpty()){
            descricao = "Descrição não fornecida";
        } else {
            descricao = request.getParameter("descricao");
        }
                
        
        String turnos = "";
        //Verificando o envio de determinado parâmetro
        if(request.getParameterValues("turno[]") != null) {
            String turno[] = request.getParameterValues("turno[]");
            
            //Varrendo array e lançando seus dados noutra String
            for(int i=0; i < turno.length; i++){
                turnos += turno[i] + "\n";
            }
        } else {
            turnos = "Nenhum turno informado";
        }
        
        //Criando parâmetros para serem encaminhados à JSP
        request.setAttribute("data", data);
        request.setAttribute("idade", idade);
        request.setAttribute("turnos", turnos);
        request.setAttribute("descricao", descricao);
        
        //Encaminhar parâmetros para a JSP
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
                
        
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
        return "Short description";
    }

}
