package model.beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Ordine {

    public Ordine() {
    }

    public Ordine(int codice, int idUtente, String tipologia, String tipoPagamento,
                  double sconto, double totale, Date dataPagamento, ArrayList<ProdottoQuantita> listaProdotti) {
        this.codice = codice;
        this.idUtente = idUtente;
        this.tipologia = tipologia;
        this.tipoPagamento = tipoPagamento;
        this.sconto = sconto;
        this.totale = totale;
        this.dataPagamento = dataPagamento;
        this.listaProdotti = listaProdotti;
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

    public double getSconto() {
        return sconto;
    }

    public void setSconto(double sconto) {
        this.sconto = sconto;
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

    private int codice, idUtente;
    private String tipologia, tipoPagamento;
    private double sconto, totale;
    private Date dataPagamento;
    private ArrayList<ProdottoQuantita> listaProdotti;
}
