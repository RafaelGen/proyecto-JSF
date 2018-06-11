/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexion;

import com.bean.UserBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafaelm
 */
public class AccesoDatos {
    private Connection conexion;
    
    private void conexion() throws SQLException{
        if (conexion == null || conexion.isClosed()){
            try{
                   String cadenaConexion = "jdbc:mysql://localhost:3306/PersonasDB";
                   //Class.forName("com.mysql.jdbc.Driver");

                   conexion = DriverManager.getConnection(cadenaConexion, 
                           "root","mysqlroot");
               }catch(SQLException ex){
                   ex.printStackTrace();
               }
       }
    }
    
    private void close() throws SQLException{
        if (!conexion.isClosed() || conexion != null)
            conexion.close();
    }

    public String Create(UserBean entidad) throws SQLException{
        
        conexion();
            
            String insertPersona = "INSERT INTO persona (nombre, apellido, pais) VALUES (?, ?, ?)";
            
            PreparedStatement stm = conexion.prepareStatement(insertPersona);
            stm.setString(1, entidad.getNombre());
            stm.setString(2, entidad.getApellido());
            stm.setString(3, entidad.getPais());
            boolean ejecutado = stm.executeUpdate()>0;
            stm.close();
        close();
        if(ejecutado)
            return "respuesta.xhtml?faces-forward=true";
        return "index.xhtml?faces-forward=true";
        
    }
 
}
