package model.dao;

import model.ConPool;
import model.beans.Utente;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAO {

    public Utente doRetrieveById(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id, nome, cognome, email, passwordUtente FROM utente WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utente p = new Utente();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setCognome(rs.getString(3));
                p.setEmail(rs.getString(4));
                p.setPasswordUtente(rs.getString(5));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Utente doRetrieveByCredenziali(String email, String password) throws SQLException{
        Connection con = ConPool.getConnection();
        PreparedStatement ps =
              con.prepareStatement("SELECT id, nome, cognome, email, passwordUtente FROM utente WHERE email=? and passwordUtente=?");
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Utente p = new Utente();
            p.setId(rs.getInt(1));
            p.setNome(rs.getString(2));
            p.setCognome(rs.getString(3));
            p.setEmail(rs.getString(4));
            p.setPasswordUtente(rs.getString(5));
            return p;
        }
        return null;
    }

    public int doSave(Utente utente){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO utente (nome, cognome, email, passwordUtente) VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, utente.getNome());
            ps.setString(2, utente.getCognome());
            ps.setString(3, utente.getEmail());
            ps.setString(4, utente.getPasswordUtente());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            utente.setId(id);
            return id;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Utente> doRetrieveAll(){
        List<Utente> utenteList = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM utente");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                String cognome = resultSet.getString(3);
                String email = resultSet.getString(4);
                String password = resultSet.getString(5);
                utenteList.add(new Utente(id, email, password, nome, cognome));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return utenteList;
    }

    public boolean doUpdate(Utente utente){
        boolean ris = false;
        try (Connection con = ConPool.getConnection()) {
            Statement st = con.createStatement();
            String query = "update Utente set nome='" + utente.getNome() + "', cognome='" +
                    utente.getCognome() + "', email='" + utente.getEmail() + "', passwordUtente='" + utente.getPasswordUtente() +  "' where id='" + utente.getId() + "';";
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
