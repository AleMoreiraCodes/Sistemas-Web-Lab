package com.mycompany.exercicio5;

import com.exerciocios.trabalho.model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alexandre
 */
public class DataBaseManeger {
    public static List<Usuario> Busca() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5433/controleEstoque", "postgres", "1234");
            ResultSet resultado = conexao.createStatement().executeQuery("SELECT * FROM usuario")){
            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getInt("id"));
                usuario.setNome(resultado.getString("usuario"));
                usuario.setSenha(resultado.getString("senha"));
                usuarios.add(usuario);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DataBaseManeger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
}
