<%
    if( request.getSession().getAttribute("autenticado") == null ) {
        response.sendRedirect("index.html");
    }
%>