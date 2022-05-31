package model.beans;

import java.util.ArrayList;

public class Carrello {

    public Carrello() {
    }

    public Carrello(int codice, int idUtente, double totale, double sconto, int numeroProdotti, ArrayList<ProdottoQuantita> listaProdotti) {
        this.codice = codice;
        this.idUtente = idUtente;
        this.totale = totale;
        this.sconto = sconto;
        this.numeroProdotti = numeroProdotti;
        this.listaProdotti = listaProdotti;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public double getSconto() {
        return sconto;
    }

    public void setSconto(double sconto) {
        this.sconto = sconto;
    }

    public int getNumeroProdotti() {
        return numeroProdotti;
    }

    public void setNumeroProdotti(int numeroProdotti) {
        this.numeroProdotti = numeroProdotti;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public ArrayList<ProdottoQuantita> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(ArrayList<ProdottoQuantita> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    private int codice, idUtente;
    private double totale, sconto;
    private int numeroProdotti;
    private ArrayList<ProdottoQuantita> listaProdotti;
}
