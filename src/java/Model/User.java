package Model;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gznag
 */
public class User {
    
    private String nome;
    private String cognome;
    private ArrayList<Articoli> articoli ;
    private String foto;
    private String email;
    private String password;
    private String ente;
    private String autore;
    
    public User(){
        this.nome = "0";
        this.cognome = "0";
        this.articoli = new ArrayList();
        this.foto = "0";
        this.email = "0";
        this.password = "0";
        this.ente = "0";
        this.autore = "0";              
    }
    
    public void setArticoli(Articoli articoli){
        this.articoli.add(articoli);
    }
    
    public ArrayList<Articoli> getArticoliAll(){
        return this.articoli;
    }
    
    public Articoli getArticoli(int i){
        return this.articoli.get(i);
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setCognome(String cognome){
        this.cognome = cognome;
    }
    
    public String getCognome(){
        return cognome;
    }
    public void setFoto(String foto){
        this.foto = foto;
    }
    
    public String getFoto(){
        return foto;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setEnte(String ente){
        this.ente = ente;
    }
    
    public String getEnte(){
        return ente;
    }
    
    public void setAutore(String autore){
        this.autore = autore;
    }
    
    public String getAutore(){
        return autore;
    }
    
}
