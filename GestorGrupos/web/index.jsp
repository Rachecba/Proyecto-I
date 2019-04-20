<%-- 
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : index.jsp
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Satisfy|Vollkorn|Cookie" rel="stylesheet"> 
        <script src="js/redirect.js" type="text/javascript"></script>
        <title>Login</title>
    </head>
    <body>
        <div id='encabezado'>
            <table id='barra'>
                <thead>
                <th id='gestor'>Gestor de Grupos</th>
                <th class='th' id="pass" onclick="redirectPass()">Cambiar Contraseña</th>
                <th class='th' id="verGrupos" onclick="redirectVerGrupos()">Ver Grupos</th>
                <th class='th' id="crearGrupo" onclick="redirectCrearGrupos()">Crear/Unirse a Grupo</th>
                <th class='th' id="usuarios" onclick="redirectUsuarios()">Ver usuarios</th>
                </thead>
            </table>
        </div>
        <div id="h1">
            <h2> Registrarse </h2>
            <!-- <div id='imgcontainer'>
             <img src="../src/java/images/user.jpg" alt=""/> 
            </div>-->
        </div>
        <form action="ServicioLogin" method="post" name="loginForm">
            <div class="container">
                <label for="username"><br>Usuario</label><br>
                <input type="text" placeholder="Ingrese usuario" name="username" required>
                <label for="password"><br>Contraseña</label><br>
                <input type="password" placeholder="Ingrese contraseña" name="password" required><br>
                <button type="submit">Entrar</button><br>
            </div>
        </form>
        <p id='aviso'>Si es primera vez que ingresa, use su numero de cédula como contraseña</p>
    </body>
</html>
