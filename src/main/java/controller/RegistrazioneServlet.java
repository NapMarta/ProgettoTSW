package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Utente;
import model.dao.UtenteDAO;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "RegistrazioneServlet", value = "/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String login = request.getParameter("login");
        String address;

        if(login != null){
            address = "/WEB-INF/result/login.jsp";
        }
        else {
            Utente utente = new Utente();
            UtenteDAO service = new UtenteDAO();
            try {
                utente.setPasswordUtente(request.getParameter("psw"));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            utente.setEmail(request.getParameter("email"));
            utente.setNome(request.getParameter("nome"));
            utente.setCognome(request.getParameter("cognome"));

            request.setAttribute("utente", utente);

            utente.setId(service.doSave(utente));

            address = "/WEB-INF/result/homepage.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
