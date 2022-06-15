package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.ConPool;
import model.beans.Utente;
import model.dao.UtenteDAO;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String accedi = request.getParameter("accedi");
        String registrati =  request.getParameter("registrati");

        String address = null;
        Utente utente = new Utente();
        UtenteDAO service = new UtenteDAO();

        if(registrati != null){
            address = "WEB-INF/result/registrazioneUtente.jsp";
        }else{
            //utente vuole accedere al sito
            try {
                utente = service.doRetrieveByCredenziali(email, password);
            } catch (SQLException | NoSuchAlgorithmException e) {
                //le credenziali sono errate
                request.setAttribute("error", "Email Utente e/o Password errati");
                address = "WEB-INF/result/login.jsp";
            }

            request.setAttribute("utente", utente);
            address = "/WEB-INF/result/homepage.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
