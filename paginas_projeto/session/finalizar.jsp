<% 
    if( request.getSession().getAttribute("autenticado") != null ) {
        request.getSession().invalidate();
        response.sendRedirect("../index.html");
    }
%>