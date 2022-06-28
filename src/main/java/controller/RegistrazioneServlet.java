package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Carrello;
import model.beans.ListaDeiDesideri;
import model.beans.Prodotto;
import model.beans.Utente;
import model.dao.ProdottoDAO;
import model.dao.UtenteDAO;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Registrazione", value = "/Registrazione")
public class RegistrazioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String address = null;
        HttpSession session = request.getSession(true);

        if(login != null){
            address = "/WEB-INF/result/login.jsp";
        }
        else {
            Utente utente = new Utente();
            UtenteDAO service = new UtenteDAO();
            try {
                utente.setPasswordUtente(request.getParameter("psw"));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            utente.setEmail(request.getParameter("email"));
            utente.setNome(request.getParameter("nome"));
            utente.setCognome(request.getParameter("cognome"));
            utente.setAdmin(false);

            request.setAttribute("utente", utente);
            utente.setId(service.doSave(utente));

            ProdottoDAO prodottoDAO = new ProdottoDAO();
            List<Prodotto> list = prodottoDAO.doRetrieveByTipologia("Pizza");
            request.setAttribute("prodottoList", list);

            Carrello carrello = (Carrello) session.getAttribute("carrello");
            carrello.setIdUtente(utente.getId());
            ListaDeiDesideri listaDeiDesideri = new ListaDeiDesideri();
            ArrayList<Prodotto> arrayListDes = new ArrayList<>();
            listaDeiDesideri.setListaProdotti(arrayListDes);
            listaDeiDesideri.setIdUtente(utente.getId());

            synchronized (session){
                session.setAttribute("carrello", carrello);
                session.setAttribute("utente", utente);
                session.setAttribute("listaDeiDesideri", listaDeiDesideri);
            }

            address = "WEB-INF/result/homepage.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
