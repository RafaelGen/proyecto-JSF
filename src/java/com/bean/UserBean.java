/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.conexion.AccesoDatos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author rafaelm
 */
@ManagedBean(name="persona")
@RequestScoped
public class UserBean {
    private String nombre ;
    private String apellido;
    private String pais;
    private List<String> paises;
    private String mensaje;
    

    public UserBean() {
           
        paises = new ArrayList<>();
        paises.add("México");
        paises.add("Marruecos");
        paises.add("Alemania");
    }
    public UserBean(String nombre, String apellido, String pais){
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
    }
    
    public String crear() throws SQLException{
        UserBean persona = new UserBean(getNombre(), getApellido(), getPais());
        AccesoDatos ac = new AccesoDatos();
        String respuesta = ac.Create(persona);
        
        System.out.println("YA SE CREÓ LA PERSONA: " + persona.getNombre());
        
        return respuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<String> getPaises() {
        return paises;
    }

    public void setPaises(List<String> paises) {
        this.paises = paises;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        System.out.println("Está pasando por el bean" + mensaje);
        this.mensaje = mensaje;
    }
    
}
