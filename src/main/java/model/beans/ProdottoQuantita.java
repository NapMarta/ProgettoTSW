package model.beans;

import java.io.InputStream;

public class ProdottoQuantita extends Prodotto {

    public ProdottoQuantita(){
        super();
    }

    public ProdottoQuantita(int codice, String nome, String tipologia, String descrizione,
                             double prezzo, InputStream immagine, int quantita){
        super(codice, nome, tipologia, descrizione, prezzo, immagine);
        this.quantita = quantita;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    private int quantita;
}
