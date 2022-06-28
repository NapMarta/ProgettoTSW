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
            if (rs.next()) {
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

    public void doSave(ListaDeiDesideri lista){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO listaDesideri (idUtente) VALUES(?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, lista.getIdUtente());
            for (Prodotto p: lista.getListaProdotti())
            {
                PreparedStatement ps1 = con.prepareStatement(
                        "INSERT INTO seleziona (codiceProdotto, idUtente) VALUES(?,?)",
                        Statement.RETURN_GENERATED_KEYS);
                ps1.setInt(1,p.getCodice());
                ps1.setInt(2, lista.getIdUtente());
            }

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ListaDeiDesideri> doRetrieveAll(){
        List<ListaDeiDesideri> listaDeiDesideriList = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM listaDesideri");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);

                ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
                PreparedStatement ps1 = con.prepareStatement("SELECT  codice, prezzo, descrizione, tipologia, immagine FROM prodotto JOIN seleziona ON codiceProdotto = codice WHERE idUtente=?");
                ps1.setInt(1, id);
                ResultSet resultSet1 = ps.executeQuery();


                while (resultSet1.next()){
                    int codice = resultSet.getInt(1);
                    String nomeProdotto = resultSet.getString(2);
                    double prezzo = resultSet.getDouble(3);
                    String descrizione = resultSet.getString(4);
                    String tipologia = resultSet.getString(5);
                    InputStream immagine = resultSet.getBinaryStream(6);
                    prodotti.add(new Prodotto(codice, nomeProdotto, tipologia, descrizione, prezzo, immagine));
                }

                listaDeiDesideriList.add(new ListaDeiDesideri(id, prodotti));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeiDesideriList;
    }

    public boolean doUpdate(ListaDeiDesideri lista){
        boolean ris = false;
        try (Connection con = ConPool.getConnection()) {
            Statement st = con.createStatement();
            String query = "update listaDesideri set idUtente='" + lista.getIdUtente() + "';";
            st.executeUpdate(query);
            for (Prodotto p: lista.getListaProdotti()) {
                String query1 = "delete * from seleziona where idUtente='" + lista.getIdUtente() + "';";
                st.executeUpdate(query1);

                String query2 = "insert into seleziona values  codiceProdotto='" + p.getCodice() + "', idUtente='" + lista.getIdUtente() + "';";
                st.executeUpdate(query2);
            }

            ris = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(ris)
            return true;       //aggiurnamento a buon fine
        return false;
    }

    public void doDeleteById(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM listaDesideri WHERE codice=?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
