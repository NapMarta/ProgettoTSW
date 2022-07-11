package model.dao;

import model.ConPool;
import model.beans.ListaDeiDesideri;
import model.beans.Prodotto;
import model.beans.Utente;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListaDeiDesideriDAO {

    public ListaDeiDesideri doRetrieveById(int idUtente){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT codice, nome, prezzo, descrizione, tipologia, immagine " +
                            "FROM prodotto JOIN seleziona ON codice=codiceProdotto WHERE idUtente=?");
            ps.setInt(1, idUtente);
            ResultSet rs = ps.executeQuery();
            ArrayList<Prodotto> listaProdotti = new ArrayList<>();
            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setCodice(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setPrezzo(rs.getDouble(3));
                p.setDescrizione(rs.getString(4));
                p.setTipologia(rs.getString(5));
                p.setImmagine(rs.getBinaryStream(6));
                listaProdotti.add(p);
            }
            ListaDeiDesideri lista = new ListaDeiDesideri(idUtente, listaProdotti);
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doCreate(ListaDeiDesideri lista){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO listaDesideri (idUtente) VALUES(?)");
            ps.setInt(1, lista.getIdUtente());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean doUpdate(ListaDeiDesideri lista){
        boolean ris = false;
        try (Connection con = ConPool.getConnection()) {
            Statement st = con.createStatement();

            String query1 = "delete from seleziona where idUtente='" + lista.getIdUtente() + "';";
            st.executeUpdate(query1);

            for (Prodotto p: lista.getListaProdotti()) {
                PreparedStatement ps1 = con.prepareStatement("insert into seleziona (codiceProdotto, idUtente) VALUES (?, ?)");
                ps1.setInt(1,p.getCodice());
                ps1.setInt(2, lista.getIdUtente());

                if (ps1.executeUpdate() != 1) {
                    throw new RuntimeException("INSERT error.");
                }
            }

            ris = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(ris)
            return true;       //aggiornamento a buon fine
        return false;
    }

}
