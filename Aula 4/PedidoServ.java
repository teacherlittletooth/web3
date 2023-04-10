package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "PedidoServ", urlPatterns = {"/PedidoServ"})
public class PedidoServ extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Recebendo os parâmetros enviados pelo formulário
        String produto = request.getParameter("produto");
        float preco = Float.parseFloat(request.getParameter("preco"));
        int qtd = Integer.parseInt(request.getParameter("qtd"));
        float total = (preco * qtd);
        float totalDesc;
        String desconto;
        
        if(qtd > 2){
            desconto = "Desconto aplicado!";
            totalDesc = total - (total * 0.05f);
        } else {
            desconto = "Sem desconto.";
            totalDesc = total;
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado</title>");
            out.println("<link rel='stylesheet' href='css/style.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Dados do pedido</h1>");
            out.println("<h3>Produto: "+ produto +"</h3>");
            out.println("<h3>Preço: "+ preco +"</h3>");
            out.println("<h3>Quantidade: "+ qtd +"</h3>");
            out.println("<h3>Total: R$ "+ String.format("%.2f", totalDesc) +"</h3>");
            out.println("<h3>"+ desconto +"</h3>");
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
