package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Carrello;
import model.beans.Ordine;
import model.beans.ProdottoQuantita;
import model.beans.Utente;
import model.dao.OrdineDAO;
import model.dao.ProdottoDAO;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;

@WebServlet(name = "EffettuaOrdine", value = "/EffettuaOrdine")
public class EffettuaOrdineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address;
        String carrello = request.getParameter("conferma");
        HttpSession session = request.getSession();
        Ordine ordine = new Ordine();

        if(carrello != null) {
            address = "WEB-INF/result/confermaOrdine.jsp";

            LocalDateTime dtm = LocalDateTime.now();
            Date date = Date.valueOf(dtm.toLocalDate());
            ordine.setDataPagamento(date);
            ordine.setTotale(Double.parseDouble((String) session.getAttribute("totale")));
            session.setAttribute("ordine", ordine);
            request.setAttribute("ordine", ordine);
        }else{
            OrdineDAO ordineDAO = new OrdineDAO();
            ordine = (Ordine) session.getAttribute("ordine");
            ordine.setTipologia(request.getParameter("tipologia"));
            ordine.setNumeroCarta(request.getParameter("numeroCarta"));
            ordine.setTipoPagamento(request.getParameter("tipoPagamento"));
            ordine.setListaProdotti((ArrayList<ProdottoQuantita>) session.getAttribute("list"));
            Utente utente = (Utente) session.getAttribute("utente");

            if(ordine.getTipologia().equals("A") && ordine.getTotale() < 20)
                ordine.setTotale(ordine.getTotale() + 3);

            if(utente == null){
                // ERRORE L'UTENTE NON HA FATTO IL LOGIN
            }

            ordine.setIdUtente(utente.getId());
            ordineDAO.doSave(ordine);
            session.setAttribute("carrello", null);

            address = "WEB-INF/result/homepage.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request,response);
    }
}
