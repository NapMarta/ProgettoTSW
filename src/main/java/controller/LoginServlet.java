package controller;

import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.ConPool;
import model.beans.Carrello;
import model.beans.ListaDeiDesideri;
import model.beans.Prodotto;
import model.beans.Utente;
import model.dao.CarrelloDAO;
import model.dao.ListaDeiDesideriDAO;
import model.dao.ProdottoDAO;
import model.dao.UtenteDAO;
import java.util.List;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "Login", value = "/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accedi = request.getParameter("accedi");
        String registrazione = request.getParameter("registrati");
        String address = null;
        HttpSession session = request.getSession(true);

        if(registrazione != null){
            address = "WEB-INF/result/registrazioneUtente.jsp";
        }
        else{
            Utente utente = new Utente();
            UtenteDAO utenteDAO = new UtenteDAO();

            String email = request.getParameter("email");
            String password = request.getParameter("password");
            try {
                utente.setPasswordUtente(password);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            String pswCrittografata = utente.getPasswordUtente();

            try {
                utente = utenteDAO.doRetrieveByCredenziali(email, pswCrittografata);
            } catch (SQLException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            if(utente.isAdmin()){
                address = "WEB-INF/result/AdminView.jsp";
                ProdottoDAO prodottoDAO = new ProdottoDAO();
                List<Prodotto> prodottoList = (List<Prodotto>) prodottoDAO.doRetrieveAll();
                request.setAttribute("utente", utente);
                request.setAttribute("prodottoList", prodottoList);
            }
            else {
                ProdottoDAO prodottoDAO = new ProdottoDAO();
                List<Prodotto> list = prodottoDAO.doRetrieveByTipologia("Pizza");
                request.setAttribute("prodottoList", list);
                request.setAttribute("utente", utente);

                CarrelloDAO carrelloDAO = new CarrelloDAO();
                Carrello carrello = carrelloDAO.doRetrieveByIdUtente(utente.getId());

                if(carrello == null){
                    carrello = (Carrello) session.getAttribute("carrello");
                    carrello.setIdUtente(utente.getId());
                }
                else {
                    synchronized (session) {
                        session.setAttribute("carrello", carrello);
                    }
                }

                ListaDeiDesideriDAO listaDeiDesideriDAO = new ListaDeiDesideriDAO();
                ListaDeiDesideri listaDeiDesideri = listaDeiDesideriDAO.doRetrieveById(utente.getId());


                if(listaDeiDesideri == null){
                    ArrayList<Prodotto> arrayListDes = new ArrayList<>();
                    listaDeiDesideri.setListaProdotti(arrayListDes);
                    listaDeiDesideri.setIdUtente(utente.getId());
                }

                synchronized (session){
                    session.setAttribute("listaDeiDesideri", listaDeiDesideri);
                }

                address = "WEB-INF/result/homepage.jsp";
            }

            synchronized (session){
                session.setAttribute("utente", utente);
            }


        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);

    }
}
