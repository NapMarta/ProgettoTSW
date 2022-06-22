package model.dao;

import model.ConPool;
import model.beans.Prodotto;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Blob;

public class ProdottoDAO {
    private static final int BUFFER_SIZE = 1024;

    public Prodotto doRetrieveById(int codice){
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

    public int doSave(Prodotto prodotto){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO prodotto (nome, prezzo, descrizione, tipologia, immagine) VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, prodotto.getNome());
            ps.setString(4, prodotto.getTipologia());
            ps.setString(3, prodotto.getDescrizione());
            ps.setDouble(2,prodotto.getPrezzo());
            ps.setBinaryStream(5,prodotto.getImmagine());

            InputStream stream = prodotto.getImmagine();
            if(stream != null){
                ps.setBlob(5, stream);
            }

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

    public List<Prodotto> doRetrieveAll(){
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

                //foto dal DB
                Blob blob = resultSet.getBlob(6);
                InputStream stream = blob.getBinaryStream();

                listaProd.add(new Prodotto(codice, nome, tipologia, descrizione, prezzo, stream));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return listaProd;
    }

    public boolean doUpdate(Prodotto p, boolean foto){
        boolean ris = false;
        try (Connection con = ConPool.getConnection()) {
            Statement st = con.createStatement();

            String query = "update prodotto set nome='" + p.getNome() + "', tipologia='" +
                    p.getTipologia() + "', descrizione='" + p.getDescrizione() + "', prezzo='" + p.getPrezzo() + "' where codice='" + p.getCodice() + "';";
            st.executeUpdate(query);
            ris = true;

            if(foto){
                ris = doUpdatePhotoById(p);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(ris)
            return true;
        return false;
    }

    public Blob doRetrievePhotoById (int id){
        Blob blob = null;

        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps1 = con.prepareStatement("SELECT immagine FROM prodotto where codice='" + id +"'");
            ResultSet resultSet1 = ps1.executeQuery();

            if(resultSet1.next()){
                blob = resultSet1.getBlob(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return blob;
    }

    public boolean doUpdatePhotoById (Prodotto prodotto){

        boolean rs = false;
        try (Connection con = ConPool.getConnection()) {

            PreparedStatement ps = con.prepareStatement("UPDATE prodotto SET immagine = ? where codice='" + prodotto.getCodice() +"'");
            InputStream stream = prodotto.getImmagine();
            if(stream != null){
                ps.setBlob(1, stream);
            }
            ps.executeUpdate();
            rs = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        if(rs)
            return true;
        return false;
    }
}
