<%-- 
    Document   : gestioneArticoli
    Created on : 7-mag-2019, 12.32.58
    Author     : gznag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href = "resources/CSS/style-general.css">
        <link rel="stylesheet" type="text/css" href = "resources/CSS/grid.css">

        <title>Gestione Articoli</title>
    </head>
    <body>
        <!-- Include header here -->
        <jsp:include page="header.jsp"/>
        <jsp:include page="nav.jsp"/>
        <section class="span span-9-of-12">
            <h2>Da valutare</h2>
            <table class="table-section">
                <tbody>
                    <tr>
                            <th>Data</th>
                            <th>Titolo</th>
                            <th>Valutazione</th>
                            <th>Decisione</th>
                        </tr>
                    <c:forEach items="${articoli}" var="articolo" >
                        <tr>
                            <th>${articolo.getData()}</th>
                            <th>${articolo.getTitolo()}</th>
                            <th>${articolo.getValutazione().getVoto()}</th>
                            <th>
                                <c:if test="${articolo.getValutazione().getVoto() <= 2 && articolo.getStato() != 'Da valutare'}" >
                                    Respinto
                                </c:if>

                                <c:if test="${articolo.getValutazione().getVoto() > 2}" >
                                    Accettato
                                </c:if>

                                <c:if test="${articolo.getStato() == 'Da valutare'}" >
                                    Attesa valutazioni
                                </c:if>
                            </th>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </body>
</html>
