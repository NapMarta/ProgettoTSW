package model.beans;

import java.util.ArrayList;

public class ListaDeiDesideri {

    public ListaDeiDesideri() {
    }

    public ListaDeiDesideri(int idUtente, String nome, ArrayList<Prodotto> listaProdotti) {
        this.idUtente = idUtente;
        this.nome = nome;
        this.listaProdotti = listaProdotti;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(ArrayList<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    private int idUtente;
    private String nome;
    private ArrayList<Prodotto> listaProdotti;
}
