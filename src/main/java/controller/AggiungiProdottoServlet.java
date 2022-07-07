package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Prodotto;
import model.dao.ProdottoDAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "AggiungiProdotto", value = "/AggiungiProdotto")
@MultipartConfig(maxFileSize = 16177215)
public class AggiungiProdottoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String conferma = request.getParameter("conferma");
        String address  = null;

        if(conferma != null){
            String nomeProdotto = request.getParameter("nomeProdotto");

            Double prezzoProdotto = Double.parseDouble(request.getParameter("prezzoProdotto"));
            String descrizione = request.getParameter("descrizione");
            String tipologia = request.getParameter("tipologia");
            Part immagine = request.getPart("immagine");
            InputStream stream = null;

            /* validazione lato server */

            if(!RequestValidator.assertNome(nomeProdotto)){
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            }

            if(!RequestValidator.assertDouble(String.valueOf(prezzoProdotto))){
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            }

            if(!RequestValidator.assertDescrizione(descrizione)){
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            }

            if(immagine != null){
                stream = immagine.getInputStream();
            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            }

            /* fine validazione */

            Prodotto prodotto = new Prodotto();
            ProdottoDAO prodottoDAO = new ProdottoDAO();
            prodotto.setDescrizione(descrizione);
            prodotto.setImmagine(stream);
            prodotto.setNome(nomeProdotto);
            prodotto.setTipologia(tipologia);
            prodotto.setPrezzo(prezzoProdotto);

            prodotto.setCodice(prodottoDAO.doSave(prodotto));

            List<Prodotto> list = prodottoDAO.doRetrieveAll();
            request.setAttribute("prodottoList", list);
            address = "WEB-INF/result/AdminView.jsp";
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
