package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.beans.Prodotto;
import model.dao.ProdottoDAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

@WebServlet(name = "PhotoController", value = "/PhotoController")
public class PhotoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int BUFFER_SIZE = 4096;
        try{
            int id = Integer.parseInt(request.getParameter("codice"));
            ProdottoDAO prodottoDAO = new ProdottoDAO();
            Blob blob = prodottoDAO.doRetrievePhotoById(id);

            response.setContentType("image/jpeg");
            InputStream stream = blob.getBinaryStream();
            ServletOutputStream out = response.getOutputStream();

            int length = (int) blob.length();
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((length = stream.read(buffer)) != -1) {
//                System.out.println("writing " + length + " bytes");
                out.write(buffer, 0, length);
            }
            stream.close();
            out.close();


        }catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
