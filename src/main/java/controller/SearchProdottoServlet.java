package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Prodotto;
import model.dao.ProdottoDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchProdotto", value = "/SearchProdotto")
public class SearchProdottoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        String address;
        ProdottoDAO prodottoDAO = new ProdottoDAO();
        ArrayList<Prodotto> list  = (ArrayList<Prodotto>) prodottoDAO.search(search);
        request.setAttribute("prodottoList", list);

        address = "WEB-INF/result/homepage.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
