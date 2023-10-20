/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercicios.trabalho.code;

import com.exerciocios.trabalho.model.DaoUsuario;
import com.exerciocios.trabalho.model.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Alexandre
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public boolean login(String _user, String _pass) {
        DaoUsuario da = new DaoUsuario(0, "postgres", "1234");
        Usuario temp = da.buscar(_user);
        if (temp == null || !(_pass.equals(temp.getSenha()))) {
            return false;
        }
        return true;
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = null;
        String loggedIn = null;
        RequestDispatcher rd = null;
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String operacao = request.getParameter("operacao");
        // Verifica se está tentando logar
        session = request.getSession(true);
        if (operacao != null) {
            if (operacao.equals("login")) {
                // Valida login e vai para menu
                if (login(userName, password)) {
                    session.setAttribute("loggedIn", "TRUE");
                    session.setAttribute("usuario", userName);
                    rd = request.getRequestDispatcher("menu.jsp");
                    rd.forward(request, response);
                } else {
                    session.setAttribute("loggedIn", "FALSE");
                    session.setAttribute("msg", "Usuário ou Senha inválido");
                    rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
            } // senao, verifica se já está logado
            else {
                // Gerenciamento de sessao
                loggedIn = (String) session.getAttribute("loggedIn");
                if (loggedIn == null || !loggedIn.equals("TRUE")) {
                    session.setAttribute("msg", "Sua sessão expirou!");
                    rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                } // Executa a operação desejada
                else {
                    switch (operacao) {
                        case "welcome":
                            rd = request.getRequestDispatcher("welcome.jsp");
                            rd.forward(request, response);
                            break;
                        case "erroJava":
                            throw new ServletException();
                        case "menu":
                            rd = request.getRequestDispatcher("menu.jsp");
                            rd.forward(request, response);
                            break;
                        case "erroHtml":
                            rd = request.getRequestDispatcher("erro.jsp");
                            rd.forward(request, response);
                            break;
                        case "sair":
                            session.setAttribute("loggedIn", "FALSE");
                            rd = request.getRequestDispatcher("index.jsp");
                            rd.forward(request, response);
                            break;
                        default:
                            // se opcao inválida faz logoff e vai para tela de erro
                            session.setAttribute("loggedIn", "FALSE");
                            rd = request.getRequestDispatcher("erro.jsp");
                            rd.forward(request, response);
                    }
                }
            }
        } else {
            session.setAttribute("loggedIn", "FALSE");
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}