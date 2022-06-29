package model.beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Ordine {

    public Ordine() {
    }

    public Ordine(int codice, int idUtente, String tipologia, String tipoPagamento, double totale,
                  Date dataPagamento, String numeroCarta, ArrayList<ProdottoQuantita> listaProdotti,
                  String via, String cap, String citta) {
        this.codice = codice;
        this.idUtente = idUtente;
        this.tipologia = tipologia;
        this.tipoPagamento = tipoPagamento;
        this.totale = totale;
        this.dataPagamento = dataPagamento;
        this.listaProdotti = listaProdotti;
        this.numeroCarta = numeroCarta;
        this.citta = citta;
        this.via = via;
        this.cap = cap;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public ArrayList<ProdottoQuantita> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(ArrayList<ProdottoQuantita> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    public String getNumeroCarta() {
        return numeroCarta;
    }

    public void setNumeroCarta(String numeroCarta) {
        this.numeroCarta = numeroCarta;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    private int codice, idUtente;
    private String tipologia, tipoPagamento, numeroCarta, via, cap, citta;
    private double totale;
    private Date dataPagamento;
    private ArrayList<ProdottoQuantita> listaProdotti;
}
