/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exerciocios.trabalho.model;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
/**
 *
 * @author Alexandre
 */

// Esse Factory retorna uma nova conexão a cada chamada
public class ConFactory {
    public static final int MYSQL = 0; 
    public static final int JavaDB = 1;  
  
   public static Connection conexao(String nome, String senha,  
         int banco) throws ClassNotFoundException, SQLException {  
      switch (banco) {        
      case MYSQL:           
         Class.forName("org.postgresql.Driver"); 
         return DriverManager.getConnection("jdbc:postgresql://localhost:5433/controleEstoque", nome, senha);
      case JavaDB:
          Class.forName("org.apache.derby.jdbc.ClientDriver"); 
          return DriverManager.getConnection("jdbc:derby://localhost:1527/lpsw", nome, senha);
      }  
      return null;
   }  
}