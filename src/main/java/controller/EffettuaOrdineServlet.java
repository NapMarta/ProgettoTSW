package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.*;
import model.dao.OrdineDAO;
import model.dao.ProdottoDAO;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EffettuaOrdine", value = "/EffettuaOrdine")
public class EffettuaOrdineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address;
        String conferma = request.getParameter("conferma");
        String continua = request.getParameter("continuaAcquisti");
        HttpSession session = request.getSession(false);
        Ordine ordine = new Ordine();

        if (continua != null) {
            ProdottoDAO prodottoDAO = new ProdottoDAO();
            List<Prodotto> list = prodottoDAO.doRetrieveByTipologia("Pizza");
            request.setAttribute("prodottoList", list);
            address = "WEB-INF/result/homepage.jsp";
        } else {

            if (conferma != null) {
                address = "WEB-INF/result/confermaOrdine.jsp";

                Carrello carrello = (Carrello) session.getAttribute("carrello");

                LocalDateTime dtm = LocalDateTime.now();
                Date date = Date.valueOf(dtm.toLocalDate());
                ordine.setDataPagamento(date);
                ordine.setTotale(carrello.getTotale());
                synchronized (session){
                    session.setAttribute("ordine", ordine);
                }

                request.setAttribute("ordine", ordine);
            } else {
                Carrello carrello = (Carrello) session.getAttribute("carrello");

                OrdineDAO ordineDAO = new OrdineDAO();
                ordine = (Ordine) session.getAttribute("ordine");
                ordine.setTipologia(request.getParameter("tipologia"));
                ordine.setNumeroCarta(request.getParameter("numeroCarta"));
                ordine.setTipoPagamento(request.getParameter("tipoPagamento"));
                ordine.setListaProdotti(carrello.getListaProdotti());
                Utente utente = (Utente) session.getAttribute("utente");

                if(ordine.getTipologia().equals("D") && ordine.getTotale() < 20)
                    ordine.setTotale(ordine.getTotale() + 3);

                if (utente == null) {
                    // ERRORE L'UTENTE NON HA FATTO IL LOGIN
                }

                ordine.setIdUtente(utente.getId());
                ordineDAO.doSave(ordine);

                synchronized (session){
                    session.setAttribute("carrello", null);
                }


                address = "WEB-INF/result/homepage.jsp";
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);

    }
}
