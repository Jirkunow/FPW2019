<%-- 
    Document   : login
    Created on : 2-mag-2019, 14.13.12
    Author     : gznag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href = "resources/CSS/style-index.css">
        <title>Login Page</title>
    </head>
    <body>
        <header>
            <div >
                <img src="resources/IMG/lolomirco.png" alt = "Free peer review logo" class = "logo">  
                <form action ="${pageContext.request.contextPath}/login" method ="post" class = "forms-section">
                    <h1>Login Page</h1>
                    <label>Email</label>
                    <input type ="text" name="email" id="email">
                    <label>Password</label>
                    <input type="password" name = "password"  id="password">
                    <button type="submit" name="login" class="btn" id="login">Login</button>
                    <button type="submit" name="login" class="btn" id="login"><a href="${pageContext.request.contextPath}/Register?reg=yes">Registrati</a></button>
                </form>
            </div>      
        </header>
    </body>
</html>
