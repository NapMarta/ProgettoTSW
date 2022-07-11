package model.beans;


import java.io.InputStream;

public class Prodotto {

    public Prodotto() {
        this.immagine = null;
    }

    public Prodotto(int codice, String nome, String tipologia, String descrizione,
                    double prezzo, InputStream immagine) {
        this.codice = codice;
        this.nome = nome;
        this.tipologia = tipologia;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.immagine = immagine;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public InputStream getImmagine() {
        return immagine;
    }

    public void setImmagine(InputStream immagine) {
        this.immagine = immagine;
    }

    private int codice;
    private String nome, tipologia, descrizione;
    private double prezzo;
    private InputStream immagine;
}
