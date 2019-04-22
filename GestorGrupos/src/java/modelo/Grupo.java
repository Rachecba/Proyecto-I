/*  
    Programación 4 - Proyecto #1
    26 Abril 2019

    Document   : grupo.java
    Author     : Rachel Basulto 801030879
                 Danny Gómez    116440310
 */

package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Grupo implements Serializable{
    int id;
    String nombre;
    int cupo;
    List<Usuario> estudiantes;
    boolean activo;

    public Grupo(int id, String nombre, int cupo, List<Usuario> estudiantes, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.cupo = cupo;
        this.estudiantes = estudiantes;
        this.activo = activo;
    }

    public Grupo() {
        id = 0;
        nombre = null;
        cupo = 0;
        estudiantes = new ArrayList<>();
        activo = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public List<Usuario> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Usuario> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public void agregarEstudiante(Usuario u){
        estudiantes.add(u);
    }
}
