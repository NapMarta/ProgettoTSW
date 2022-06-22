package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Prodotto;
import model.dao.ProdottoDAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

@WebServlet(name = "ModificaProdottoServlet", value = "/ModificaProdottoServlet")
@MultipartConfig(maxFileSize = 16177215)

public class ModificaProdottoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Prodotto prodotto = new Prodotto();
        ProdottoDAO prodottoDAO = new ProdottoDAO();
        String address = null;

        HttpSession session = request.getSession();

        int codice = Integer.parseInt(request.getParameter("id"));
        String nomeProdotto = request.getParameter("nomeProdotto");
        Double prezzoProdotto = Double.parseDouble(request.getParameter("prezzoProdotto"));
        String descrizione = request.getParameter("descrizione");
        String tipologia = request.getParameter("tipologia");
        Part immagine = request.getPart("immagine");

        InputStream stream = null;
        boolean foto = true;        //l'admin vuole cambiare la foto del prodotto

        if(immagine != null) {
            stream = immagine.getInputStream();
            prodotto.setImmagine(stream);
        }
        else {
            foto = false;
            prodotto.setImmagine((InputStream) prodottoDAO.doRetrievePhotoById(codice));
        }

        prodotto.setCodice(codice);
        prodotto.setDescrizione(descrizione);

        prodotto.setNome(nomeProdotto);
        prodotto.setTipologia(tipologia);
        prodotto.setPrezzo(prezzoProdotto);

        boolean ris = prodottoDAO.doUpdate(prodotto, foto);

        if(ris){
            address = "WEB-INF/result/AdminView.jsp";
        }
        else{
            address = "WEB-INF/result/homepage.jsp"; //da cambiaree
        }



        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);

    }

}