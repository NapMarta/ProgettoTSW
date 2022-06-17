package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scelta = request.getParameter("scelta");
        String address = null;

        if(scelta.equalsIgnoreCase("Aggiungi prodotto")){
            address = "WEB-INF/result/inserimentoProdotto.jsp";
        }
        else{
            if(scelta.equalsIgnoreCase("Rimuovi prodotto")){

            }
            else{
                if(scelta.equalsIgnoreCase("Modifica prodotto")){

                }
                else{
                    //visualizza ordini

                }
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
