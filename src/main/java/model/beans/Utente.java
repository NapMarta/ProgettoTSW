package model.beans;

public class Utente {

    public Utente() {
    }

    public Utente(int id, String email, String passwordUtente, String nome, String cognome) {
        this.id = id;
        this.email = email;
        this.passwordUtente = passwordUtente;
        this.nome = nome;
        this.cognome = cognome;
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

    public void setPasswordUtente(String passwordUtente) {
        this.passwordUtente = passwordUtente;
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

    private int id;
    private String email, passwordUtente, nome, cognome;
}
