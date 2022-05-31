package model.dao;

import model.ConPool;
import model.beans.Carrello;
import model.beans.ListaDeiDesideri;
import model.beans.Prodotto;
import model.beans.ProdottoQuantita;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarrelloDAO {

    public Carrello doRetrieveById(int codice){
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps1 =
                    con.prepareStatement("SELECT * FROM carrello WHERE codice=?");
            ps1.setInt(1, codice);
            ResultSet rs1 = ps1.executeQuery();

            Carrello carrello = new Carrello();

            if (rs1.next()) {
                carrello.setCodice(rs1.getInt(1));
                carrello.setIdUtente(rs1.getInt(5));
                carrello.setTotale(rs1.getDouble(3));
                carrello.setSconto(rs1.getDouble(2));
                carrello.setNumeroProdotti(rs1.getInt(4));
            }

            PreparedStatement ps =
                    con.prepareStatement("SELECT codice, nome, prezzo, descrizione, tipologia, immagine, quantità FROM prodotto JOIN contenere ON codice=codiceProdotto WHERE codice=?");
            ps.setInt(1, codice);
            ResultSet rs = ps.executeQuery();
            ArrayList<ProdottoQuantita> listaProdotti = new ArrayList<>();
            if (rs.next()) {
                ProdottoQuantita p = new ProdottoQuantita();
                p.setCodice(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setPrezzo(rs.getDouble(3));
                p.setDescrizione(rs.getString(4));
                p.setTipologia(rs.getString(5));
                p.setImmagine(rs.getBinaryStream(6));
                p.setQuantita(rs.getInt(7));
                listaProdotti.add(p);
            }

            carrello.setListaProdotti(listaProdotti);
            return carrello;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Carrello c){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO carrello (idUtente, totale, sconto, numeroProdotti) VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, c.getIdUtente());
            ps.setDouble(2,c.getTotale());
            ps.setDouble(3,c.getSconto());
            ps.setInt(4,c.getNumeroProdotti());

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            c.setCodice(id);

            for (ProdottoQuantita p: c.getListaProdotti())
            {
                PreparedStatement ps1 = con.prepareStatement(
                        "INSERT INTO contenere (codiceProdotto, codiceCarrello, quantità) VALUES(?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);
                ps1.setInt(1,p.getCodice());
                ps1.setInt(2, c.getCodice());
                ps1.setInt(3, p.getQuantita());
            }

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Carrello> doRetrieveAll(){
        List<Carrello> carrelli = new ArrayList<Carrello>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM carrello");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                int codice = resultSet.getInt(1);
                int idUtente = resultSet.getInt(5);
                double totale = resultSet.getDouble(3);
                double sconto = resultSet.getDouble(2);
                int numProdotti = resultSet.getInt(4);


                PreparedStatement ps1 = con.prepareStatement("SELECT codice, nome, prezzo, descrizione, tipologia, immagine, quantità FROM prodotto JOIN contenere ON codice=codiceProdotto ORDER BY codiceCarrello");
                ResultSet rs = ps.executeQuery();

                ArrayList<ProdottoQuantita> prodotti = new ArrayList<>();
                while(rs.next()){
                    ProdottoQuantita p = new ProdottoQuantita();
                    p.setCodice(rs.getInt(1));
                    p.setNome(rs.getString(2));
                    p.setPrezzo(rs.getDouble(3));
                    p.setDescrizione(rs.getString(4));
                    p.setTipologia(rs.getString(5));
                    p.setImmagine(rs.getBinaryStream(6));
                    p.setQuantita(rs.getInt(7));
                    prodotti.add(p);
                }

                carrelli.add(new Carrello(codice, idUtente, totale, sconto, numProdotti,prodotti));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return carrelli;
    }

    public boolean doUpdate(Carrello carrello){
        boolean ris = false;
        try (Connection con = ConPool.getConnection()) {
            Statement st = con.createStatement();
            String query = "update carrello set sconto='" + carrello.getSconto() + "', totale='" +
                    carrello.getTotale() + "', numeroProdotti='" + carrello.getNumeroProdotti() +"';";
            st.executeUpdate(query);
            for (ProdottoQuantita p: carrello.getListaProdotti()) {
                String query1 = "delete * from contenere where codiceCarrello='" + carrello.getCodice() + "' AND codiceProdotto='" + p.getCodice() + "';";
                st.executeUpdate(query1);

                String query2 = "insert into contenere values  codiceProdotto='" + p.getCodice() + "', codiceCarrello='" + carrello.getCodice() + "', quantità='" +
                        p.getQuantita() + "';";
                st.executeUpdate(query2);
            }

            ris = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(ris)
            return true;
        return false;
    }
}
