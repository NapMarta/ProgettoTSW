package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Prodotto;
import model.beans.Utente;
import model.dao.ProdottoDAO;
import model.dao.UtenteDAO;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ModificaCredenziali", value = "/ModificaCredenziali")
public class ModificaCredenzialiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String annulla = request.getParameter("annulla");
        String modifica = request.getParameter("modifica");
        boolean ris = true, update;
        String address = null;
        UtenteDAO utenteDAO = new UtenteDAO();

        if(annulla != null){
            ProdottoDAO prodottoDAO = new ProdottoDAO();
            List<Prodotto> list = prodottoDAO.doRetrieveByTipologia("Pizza");
            request.setAttribute("prodottoList", list);

            address = "WEB-INF/result/homepage.jsp";

        }else if(modifica != null){
            int codice = Integer.parseInt(request.getParameter("codice"));
            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            String email = request.getParameter("email");

            String vecchiaPsw = request.getParameter("pswDB");
            String pswInserita = request.getParameter("pswdOld");
            String nuovaPsw = request.getParameter("pswd");
            String nuovaPswRepeat = request.getParameter("pswrepeat");

            /* validazione lato server */
            if(!RequestValidator.assertPassword(pswInserita)){
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            }
            if(!RequestValidator.assertPassword(nuovaPsw)){
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            }
            if(!RequestValidator.assertPassword(nuovaPswRepeat)){
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            }
            if(!RequestValidator.assertNome(nome)){
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            }
            if(!RequestValidator.assertCognome(cognome)){
                RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                dispatcher.forward(request, response);
            }
            /* fine validazione */

            Utente utente = new Utente();

            utente.setId(codice);
            utente.setNome(nome);
            utente.setCognome(cognome);
            utente.setEmail(email);

            Utente u = new Utente();
            try {
                u.setPasswordUtente(pswInserita);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            String psw = u.getPasswordUtente();

            try {
                u = utenteDAO.doRetrieveByCredenziali(email, psw);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }


            if(u != null){
                if(nuovaPsw.equals(nuovaPswRepeat)){
                    try {
                        utente.setPasswordUtente(nuovaPsw);
                        utenteDAO.doUpdate(utente);

                        ProdottoDAO prodottoDAO = new ProdottoDAO();
                        List<Prodotto> list = prodottoDAO.doRetrieveByTipologia("Pizza");
                        request.setAttribute("prodottoList", list);

                        address = "WEB-INF/result/homepage.jsp";
                    } catch (NoSuchAlgorithmException | SQLException e) {
                        e.printStackTrace();
                        ris = false;
                        request.setAttribute("ris", ris);
                        address = "WEB-INF/result/modificaCredenziali.jsp";
                    }
                }
            }
            else{
                ris = false;
                request.setAttribute("ris", ris);
                address = "WEB-INF/result/modificaCredenziali.jsp";
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
