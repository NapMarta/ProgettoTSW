package model.beans;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utente {

    public Utente() {
    }

    public Utente(int id, String email, String passwordUtente, String nome, String cognome, boolean isAdmin) {
        this.id = id;
        this.email = email;
        this.passwordUtente = passwordUtente;
        this.nome = nome;
        this.cognome = cognome;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordUtente() {
        return passwordUtente;
    }

    public void setPasswordUtente(String passwordUtente) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        byte[] hashedPwd = digest.digest(passwordUtente.getBytes(StandardCharsets.UTF_8));
        StringBuilder builder = new StringBuilder();
        for(byte bit: hashedPwd){
            builder.append(String.format("%02x", bit));
        }
        this.passwordUtente = builder.toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    private int id;
    private String email, passwordUtente, nome, cognome;
    private boolean isAdmin;
}
