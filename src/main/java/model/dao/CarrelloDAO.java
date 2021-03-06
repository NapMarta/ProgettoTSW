package model.dao;

import model.ConPool;
import model.beans.Carrello;
import model.beans.ProdottoQuantita;
import java.sql.*;
import java.util.ArrayList;

public class CarrelloDAO {

    public Carrello doRetrieveByIdUtente(int idUtente){
        try (Connection con = ConPool.getConnection()){

            PreparedStatement ps1 =
                    con.prepareStatement("SELECT * FROM carrello WHERE idUtente=?");
            ps1.setInt(1, idUtente);
            ResultSet rs1 = ps1.executeQuery();

            Carrello carrello = new Carrello();

            if (rs1.next()) {
                carrello.setCodice(rs1.getInt(1));
                carrello.setIdUtente(rs1.getInt(4));
                carrello.setTotale(rs1.getDouble(2));
                carrello.setNumeroProdotti(rs1.getInt(3));
            }

            int codice = carrello.getCodice();

            PreparedStatement ps =
                    con.prepareStatement("SELECT codice, nome, prezzo, descrizione, tipologia, immagine, quantità " +
                            "FROM prodotto JOIN contenere ON codice=codiceProdotto WHERE codiceCarrello='" + codice + "';");
            ResultSet rs = ps.executeQuery();
            ArrayList<ProdottoQuantita> listaProdotti = new ArrayList<>();
            while (rs.next()) {
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

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int doCreate(Carrello c){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO carrello (idUtente, totale, numeroProdotti) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, c.getIdUtente());
            ps.setDouble(2,c.getTotale());
            ps.setInt(3,c.getNumeroProdotti());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            c.setCodice(id);


            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean doUpdate(Carrello carrello){
        boolean ris = false;
        try (Connection con = ConPool.getConnection()) {
            Statement st = con.createStatement();
            String query = "update carrello set totale='" + carrello.calcolaTotale() + "', numeroProdotti='" + carrello.calcolaNumeroProdotti() +"'" +
                    "where idUtente='" + carrello.getIdUtente()+"'";
            st.executeUpdate(query);

            String query1 = "delete from contenere where codiceCarrello='" + carrello.getCodice() + "';";
            st.executeUpdate(query1);

            for (ProdottoQuantita p: carrello.getListaProdotti()) {
                PreparedStatement ps1 = con.prepareStatement("insert into contenere (codiceProdotto, codiceCarrello, quantità) VALUES (?, ?, ?)");
                ps1.setInt(1,p.getCodice());
                ps1.setInt(2, carrello.getCodice());
                ps1.setInt(3, p.getQuantita());

                if (ps1.executeUpdate() != 1) {
                    throw new RuntimeException("INSERT error.");
                }
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