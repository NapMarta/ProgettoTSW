package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Carrello;
import model.beans.ListaDeiDesideri;
import model.dao.CarrelloDAO;
import model.dao.ListaDeiDesideriDAO;
import model.dao.ProdottoDAO;

import java.io.IOException;

@WebServlet(name = "OperazioniUtente", value = "/OperazioniUtente")
public class OperazioniUtenteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String elements = request.getParameter("elements");
        String address = null;

        if(elements.equalsIgnoreCase("Ordini Effettuati")){

        }

        if(elements.equalsIgnoreCase("Modifica Credenziali")){

        }

        if(elements.equalsIgnoreCase("Lista dei desideri")){
            address = "WEB-INF/result/listaDesideriView.jsp";
        }

        if(elements.equalsIgnoreCase("Logout")){
            HttpSession session = request.getSession();
            Carrello carrello = (Carrello) session.getAttribute("carrello");
//            ListaDeiDesideri listaDeiDesideri = (ListaDeiDesideri) session.getAttribute("listaDeiDesideri");


            CarrelloDAO carrelloDAO = new CarrelloDAO();
//            carrelloDAO.doDeleteById(carrello.getIdUtente());
            carrelloDAO.doUpdate(carrello);

//            ListaDeiDesideriDAO listaDeiDesideriDAO = new ListaDeiDesideriDAO();
//            listaDeiDesideriDAO.doSave(listaDeiDesideri);

            synchronized (session){
                session.invalidate();
            }

            address = "index.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
