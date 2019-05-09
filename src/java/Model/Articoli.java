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
    String valutazione;
    String immagine;
    String testo;
    
    public Articoli(){
        this.autori= new ArrayList();
        this.categoria = "0";
        this.data = "0";
        this.immagine = "0";
        this.stato = "0";
        this.testo = "0";
        this.titolo = "0";
        this.valutazione = "0";
    }
    
    public void setAutore(String autore){
        this.autori.add(autore);
    }
    
    public String getAutore(int i){
        return this.autori.get(i);
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
    public void setValutazione(String valutazione){
        this.valutazione = valutazione;
    }
    
    public String getValutazione(){
        return valutazione;
    }
    
}
