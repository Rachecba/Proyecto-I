<%-- 
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : contraseña.jsp
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="login" uri="/WEB-INF/tlds/login" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/password.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Cookie|Vollkorn|Satisfy" rel="stylesheet"> 
        <script src="js/redirect.js" type="text/javascript"></script>
        <title>Cambiar Contraseña</title>
    </head>
    <body onload="init();">
         <jsp:include page="/ServicioSesion" />
        ${login:logged()}
        <div id='encabezado'>
            <table id='barra'>
                <thead>
                <th id='gestor'>Gestor de Grupos</th>
                <th class='th' id="pass" onclick="redirectPass()">Cambiar Contraseña</th>
                <th class='th' id="verGrupos" onclick="redirectVerGrupos()">Ver Grupos</th>
                <th class='th' id="crearGrupo" onclick="redirectCrearGrupos()">Crear/Unirse a Grupo</th>
                <th class='th' id="usuarios" onclick="redirectUsuarios()">Ver usuarios</th>
                <th class='th' id="logout" onclick="logout()">Salir</th>
                </thead>
            </table>
        </div>
        <div id="h1">
            <h2> Cambiar Contraseña </h2>
        </div>
        <form action="ServicioPassword" method="post" name="loginForm">
            <div class="container">
                <label for="username"><br>Usuario</label><br>
                <input type="text" placeholder="Ingrese usuario" name="username" id="input" required>
                <label for="password"><br>Contraseña nueva</label><br>
                <input type="password" placeholder="Ingrese nueva contraseña" name="password" required><br>
                <button type="submit">Cambiar</button><br>
            </div>
        </form>
    </body>
</html>
