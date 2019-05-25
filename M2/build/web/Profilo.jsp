<%-- 
    Document   : Profilo
    Created on : 25-mag-2019, 12.37.05
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
        <c:if test="${param.registra == 'true'}" >
            <title>FPW: Registrazione</title>
        </c:if>
        <c:if test="${param.registra == 'false'}" >
            <title>FPW: Profilo</title>
        </c:if>
    </head>
    <body>
        <!-- Include header here -->
        <jsp:include page="header.jsp"/>
        <jsp:include page="nav.jsp"/>
        
        <c:if test="${param.registra == 'true'}" >
            <div>
                <div class="span span-3-of-12">
                    <h2>Registrazione</h2>
                </div>
                <div class="span span-4-of-12">
                    <div class="img-contenitor-profile">
                        <img src="resources/IMG/icona%20foto%20profilo.png" >
                    </div>
                </div>
                <div class="span span-8-of-12 Style_1">
                    <p>Nome</p>
                    <input type="text" name="Nome" id = "Nome" placeholder="" required>
                    <p>Cognome</p>
                    <input type="text" name="Cognome" id = "Cognome" placeholder="" required>
                    <p>Foto</p>
                    <input type="text" name="Foto" id = "Foto" placeholder="." required>
                    <p>Email</p>
                    <input type="text" name="Email" id = "Email" placeholder="" required>
                    <p>Password</p>
                    <input type="text" name="Password" id = "Password" placeholder="" required>
                    <p>Ente</p>
                    <input type="text" name="Ente" id = "Ente" placeholder="" required>
                    <button type="button" class="btn"><a href="${pageContext.request.contextPath}/Register?reg=no">Salva</a></button>
                </div>   
            </div>
        </c:if>
        <c:if test="${param.registra == 'false'}" >
            <div>
                <div class="span span-3-of-12">
                    <h2>Profilo</h2>
                </div>
                <div class="span span-4-of-12">
                    <div class="img-contenitor-profile">
                        <img src="resources/IMG/icona%20foto%20profilo.png" >
                    </div>
                </div>
                <div class="span span-8-of-12 Style_1">
                    <p>Nome</p>
                    <input type="text" name="Nome" id = "Nome" placeholder="${user.getNome()}" required>
                    <p>Cognome</p>
                    <input type="text" name="Cognome" id = "Cognome" placeholder="${user.getCognome()}" required>
                    <p>Foto</p>
                    <input type="text" name="Foto" id = "Foto" placeholder="${user.getFoto()}" required>
                    <p>Email</p>
                    <input type="text" name="Email" id = "Email" placeholder="${user.getEmail()}" required>
                    <p>Password</p>
                    <input type="text" name="Password" id = "Password" placeholder="${user.getPassword()}" required>
                    <p>Ente</p>
                    <input type="text" name="Ente" id = "Ente" placeholder="${user.getEnte()}" required>
                    <button type="button" class="btn"><a href="${pageContext.request.contextPath}/Register?reg=no">Salva</a></button>
                </div>   
            </div>
        </c:if>
        
        
    </body>
</html>
