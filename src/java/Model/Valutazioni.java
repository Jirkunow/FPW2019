package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gznag
 */
public class Valutazioni {
    int voto;
    String commentoXautori;
    String commentoXorganizzatori;
    
    public Valutazioni(){
        this.voto= 0;
        this.commentoXorganizzatori="0";
        this.commentoXautori="0";
    }
    
    public int getVoto(){
        return voto;
    }
    public void setVoto(int voto){
        this.voto = voto;
    }
    
    public String getCommentoAutori(){
        return commentoXautori;
    }
    public void setCommentoAutori(String commento){
        this.commentoXautori = commento;
    }
    
    public String getCommentoOrganizzatori(){
        return commentoXorganizzatori;
    }
    public void setCommentoOrganizzatori(String commento){
        this.commentoXorganizzatori = commento;
    }
    
   
}
