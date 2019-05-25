<%-- 
    Document   : nav
    Created on : 9-mag-2019, 17.45.58
    Author     : gznag
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class = "span span-3-of-12">
                    <nav class = "vert-nav">
                        <h4>Ciao ${user.getNome()}<br></h4>
                        <button class="btn"><a>Logout</a></button>
                        <c:if test="${user.getAutore() != '0'}" >
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/articoli">I miei articoli</a></li>
                                <li><a href="valutazione.html" >Articoli da valutare</a></li>
                            </ul>
                        </c:if>
                        
                    </nav>
                </div>
    </body>
</html>
