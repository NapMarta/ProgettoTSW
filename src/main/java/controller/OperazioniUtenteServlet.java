package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Carrello;
import model.beans.ListaDeiDesideri;
import model.beans.Ordine;
import model.beans.Utente;
import model.dao.CarrelloDAO;
import model.dao.ListaDeiDesideriDAO;
import model.dao.OrdineDAO;
import model.dao.ProdottoDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OperazioniUtente", value = "/OperazioniUtente")
public class OperazioniUtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String elements = request.getParameter("elements");
        String address = null;
        HttpSession session = request.getSession();

        if(elements.equalsIgnoreCase("Ordini Effettuati")){
            address = "WEB-INF/result/visualizzazioneOrdini.jsp";
            Utente utente = (Utente) session.getAttribute("utente");
            OrdineDAO ordineDAO = new OrdineDAO();
            List<Ordine> list = ordineDAO.doRetrieveByIdUtente(utente.getId());
            request.setAttribute("listOrdini", list);
        }

        if(elements.equalsIgnoreCase("Modifica Credenziali")){
            request.setAttribute("ris", true);
            address = "WEB-INF/result/modificaCredenziali.jsp";
        }

        if(elements.equalsIgnoreCase("Lista dei desideri")){
            address = "WEB-INF/result/listaDesideriView.jsp";
        }

        if(elements.equalsIgnoreCase("Logout")){
            Carrello carrello = (Carrello) session.getAttribute("carrello");
            ListaDeiDesideri listaDeiDesideri = (ListaDeiDesideri) session.getAttribute("listaDeiDesideri");

            CarrelloDAO carrelloDAO = new CarrelloDAO();

            carrelloDAO.doUpdate(carrello);
            ListaDeiDesideriDAO listaDeiDesideriDAO = new ListaDeiDesideriDAO();
            listaDeiDesideriDAO.doUpdate(listaDeiDesideri);

            synchronized (session){
                session.invalidate();
            }

            address = "index.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
