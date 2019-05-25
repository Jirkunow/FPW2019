package Model;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gznag
 */
public class Articoli {
    ArrayList<String> autori;
    String data;
    String titolo;
    String categoria;
    String stato;
    Valutazioni valutazione;
    String immagine;
    String testo;
    static int totArt;
    int IdArt;
    
    
    
    public Articoli(){
        this.autori= new ArrayList();
        this.categoria = "0";
        this.data = "0";
        this.immagine = "0";
        this.stato = "0";
        this.testo = "0";
        this.titolo = "0";
        this.valutazione = new Valutazioni();
        this.IdArt = totArt;
        this.totArt++;
    }
    
    public void setAutore(String autore){
        this.autori.add(autore);
    }
    
    public String getAutore(int i){
        return this.autori.get(i);
    }
    
    public ArrayList getAutori(){
        return this.autori;
    }
    
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    
    public String getCategoria(){
        return categoria;
    }
    
    public void setData(String data){
        this.data = data;
    }
    
    public String getData(){
        return data;
    }
 
    public void setImmagine(String Immagine){
        this.immagine = immagine;
    }
    
    public String getImmagine(){
        return immagine;
    }
    
    public void setStato(String stato){
        this.stato = stato;
    }
    
    public String getStato(){
        return stato;
    }
    
    public void setTesto(String testo){
        this.testo = testo;
    }
    
    public String getTesto(){
        return testo;
    }
    
    public void setTitolo(String titolo){
        this.titolo = titolo;
    }
    
    public String getTitolo(){
        return titolo;
    }
    public void setValutazione(Valutazioni valutazione){
        this.valutazione = valutazione;
    }
    
    public Valutazioni getValutazione(){
        return valutazione;
    }
     /**
     * @return the IdArt
     */
    public String getIdArt() {
        Integer id = new Integer(this.IdArt);
        return id.toString();
    }

    /**
     * @param IdArt the IdArt to set
     */
    public void setIdArt(int IdArt) {
        this.IdArt = IdArt;
    }
}
