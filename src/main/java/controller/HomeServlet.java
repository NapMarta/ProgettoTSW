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
import java.util.List;

@WebServlet(name = "Home", value = "/Home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String x = request.getParameter("home");
        String y = request.getParameter("login");
        String address = null;
        HttpSession session = request.getSession(true);

        if(x != null){
            ProdottoDAO prodottoDAO = new ProdottoDAO();
            List<Prodotto> list = prodottoDAO.doRetrieveByTipologia("Pizza");
            request.setAttribute("prodottoList", list);
            Carrello carrello = new Carrello();
            ArrayList<ProdottoQuantita> prodotti = new ArrayList<>();
            carrello.setListaProdotti(prodotti);
            session.setAttribute("carrello",carrello);
            address = "WEB-INF/result/homepage.jsp";
        }
        else {
            Carrello carrello = new Carrello();
            ArrayList<ProdottoQuantita> prodotti = new ArrayList<>();
            carrello.setListaProdotti(prodotti);
            session.setAttribute("carrello",carrello);
            address = "WEB-INF/result/login.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
