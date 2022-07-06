package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Utente;
import model.dao.UtenteDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CheckRegistrazioneServlet", value = "/CheckRegistrazioneServlet")
public class CheckRegistrazioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("emailValue");

        //System.out.println(email);
        boolean isRegistered = false;

        try{
            UtenteDAO utenteDAO = new UtenteDAO();
            Utente utente = utenteDAO.doRetrieveByEmail(email);
            if(utente != null){
                if(utente.getEmail() != null)
                    isRegistered = true;
            }else
                isRegistered = false;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String json = "{\"registered\" : " + isRegistered + "}";

        response.getWriter().write(json);
        //System.out.println(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
