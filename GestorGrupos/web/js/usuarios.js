/*
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : usuarios.js
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
*/

function init(){
    solicitarDatos("ServicioUsuarios","listaUsuarios");
}

function solicitarDatos(file, tabla){
    fetch(file).then(
            (resultados) => {
                return resultados.json();}
            ).then(
            (datosJSON) => {
                cargarTabla(tabla, datosJSON);
            }
            );
}

function cargarTabla(tabla, datosJSON){
    
    var refTabla = document.getElementById(tabla);
    
    if(refTabla){
        
        for(var i = 0; i < datosJSON.usuarios.length; i++){
            var nuevaFila = refTabla.insertRow(-1);
            var nuevaCelda;
            
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datosJSON.usuarios[i].id;
            
//            nuevaCelda = nuevaFila.insertCell(-1);
//            nuevaCelda.innerText = datosJSON.usuarios[i].nombre;
            
            nuevaCelda = nuevaFila.insertCell(-1);
            nuevaCelda.innerText = datosJSON.usuarios[i].ultimo_acceso;
            
//            if(datosJSON.usuarios[i].ultimo_acceso )
        }
    }
}