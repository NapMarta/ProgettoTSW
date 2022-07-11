package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Carrello;
import model.beans.ListaDeiDesideri;
import model.beans.Prodotto;
import model.beans.ProdottoQuantita;

import java.io.IOException;
import java.util.Iterator;

@WebServlet(name = "ListaDesideri", value = "/ListaDesideri")
public class ListaDesideriServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cancella = request.getParameter("cancella");
        String address = null;
        HttpSession session = request.getSession();
        ListaDeiDesideri listaDeiDesideri = (ListaDeiDesideri) session.getAttribute("listaDeiDesideri");

        if(cancella != null){           //cancella il prodotto solo se abbiamo il prodotto nel carrello
            int cod = Integer.parseInt(request.getParameter("codice"));
            Iterator<Prodotto> iterator = listaDeiDesideri.getListaProdotti().iterator();
            while(iterator.hasNext()) {
                Prodotto p = iterator.next();
                if(p.getCodice() == cod){
                    iterator.remove();
                }
            }
            address = "WEB-INF/result/listaDesideriView.jsp";

            synchronized (session){
                session.setAttribute("listaDeiDesideri", listaDeiDesideri);
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
