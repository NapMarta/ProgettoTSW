package model.beans;

import java.util.ArrayList;

public class Carrello {

    public Carrello() {
        this.codice = 0;
    }

    public Carrello(int codice, int idUtente, double totale, int numeroProdotti, ArrayList<ProdottoQuantita> listaProdotti) {
        this.codice = codice;
        this.idUtente = idUtente;
        this.totale = totale;
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

    public double calcolaTotale(){
        double totale = 0;
        for (ProdottoQuantita prodottoQuantita: listaProdotti) {
            totale += prodottoQuantita.getPrezzo() * prodottoQuantita.getQuantita();
        }

        this.totale = totale;
        return totale;
    }

    public int calcolaNumeroProdotti(){
        int num = 0;
        for (ProdottoQuantita prodottoQuantita: listaProdotti) {
            num += 1 * prodottoQuantita.getQuantita();
        }

        this.numeroProdotti = numeroProdotti;
        return num;
    }

    private int codice, idUtente;
    private double totale;
    private int numeroProdotti;
    private ArrayList<ProdottoQuantita> listaProdotti;
}
