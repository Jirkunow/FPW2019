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
    private int idValu;
    private int idArt;
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

    /**
     * @return the idValu
     */
    public int getIdValu() {
        return idValu;
    }

    /**
     * @param idValu the idValu to set
     */
    public void setIdValu(int idValu) {
        this.idValu = idValu;
    }

    /**
     * @return the idArt
     */
    public int getIdArt() {
        return idArt;
    }

    /**
     * @param idArt the idArt to set
     */
    public void setIdArt(int idArt) {
        this.idArt = idArt;
    }
    
   
}
