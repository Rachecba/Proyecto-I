<%-- 
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : consultaGrupos.jsp
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/consultaGrupos.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Cookie|Vollkorn" rel="stylesheet"> 
        <script src="js/redirect.js" type="text/javascript"></script>
        <title>Ver Grupos</title>
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
        <div id='grupos'>
             <jsp:useBean class="modelo.dao.GestorGrupos" id="g1"></jsp:useBean>
              ${g1.tablasGrupos} 
        </div>
    </body>
</html>
