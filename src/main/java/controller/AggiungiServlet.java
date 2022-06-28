package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Carrello;
import model.beans.Prodotto;
import model.beans.ProdottoQuantita;
import model.dao.ProdottoDAO;

import java.io.IOException;
import java.util.ArrayList;
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
        String aggiungiCarrello = request.getParameter("aggiungi");
        String aggiungiPreferiti = request.getParameter("aggiungi");
        String modificaQuantita = request.getParameter("quantita");
        String cancella = request.getParameter("cancella");
        HttpSession session = request.getSession(true);
        String address = null;

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
            }else{
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
            address = "WEB-INF/result/carrello.jsp";
        }else {
            if(cancella != null){
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
            }

            else{
                if (aggiungiCarrello != null) {

                    int codice = Integer.parseInt(request.getParameter("codice"));
                    boolean val = false;
                    ProdottoDAO prodottoDAO = new ProdottoDAO();


                    if (carrello.getListaProdotti() != null) {

                        for (ProdottoQuantita prodottoQuantita : carrello.getListaProdotti()) {
                            if (prodottoQuantita.getCodice() == codice) {
                                prodottoQuantita.setQuantita(prodottoQuantita.getQuantita() + 1);
                                carrello.setNumeroProdotti(carrello.getNumeroProdotti()+1);
                                carrello.setTotale(carrello.getTotale()+prodottoQuantita.getPrezzo());
                                val = true;
                            }
                        }
                    }

                    if (!val) {
                        Prodotto prodotto = prodottoDAO.doRetrieveById(codice);
                        ProdottoQuantita prodottoQuantita = new ProdottoQuantita(prodotto.getCodice(), prodotto.getNome(), prodotto.getTipologia(), prodotto.getDescrizione(),
                                prodotto.getPrezzo(), prodotto.getImmagine(), 1);

                        carrello.getListaProdotti().add(prodottoQuantita);
                        carrello.setNumeroProdotti(carrello.getNumeroProdotti()+1);
                        carrello.setTotale(carrello.getTotale()+prodottoQuantita.getPrezzo());
                    }

                    session.setAttribute("carrello", carrello);

                    List<Prodotto> listTipologia = prodottoDAO.doRetrieveByTipologia("Pizza");
                    request.setAttribute("prodottoList", listTipologia);
                    address = "WEB-INF/result/homepage.jsp";
                } else {
                    address = "WEB-INF/result/login.jsp";
                }
        }

    }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request,response);
    }
}
