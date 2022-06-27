package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Prodotto;
import model.beans.ProdottoQuantita;
import model.dao.ProdottoDAO;

import java.io.IOException;
import java.util.ArrayList;
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
        HttpSession session = request.getSession(false);
        String address;

        if (aggiungiCarrello != null){
            ArrayList<ProdottoQuantita> list;
            int codice = Integer.parseInt(request.getParameter("codice"));
            boolean val = false;
            ProdottoDAO prodottoDAO = new ProdottoDAO();

            if(session != null){
                list = (ArrayList<ProdottoQuantita>) session.getAttribute("list");
                for (ProdottoQuantita prodottoQuantita: list) {
                    if(prodottoQuantita.getCodice() == codice) {
                        prodottoQuantita.setQuantita(prodottoQuantita.getQuantita() + 1);
                        val = true;
                    }
                }
            }
            else{
                session = request.getSession(true); //crea la sesssione
                list = new ArrayList<>();
            }

            if(!val){
                Prodotto prodotto = prodottoDAO.doRetrieveById(codice);
                ProdottoQuantita prodottoQuantita = new ProdottoQuantita(codice, prodotto.getNome(), prodotto.getTipologia(), prodotto.getDescrizione(),
                        prodotto.getPrezzo(), prodotto.getImmagine(), 1);

                list.add(prodottoQuantita);
            }

            session.setAttribute("list", list);

            List<Prodotto> listTipologia = prodottoDAO.doRetrieveByTipologia("Pizza");
            request.setAttribute("prodottoList", listTipologia);
            address = "WEB-INF/result/homepage.jsp";
        }
        else {
            address = "WEB-INF/result/login.jsp";
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request,response);
    }
}
