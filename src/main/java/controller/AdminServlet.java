package controller;

import com.mysql.cj.Session;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Prodotto;
import model.dao.ProdottoDAO;

import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scelta = request.getParameter("scelta");
        String address = null;

        switch(scelta){
            case "Aggiungi prodotto":
                address = "WEB-INF/result/inserimentoProdotto.jsp";
                break;

            case "Rimuovi prodotto":
                break;
            case "Modifica prodotto":

                HttpSession session = request.getSession();
                synchronized (session){
                    int id  = Integer.parseInt(request.getParameter("codice"));
                    ProdottoDAO prodottoDAO = new ProdottoDAO();
                    Prodotto p = prodottoDAO.doRetrieveById(id);
                    session.setAttribute("prodotto", p);
                    address = "WEB-INF/result/modificaProdotto.jsp";
                }
                break;

            case "Visualizza ordini":
                break;
            case "Visualizza utenti":
                break;

            case "Logout":
                break;
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
