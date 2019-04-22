<%-- 
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : usuarios.jsp
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="login" uri="/WEB-INF/tlds/login" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/usuarios.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Cookie|Vollkorn" rel="stylesheet"> 
        <script src="js/usuarios.js" type="text/javascript"></script>
        <script src="js/redirect.js" type="text/javascript"></script>
        <title>Usuarios</title>
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
        <div id="cuerpo">
            <h3> Usuarios </h3>
            <div id="tablaUsuarios">
                <table>
                    <thead>
                        <tr>
                            <th>Usuario</th>
                            <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody id="listaUsuarios">
                        
                    </tbody>
                </table>
            </div>
            <!--A los usuarios que estan activos les pongo un puntito verde al lado, o una etiqueta verde diciendo que esta activo -->
            <!-- NOTA: Incluya una opción para ver la lista de usuarios junto con la información del grupo de trabajo, 
                       ordenada por: grupo de trabajo (1), grupo matriculado (2), número de identificación (3) o apellidos y nombre (4)-->
        </div>
    </body>
</html>
