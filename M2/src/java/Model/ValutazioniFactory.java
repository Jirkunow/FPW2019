/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gznag
 */
public class ValutazioniFactory {
    
     private static ValutazioniFactory singleton;

    private ValutazioniFactory(){
        
    }
    
    public static ValutazioniFactory getInstance(){
        if(singleton == null){
            singleton = new ValutazioniFactory();
        }
        
        return singleton;
    }
    
    public List<Valutazioni> getValutazioni(){
        List<Valutazioni> valutazioni = new ArrayList<>();
        
        Valutazioni u1 = new Valutazioni();
        u1.setCommentoAutori("Molto bello");
        u1.setCommentoOrganizzatori("Molto valido");
        u1.setVoto(8);
        
        Valutazioni u2 = new Valutazioni();
        u2.setCommentoAutori("Non molto realistico");
        u2.setCommentoOrganizzatori("Controllare questa gente");
        u2.setVoto(4);
        
        
        return valutazioni;
    }
    
    
}
