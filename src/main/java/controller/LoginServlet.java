package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.ConPool;
import model.beans.Utente;
import model.dao.UtenteDAO;

import java.io.IOException;
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
        String address;
        Utente utente = new Utente();

        if(email.equals("admin@gmail.com") && password.equals("admin")){
            address = "/WEB-INF/result/AdminView.jsp";
        }
        else{
            try {
                utente = UtenteDAO.doRetrieveByCredenziali(email, password);
            } catch (SQLException e) {
                //le credenziali sono errate
                request.setAttribute("error", "Email Utente e/o Password errati");
                address = "WEB-INF/result/login.jsp";
            }
            address = "index.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
