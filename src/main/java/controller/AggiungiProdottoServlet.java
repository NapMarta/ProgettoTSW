package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Prodotto;
import model.dao.ProdottoDAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "AggiungiProdottoServlet", value = "/AggiungiProdottoServlet")
@MultipartConfig(maxFileSize = 16177215)
public class AggiungiProdottoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeProdotto = request.getParameter("nomeProdotto");
        Double prezzoProdotto = Double.parseDouble(request.getParameter("prezzoProdotto"));
        String descrizione = request.getParameter("descrizione");
        String tipologia = request.getParameter("tipologia");
        Part immagine = request.getPart("immagine");
        InputStream stream = null;

        if(immagine != null){
            stream = immagine.getInputStream();
        }

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
        String address = "WEB-INF/result/AdminView.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
