package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.*;
import model.dao.CarrelloDAO;
import model.dao.ListaDeiDesideriDAO;
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
        String address = null;
        String conferma = request.getParameter("conferma");
        String continua = request.getParameter("continuaAcquisti");
        String concludiOrdine = request.getParameter("concludiOrdine");
        HttpSession session = request.getSession();
        Ordine ordine = new Ordine();
        boolean validazione = true;

        if (continua != null) {
            ProdottoDAO prodottoDAO = new ProdottoDAO();
            List<Prodotto> list = prodottoDAO.doRetrieveByTipologia("Pizza");
            request.setAttribute("prodottoList", list);
            address = "WEB-INF/result/homepage.jsp";
        }

        if (conferma != null) {         //dal carrello
            Utente utente = (Utente) session.getAttribute("utente");
            if (utente == null) {
                address = "WEB-INF/result/login.jsp";
            }else{
                address = "WEB-INF/result/confermaOrdine.jsp";
                Carrello carrello = (Carrello) session.getAttribute("carrello");
                LocalDateTime dtm = LocalDateTime.now();
                Date date = Date.valueOf(dtm.toLocalDate());
                ordine.setDataPagamento(date);
                ordine.setTotale(carrello.getTotale());

                /* validazione lato server */
                if(!RequestValidator.assertDouble(String.valueOf(ordine.getTotale()))){
                    validazione = false;
                }
                /* fine validazione */

                if(validazione){
                    int id = utente.getId();
                    ordine.setIdUtente(id);
                    synchronized (session){
                        session.setAttribute("ordine", ordine);
                    }
                    request.setAttribute("ordine", ordine);
                }

            }
        }

        if(concludiOrdine != null) {
            Utente utente = (Utente) session.getAttribute("utente");
            Carrello carrello = (Carrello) session.getAttribute("carrello");

            OrdineDAO ordineDAO = new OrdineDAO();
            ordine = (Ordine) session.getAttribute("ordine");
            ordine.setTipologia(request.getParameter("tipologia"));
            ordine.setNumeroCarta(request.getParameter("numeroCarta"));
            ordine.setTipoPagamento(request.getParameter("tipoPagamento"));
            ordine.setListaProdotti(carrello.getListaProdotti());
            ordine.setVia(request.getParameter("via"));
            ordine.setCap(request.getParameter("cap"));
            ordine.setCitta(request.getParameter("citta"));


            if(ordine.getTipologia().equals("A") || ordine.getTipologia().equals("CP")){
                ordine.setVia(new String());
                ordine.setCap(new String());
                ordine.setCitta(new String());
            }
            else{
                //D = domicilio
                /* validazione lato server */
                if(!RequestValidator.assertIndirizzo(ordine.getVia())){
                    validazione = false;
                }
                if(!RequestValidator.assertCAP(ordine.getCap())){
                    validazione = false;
                }
                if(!RequestValidator.assertCitta(ordine.getCitta())){
                    validazione = false;
                }
                /* fine validazione */
            }

            if(ordine.getTipoPagamento().equalsIgnoreCase("contanti") ||
                    ordine.getTipoPagamento().equalsIgnoreCase("paypal")){
                ordine.setNumeroCarta(new String());
            }else{
                //Carta di credito
                /* validazione lato server */
                if(!RequestValidator.assertNumeroCarta(ordine.getNumeroCarta())){
                    validazione = false;
                }
                /* fine validazione */
            }

            if(validazione){
                if(ordine.getTipologia().equals("D") && ordine.getTotale() < 20)
                    ordine.setTotale(ordine.getTotale() + 3);

                ordineDAO.doSave(ordine);

                carrello.setTotale(0);
                carrello.setNumeroProdotti(0);
                carrello.setListaProdotti(new ArrayList<>());
                CarrelloDAO carrelloDAO = new CarrelloDAO();

                synchronized (session){
                    carrelloDAO.doUpdate(carrello);
                    session.setAttribute("carrello", carrello);
                }

                ProdottoDAO prodottoDAO = new ProdottoDAO();
                List<Prodotto> list = prodottoDAO.doRetrieveByTipologia("Pizza");
                request.setAttribute("prodottoList", list);
                address = "WEB-INF/result/homepage.jsp";
            }
        }

        if(!validazione){
            address = "error.jsp";
            Carrello carrello = (Carrello) session.getAttribute("carrello");
            ListaDeiDesideri listaDeiDesideri = (ListaDeiDesideri) session.getAttribute("listaDeiDesideri");

            CarrelloDAO carrelloDAO = new CarrelloDAO();
            carrelloDAO.doUpdate(carrello);
            ListaDeiDesideriDAO listaDeiDesideriDAO = new ListaDeiDesideriDAO();
            listaDeiDesideriDAO.doUpdate(listaDeiDesideri);

            synchronized (session){
                session.invalidate();
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);

    }
}
