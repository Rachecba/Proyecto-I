<%-- 
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : crearGrupos.jsp
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/crearGrupos.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Cookie|Vollkorn" rel="stylesheet"> 
        <script src="js/redirect.js" type="text/javascript"></script>
        <title>Crear Grupos</title>
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
                <th class='th' id="logout" onclick="logout()">Salir</th>
                </thead>
            </table>
        </div>
        <div id='cuerpo'>
            <div id="crear">
                <h3 id="h3Crear">Crear Grupo Nuevo</h3>
                <p>Para crear un grupo nuevo, ingrese la información en el siguiente formulario.</p>
                <form action="ServicioCrearGrupo">
                    <label>Nombre del grupo</label>
                    <input type="text" placeholder="Inserte nombre del grupo" name="nombre" required>
                    <button type="submit">Crear</button>
                </form>
            </div>
            <div id="salir">
                <h3 id="h3Salir"><strong>Salirse de grupo</strong></h3>
                <p>Para salir de un grupo, ingrese el numero de grupo en el que se encuentra actualmente</p>    
                <form action="ServicioSalirGrupo">
                    <label>Número de grupo</label>
                    <input type="text" placeholder="Numero de grupo. Ejemplo: 1">
                    <button type="submit">Salir</button>
                </form>
            </div>
            <div id="tablas">
                <h3 id="h3Tablas">Grupos Existentes</h3>
                <!-- Aqui se ingresan las tablas de los grupos, cada tabla tendra al lado un boton para unirse al grupo -->
            </div>
        </div>
    </body>
</html>
