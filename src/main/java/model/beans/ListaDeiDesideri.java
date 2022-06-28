package model.beans;

import java.util.ArrayList;

public class ListaDeiDesideri {

    public ListaDeiDesideri() {
    }

    public ListaDeiDesideri(int idUtente, ArrayList<Prodotto> listaProdotti) {
        this.idUtente = idUtente;
        this.listaProdotti = listaProdotti;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public ArrayList<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public void setListaProdotti(ArrayList<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    private int idUtente;
    private ArrayList<Prodotto> listaProdotti;
}
