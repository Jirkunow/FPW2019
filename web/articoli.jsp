<%-- 
    Document   : articoli
    Created on : 7-mag-2019, 12.31.30
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
        <title>Free pair review: Articoli</title>
    </head>
    <body>
        <!-- Include header here -->
        <jsp:include page="header.jsp"/>
        <jsp:include page="nav.jsp"/>
            <section>
                <div class="span span-9-of-12">
                    <h2>I miei articoli</h2>
                    <table class="table-section">
                        <tbody>
                            <tr>
                                    <th>Data</th>
                                    <th>Titolo</th>
                                    <th>Stato</th>
                                    <th>Azione</th>
                                </tr>
                            <c:forEach items="${articoli}" var="articolo" >
                                <tr>
                                    <th>${articolo.getData()}</th>
                                    <th>${articolo.getTitolo()}</th>
                                    <th>${articolo.getStato()}</th>
                                    <th>
                                        <c:if test="${articolo.getStato() == 'Aperto'}" >
                                            <button class="btn"><a href="${pageContext.request.contextPath}/WritePaper?idArt=${articolo.getIdArt()}&salva=false">Modifica</a></button>
                                        </c:if>

                                        <c:if test="${articolo.getStato() == 'Da valutare'}" >
                                            <button class = "btn">Cancella</button>
                                        </c:if>
                                    </th>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="btn">
                        <a href="scriviArticolo.html">Nuovo articolo</a>
                    </div>

                </div>
            </section>
        
    </body>
</html>
