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

    public ArrayList<Ordine> doRetrieveByIdUtente(int codiceUtente){
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps1 =
                    con.prepareStatement("SELECT * FROM ordine WHERE idUtente=?");
            ps1.setInt(1, codiceUtente);
            ResultSet rs1 = ps1.executeQuery();

            ArrayList<Ordine> list = new ArrayList<>();

            while (rs1.next()) {
                Ordine ordine = new Ordine();
                ordine.setCodice(rs1.getInt(1));
                ordine.setTipologia(rs1.getString(2));
                ordine.setTotale(rs1.getDouble(3));
                ordine.setDataPagamento(rs1.getDate(4));
                ordine.setTipoPagamento(rs1.getString(5));
                ordine.setNumeroCarta(rs1.getString(6));
                ordine.setVia(rs1.getString(7));
                ordine.setCap(rs1.getString(8));
                ordine.setCitta(rs1.getString(9));

                PreparedStatement ps =
                        con.prepareStatement("SELECT codice, nome, prezzo, descrizione, tipologia, immagine, quantità " +
                                "FROM prodotto JOIN appartenere ON codice=codiceProdotto WHERE codiceOrdine=?");
                ps.setInt(1, ordine.getCodice());
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
                ordine.setListaProdotti(listaProdotti);

                list.add(ordine);
            }


            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Ordine o){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ordine (idUtente, tipologia, totale, dataPagamento, tipoPagamento, numeroCarta, via, cap, citta) " +
                            "VALUES(?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, o.getIdUtente());
            ps.setString(2, o.getTipologia());
            ps.setDouble(3,o.getTotale());
            ps.setDate(4,o.getDataPagamento());
            ps.setString( 5,o.getTipoPagamento());
            ps.setString(6, o.getNumeroCarta());
            ps.setString(7, o.getVia());
            ps.setString(8, o.getCap());
            ps.setString(9, o.getCitta());

            if(ps.executeUpdate() != 1){
                throw new RuntimeException("INSERT error.");
            }

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

                if (ps1.executeUpdate() != 1) {
                    throw new RuntimeException("INSERT error.");
                }

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Ordine> doRetrieveForAdmin(){
        List<Ordine> ordini = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT codice, tipologia, totale, dataPagamento, tipoPagamento, " +
                    "idUtente, numeroCarta, via, cap, citta, email FROM ordine JOIN utente ON idUtente=id");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                int codice = resultSet.getInt(1);
                String tipologia = resultSet.getString(2);
                double totale = resultSet.getDouble(3);
                Date dataPag = resultSet.getDate(4);
                String tipoPag = resultSet.getString(5);
                int idUtente = resultSet.getInt(6);
                String numeroCarta = resultSet.getString(7);
                String via = resultSet.getString(8);
                String cap = resultSet.getString(9);
                String citta = resultSet.getString(10);
                String emailUtente = resultSet.getString(11);

                PreparedStatement ps1 = con.prepareStatement("SELECT prodotto.codice, nome, prezzo, descrizione, prodotto.tipologia, quantità " +
                        "FROM (prodotto JOIN appartenere ON prodotto.codice=codiceProdotto) JOIN ordine ON codiceOrdine=ordine.codice WHERE idUtente='" + idUtente +"'");
                ResultSet rs = ps1.executeQuery();

                ArrayList<ProdottoQuantita> prodotti = new ArrayList<>();
                while(rs.next()){
                    ProdottoQuantita p = new ProdottoQuantita();
                    p.setCodice(rs.getInt(1));
                    p.setNome(rs.getString(2));
                    p.setPrezzo(rs.getDouble(3));
                    p.setDescrizione(rs.getString(4));
                    p.setTipologia(rs.getString(5));
                    p.setQuantita(rs.getInt(6));
                    prodotti.add(p);
                }

                ordini.add(new Ordine(codice, idUtente, tipologia, tipoPag, numeroCarta, via,
                        cap, citta, emailUtente, totale, dataPag, prodotti));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return ordini;
    }
}
