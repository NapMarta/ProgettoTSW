package model.dao;

import model.ConPool;
import model.beans.Prodotto;
import model.beans.Utente;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    public static Prodotto doRetrieveById(int codice){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT *  FROM prodotto WHERE codice=?");
            ps.setInt(1, codice);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Prodotto p = new Prodotto();
                p.setCodice(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setTipologia(rs.getString(5));
                p.setDescrizione(rs.getString(4));
                p.setPrezzo(rs.getDouble(3));
                p.setImmagine(rs.getBinaryStream(6));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int doSave(Prodotto prodotto){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO prodotto (nome, prezzo, descrizione, tipologia, immagine) VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, prodotto.getNome());
            ps.setString(4, prodotto.getTipologia());
            ps.setString(3, prodotto.getDescrizione());
            ps.setDouble(2,prodotto.getPrezzo());
            ps.setBinaryStream(5,prodotto.getImmagine());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int codice = rs.getInt(1);
            prodotto.setCodice(codice);
            return codice;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Prodotto> doRetrieveAll(){
        List<Prodotto> listaProd = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM prodotto");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int codice = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                String tipologia = resultSet.getString(5);
                String descrizione = resultSet.getString(4);
                double prezzo = resultSet.getDouble(3);
                InputStream immagine = resultSet.getBinaryStream(6);
                listaProd.add(new Prodotto(codice, nome, tipologia, descrizione, prezzo, immagine));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return listaProd;
    }

    public static boolean doUpdate(Prodotto p){
        boolean ris = false;
        try (Connection con = ConPool.getConnection()) {
            Statement st = con.createStatement();
            String query = "update prodotto set nome='" + p.getNome() + "', tipologia='" +
                    p.getTipologia() + "', descrizione='" + p.getDescrizione() + "', prezzo='" + p.getPrezzo() + "', immagine='" + p.getImmagine() + "' where codice='" + p.getCodice() + "';";
            st.executeUpdate(query);
            ris = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(ris)
            return true;
        return false;
    }
}
