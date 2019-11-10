/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Javierino
 */
public class Persona {
    String nombre,direccionl,estado,estudio,dni;
    int telefono,experiencia;

    public Persona() {
    }
    
    public Persona(String nombre, String direccionl, String estado, String estudio, int telefono, String dni, int experiencia) {
        this.nombre = nombre;
        this.direccionl = direccionl;
        this.estado = estado;
        this.estudio = estudio;
        this.telefono = telefono;
        this.dni = dni;
        this.experiencia = experiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccionl() {
        return direccionl;
    }

    public void setDireccionl(String direccionl) {
        this.direccionl = direccionl;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return nombre + " - " + direccionl + " - " + estado;
    }

    
    
}
