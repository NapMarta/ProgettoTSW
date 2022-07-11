package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.*;
import model.dao.ProdottoDAO;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "Aggiungi", value = "/Aggiungi")
public class AggiungiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aggiungiCarrello = request.getParameter("aggiungiCarrello");
        String aggiungiPreferiti = request.getParameter("aggiungiDesideri");
        String modificaQuantita = request.getParameter("quantita");
        String cancella = request.getParameter("cancella");
        HttpSession session = request.getSession(true);
        String address = null;
        ProdottoDAO prodottoDAO = new ProdottoDAO();

        Carrello carrello = (Carrello) session.getAttribute("carrello");

        if(modificaQuantita != null){      //modificaQuantita la utilizziamo solo se abbiamo elementi nel carrello
            int cod = Integer.parseInt(request.getParameter("cod"));
            if(modificaQuantita.equalsIgnoreCase("piu")){
                for (ProdottoQuantita p : carrello.getListaProdotti()) {
                    if(p.getCodice() == cod){
                        p.setQuantita(p.getQuantita()+1);
                        carrello.setNumeroProdotti(carrello.getNumeroProdotti()+1);
                        carrello.setTotale(carrello.getTotale()+p.getPrezzo());
                    }
                }
            }else{      //meno
                Iterator<ProdottoQuantita> iterator = carrello.getListaProdotti().iterator();
                while(iterator.hasNext()) {
                    ProdottoQuantita p = iterator.next();
                    if(p.getCodice() == cod){
                        p.setQuantita(p.getQuantita()-1);
                        carrello.setNumeroProdotti(carrello.getNumeroProdotti()-1);
                        carrello.setTotale(carrello.getTotale()-p.getPrezzo());
                        if(p.getQuantita() == 0){
                            iterator.remove();
                        }
                    }
                }
            }

            synchronized (session){
                session.setAttribute("carrello", carrello);
            }

            address = "WEB-INF/result/carrello.jsp";
        }

        if(cancella != null){           //cancella il prodotto solo se abbiamo il prodotto nel carrello
            int cod = Integer.parseInt(request.getParameter("cod"));
            Iterator<ProdottoQuantita> iterator = carrello.getListaProdotti().iterator();
            while(iterator.hasNext()) {
                ProdottoQuantita p = iterator.next();
                if(p.getCodice() == cod){
                    iterator.remove();
                    carrello.setNumeroProdotti(carrello.getNumeroProdotti()-p.getQuantita());
                    carrello.setTotale(carrello.getTotale()-(p.getPrezzo()*p.getQuantita()));
                }
            }
            address = "WEB-INF/result/carrello.jsp";

            synchronized (session){
                session.setAttribute("carrello", carrello);
            }
        }

        if (aggiungiCarrello != null) {         //aggiungi al carrello dalla homapage
            int codice = Integer.parseInt(request.getParameter("codice"));
            boolean val = false;

            ProdottoQuantita prodottoQtà = null;

            if (carrello.getListaProdotti() != null) {  //cerchiamo il prodotto per vedere se è già stato inserito
                for (ProdottoQuantita prodottoQuantita : carrello.getListaProdotti()) {
                    if (prodottoQuantita.getCodice() == codice) {
                        prodottoQuantita.setQuantita(prodottoQuantita.getQuantita() + 1);       //e modifichiamo la quantità
                        prodottoQtà = prodottoQuantita;
                        carrello.setNumeroProdotti(carrello.getNumeroProdotti()+1);
                        carrello.setTotale(carrello.getTotale()+prodottoQuantita.getPrezzo());
                        val = true;
                    }
                }
            }

            if (!val) {     //se il prodotto non era nel carrello
                Prodotto prodotto = prodottoDAO.doRetrieveById(codice);
                prodottoQtà = new ProdottoQuantita(prodotto.getCodice(), prodotto.getNome(), prodotto.getTipologia(), prodotto.getDescrizione(),
                        prodotto.getPrezzo(), prodotto.getImmagine(), 1);

                carrello.getListaProdotti().add(prodottoQtà);
                carrello.setNumeroProdotti(carrello.getNumeroProdotti()+1);
                carrello.setTotale(carrello.getTotale()+prodottoQtà.getPrezzo());
            }

            synchronized (session){
                session.setAttribute("carrello", carrello);
            }

            List<Prodotto> listTipologia = prodottoDAO.doRetrieveByTipologia(prodottoQtà.getTipologia());
            request.setAttribute("prodottoList", listTipologia);

            address = "WEB-INF/result/homepage.jsp";
        }

        if(aggiungiPreferiti != null){               //aggiungi alla lista dei desideri
            Utente utente = (Utente) session.getAttribute("utente");

            if(utente != null){
                int codice = Integer.parseInt(request.getParameter("codice"));
                Prodotto prodotto = prodottoDAO.doRetrieveById(codice);

                ListaDeiDesideri listaDeiDesideri = (ListaDeiDesideri) session.getAttribute("listaDeiDesideri");

                boolean exists = false;

                for (Prodotto prodotto1 : listaDeiDesideri.getListaProdotti()){
                    if(prodotto1.getCodice() == prodotto.getCodice())
                        exists = true;          //non reinserisce il prodotto se è già tra i preferiti
                }

                if(!exists){
                    listaDeiDesideri.getListaProdotti().add(prodotto);
                }

                synchronized (session){
                    session.setAttribute("listaDeiDesideri", listaDeiDesideri);
                }
                address="WEB-INF/result/homepage.jsp";

                List<Prodotto> list = prodottoDAO.doRetrieveByTipologia(prodotto.getTipologia());
                request.setAttribute("prodottoList", list);
            }else
                address="WEB-INF/result/login.jsp";

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request,response);
    }
}
