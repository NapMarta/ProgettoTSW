package model.dao;

import model.ConPool;
import model.beans.Carrello;
import model.beans.Ordine;
import model.beans.ProdottoQuantita;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdineDAO {

    public Ordine doRetrieveById(int codice){
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps1 =
                    con.prepareStatement("SELECT * FROM ordine WHERE codice=?");
            ps1.setInt(1, codice);
            ResultSet rs1 = ps1.executeQuery();

            Ordine ordine = new Ordine();

            if (rs1.next()) {
                ordine.setCodice(rs1.getInt(1));
                ordine.setTipologia(rs1.getString(2));
                ordine.setSconto(rs1.getDouble(3));
                ordine.setTotale(rs1.getDouble(4));
                ordine.setDataPagamento(rs1.getDate(5));
                ordine.setTipoPagamento(rs1.getString(6));
                ordine.setIdUtente(rs1.getInt(7));
            }

            PreparedStatement ps =
                    con.prepareStatement("SELECT codice, nome, prezzo, descrizione, tipologia, immagine, quantità FROM prodotto JOIN appartenere ON codice=codiceProdotto WHERE codice=?");
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

            ordine.setListaProdotti(listaProdotti);
            return ordine;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Ordine o){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ordine (tipologia, sconto, totale, dataPagamento, tipoPagamento, idUtente ) VALUES(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, o.getTipologia());
            ps.setDouble(2, o.getSconto());
            ps.setDouble(3,o.getTotale());
            ps.setDate(4,o.getDataPagamento());
            ps.setString(5,o.getTipoPagamento());
            ps.setInt(6,o.getIdUtente());

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            o.setCodice(id);

            for (ProdottoQuantita p: o.getListaProdotti())
            {
                PreparedStatement ps1 = con.prepareStatement(
                        "INSERT INTO appartenere (codiceProdotto, codiceOrdine, quantità) VALUES(?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);
                ps1.setInt(1,p.getCodice());
                ps1.setInt(2, o.getCodice());
                ps1.setInt(3, p.getQuantita());
            }

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Ordine> doRetrieveAll(){
        List<Ordine> ordini = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ordine");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                int codice = resultSet.getInt(1);
                String tipologia = resultSet.getString(2);
                double sconto = resultSet.getDouble(3);
                double totale = resultSet.getDouble(4);
                Date dataPag = resultSet.getDate(5);
                String tipoPag = resultSet.getString(6);
                int idUtente = resultSet.getInt(7);

                PreparedStatement ps1 = con.prepareStatement("SELECT codice, nome, prezzo, descrizione, tipologia, immagine, quantità FROM prodotto JOIN appartenere ON codice=codiceProdotto ORDER BY codiceOrdine");
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

                ordini.add(new Ordine(codice, idUtente, tipologia, tipoPag, sconto, totale, dataPag, prodotti));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return ordini;
    }


}
