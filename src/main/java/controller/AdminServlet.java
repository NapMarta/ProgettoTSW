package controller;

import com.mysql.cj.Session;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Prodotto;
import model.dao.ProdottoDAO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scelta = request.getParameter("scelta");
        String address = null;
        HttpSession session = request.getSession(false);

        switch(scelta){
            case "Aggiungi prodotto":
                address = "WEB-INF/result/inserimentoProdotto.jsp";
                break;

            case "Rimuovi prodotto":

                synchronized (session){
                    int id  = Integer.parseInt(request.getParameter("codice"));
                    ProdottoDAO prodottoDAO = new ProdottoDAO();
                    prodottoDAO.doDeleteById(id);
                    List<Prodotto> list = prodottoDAO.doRetrieveAll();
                    request.setAttribute("prodottoList", list);
                    address = "WEB-INF/result/AdminView.jsp";
                }
                break;

            case "Modifica prodotto":

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
                session.invalidate();
                address = "index.jsp";
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
