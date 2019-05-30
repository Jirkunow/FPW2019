<%-- 
    Document   : scriviArticolo
    Created on : 12-mag-2019, 22.25.27
    Author     : gznag
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href = "resources/CSS/style-general.css">
        <link rel="stylesheet" type="text/css" href = "resources/CSS/grid.css">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Include header here -->
        <jsp:include page="header.jsp"/>
        <jsp:include page="nav.jsp"/>
        
        <c:if test="${param.salva == 'true'}" >
            <h2>Articolo con ID ${idArt} Salvato</h2>
        </c:if>
        <div class="span span-9-of-12 forms-section">
                    <form class = "span span-3-of-9">
                        <label>Titolo</label>
                    
                        <input type="text" name="Titolo" id = "titolo" placeholder="${articolo.getTitolo()}" required>
                   
                        <label>Autori</label>
                    
                        <input type="text" name="Autori" id = "Autori" placeholder="${articolo.getAutori()}" required>
                    
                        <label>Categoria:</label>
                    
                        <label>Servlet</label>
                        <input type="radio" name="Servlet" id = "Categoria" placeholder="Servlet" >
                        <label>php</label>
                        <input type="radio" name="php" id = "Categoria" placeholder="php" checked >
                        <br>
                        <label>Html/css</label>
                        <input type="radio" name="Html/css" id = "Categoria" placeholder="Html/css" >
                        <label>SQL</label>
                        <input type="radio" name="SQL" id = "Categoria" placeholder="SQL" >
                    
                        <label>Immagine</label>
                    
                        <input type="file" name="Immagine" id = "Immagine" placeholder="Immagine" required>
                        <br>
                        <label>Testo</label>
                    
                        <textarea>${articolo.getTesto()}</textarea>
                        
                        <button class="btn">
                            <a href="${pageContext.request.contextPath}/WritePaper?idArt=${idArt}&salva=true">
                                Salva
                            </a>
                        </button>
                    </form>
                </div>
    </body>
</html>
