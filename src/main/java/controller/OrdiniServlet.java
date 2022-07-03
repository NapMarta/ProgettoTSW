package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Prodotto;
import model.dao.ProdottoDAO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Ordini", value = "/Ordini")
public class OrdiniServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String home = request.getParameter("home");
        String homeAdmin = request.getParameter("homeAdmin");
        String address = null;
        if(home != null){
            address = "WEB-INF/result/homePage.jsp";
            ProdottoDAO prodottoDAO = new ProdottoDAO();
            List<Prodotto> list = prodottoDAO.doRetrieveByTipologia("Pizza");
            request.setAttribute("prodottoList", list);
        }

        if(homeAdmin != null){
            address = "WEB-INF/result/AdminView.jsp";
            ProdottoDAO prodottoDAO = new ProdottoDAO();
            List<Prodotto> prodottoList = prodottoDAO.doRetrieveAll();
            request.setAttribute("prodottoList", prodottoList);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
