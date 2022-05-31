package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aggiungi = request.getParameter("aggiungi");
        String modifica = request.getParameter("modifica");
        String rimuovi = request.getParameter("rimuovi");
        String visualizza = request.getParameter("visualizza");

        if(aggiungi != null){

        }
        else{
            if(modifica != null){

            }
            else{
                if(visualizza != null){

                }
                else{
                    //rimuovi
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
