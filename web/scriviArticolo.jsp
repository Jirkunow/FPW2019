<%-- 
    Document   : scriviArticolo
    Created on : 12-mag-2019, 22.25.27
    Author     : gznag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
        <div class="span span-9-of-12 forms-section">
                    <form class = "span span-3-of-9">
                        <label>Titolo</label>
                    </form>
                    <form class="span span-5-of-9">
                        <input type="text" name="Titolo" id = "titolo" placeholder="Scrivi il tuo titolo" required>
                    </form>
                    <form class = "span span-3-of-9">
                        <label>Autori</label>
                    </form>
                    <form class="span span-5-of-9">
                        <input type="text" name="Autori" id = "Autori" placeholder="Nome autori" required>
                    </form>
                    <form class = "span span-3-of-9">
                        <label>Categoria:</label>
                    </form>
                    <form class="span span-5-of-9">
                        <label>Servlet</label>
                        <input type="radio" name="Servlet" id = "Categoria" placeholder="Servlet" >
                        <label>php</label>
                        <input type="radio" name="php" id = "Categoria" placeholder="php" checked >
                        <br>
                        <label>Html/css</label>
                        <input type="radio" name="Html/css" id = "Categoria" placeholder="Html/css" >
                        <label>SQL</label>
                        <input type="radio" name="SQL" id = "Categoria" placeholder="SQL" >
                    </form>
                    <form class = "span span-3-of-9">
                        <label>Immagine</label>
                    </form>
                    <form class="span span-5-of-9">
                        <input type="file" name="Immagine" id = "Immagine" placeholder="Immagine" required>
                    </form>
                    <form class = "span span-3-of-9">
                        <label>Testo</label>
                    </form>
                    <form class="span span-5-of-9">
                        <textarea></textarea>
                    </form>
                    <div class="span span-4-of-9 ">
                        <button type="button" class="btn">Salva</button>
                    </div>
                </div>
    </body>
</html>
