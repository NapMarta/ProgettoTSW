package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Prodotto;
import model.dao.ProdottoDAO;

import java.io.IOException;

@WebServlet(name = "PhotoController", value = "/PhotoController")
public class PhotoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProdottoDAO prodottoDAO = new ProdottoDAO();
        byte[] buffer = prodottoDAO.doRetrievePhotoById(id);

        ServletOutputStream out = response.getOutputStream();
        if(buffer != null)
        {
            out.write(buffer);
            response.setContentType("image/jpeg");
        }
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
