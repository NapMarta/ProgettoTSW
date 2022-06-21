package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.ConPool;
import model.beans.Utente;
import model.dao.ProdottoDAO;
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

        String accedi = request.getParameter("accedi");
        String registrazione = request.getParameter("registrati");
        String address = null;


        if(registrazione != null){
            address = "WEB-INF/result/registrazioneUtente.jsp";
        }
        else{
            Utente utente = new Utente();
            UtenteDAO utenteDAO = new UtenteDAO();

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            try {
                utente = utenteDAO.doRetrieveByCredenziali(email, password);
            } catch (SQLException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            if(utente.isAdmin()){
                address = "WEB-INF/result/AdminView.jsp";
                ProdottoDAO prodottoDAO = new ProdottoDAO();

            }
            else {
                request.setAttribute("utente", utente);
                address = "WEB-INF/result/homepage.jsp";
            }


        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);

    }
}
