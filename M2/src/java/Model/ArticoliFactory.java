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
public class ArticoliFactory {
    
    private static ArticoliFactory singleton;

    private ArticoliFactory(){
        
    }
    
    public static ArticoliFactory getInstance(){
        if(singleton == null){
            singleton = new ArticoliFactory();
        }
        
        return singleton;
    }
    
    public List<Articoli> getArticoli(){
        List<Articoli> articoli = new ArrayList<>();
        
        Articoli u1 = new Articoli();
        u1.setAutore("Davide Spano");
        u1.setAutore("Giulio Golia");
        u1.setCategoria("SQL");
        u1.setData("2019/11/2");
        u1.setImmagine("Path img");
        u1.setStato("Da valutare");
        u1.setTesto("SQL injection è una tecnica di code injection, usata per attaccare applicazioni di gestione dati, con la quale vengono inserite delle stringhe di codice SQL malevole all'interno di campi di input in modo che queste ultime vengano poi eseguite (ad esempio per fare inviare il contenuto del database all'attaccante). L'SQL injection sfrutta le vulnerabilità di sicurezza del codice di un'applicazione, ad esempio quando l'input dell'utente non è correttamente filtrato da 'caratteri di escape' contenuti nelle stringhe SQL oppure non è fortemente tipizzato e viene eseguito inaspettatamente. L'SQL injection è più conosciuto come attacco per i siti web, ma è anche usato per attaccare qualsiasi tipo di database SQL.\n" +
"\n" +
"                        L'SQL injection permette agli attaccanti di effettuare spoof identify, modificare dati esistenti, causare repudiation issues come l'annullamento di transazioni o la modifica dei bilanci, permette di ottenere tutti i dati sul sistema, eliminare dati oppure fare in modo che non siano accessibili, e diventare amministratori del database server.\n" +
"\n" +
"                        In uno studio del 2012, è stato osservato che in media le applicazioni web ricevono 4 attacchi al mese, ed i rivenditori ricevono il doppio degli attacchi rispetto alle industrie.\n" +
"                    ");
        u1.setTitolo("La SQL injection");
        u1.setIdArt(0);
        articoli.add(u1);
        
        Articoli u2 = new Articoli();
       u2.setAutore("Pinco Pallino");
        u2.setAutore("Paul Ball");
        u2.setCategoria("Servlet");
        u2.setData("11/1/2019");
        u2.setImmagine("Path img");
        u2.setStato("Aperto");
        u2.setTesto("Alieni incapaci di sostenere un'invasione su larga scala, a causa del proprio numero ridotto, possono effettuare piuttosto delle incursioni, sfruttando lo shock della propria venuta per ispirare terrore. Altre storie su questo argomento vedono gli alieni condurre ricognizioni e missioni di avanscoperta per saggiare la risposta della popolazione umana e in particolare delle forze militari terrestri. Gli alieni cercheranno inoltre di scegliere bersagli isolati, quali zone desertiche o rurali degli Stati Uniti, come area per condurre dei test o per lo sbarco. Questo tipo di trama attribuisce migliori possibilità a piccoli gruppi, come la polizia locale o anche ordinari civili, di respingere gli invasori e di ritornare alla vita normale dopo l'evento.");
        u2.setTitolo("Guerra e alieni");
        u2.setIdArt(1);
        articoli.add(u2);
        
        Articoli u3 = new Articoli();
        u3.setAutore("Pinco Pallino");
        u3.setAutore("Paul ùùù");
        u3.setCategoria("php");
        u3.setData("10/1/2019");
        u3.setImmagine("Path img");
        u3.setStato("Aperto");
        u3.setTesto("Alieni incapaci di sostenere un'invasione su larga scala, a causa del proprio numero ridotto, possono effettuare piuttosto delle incursioni, sfruttando lo shock della propria venuta per ispirare terrore. Altre storie su questo argomento vedono gli alieni condurre ricognizioni e missioni di avanscoperta per saggiare la risposta della popolazione umana e in particolare delle forze militari terrestri. Gli alieni cercheranno inoltre di scegliere bersagli isolati, quali zone desertiche o rurali degli Stati Uniti, come area per condurre dei test o per lo sbarco. Questo tipo di trama attribuisce migliori possibilità a piccoli gruppi, come la polizia locale o anche ordinari civili, di respingere gli invasori e di ritornare alla vita normale dopo l'evento.");
        u3.setTitolo("Coltivare gioia");
        u1.setIdArt(3);
        articoli.add(u3);
        
        return articoli;
    }
    
    public Articoli getValutazioni(String artTit){
        List<Articoli> articoli = this.getArticoli();
        for(Articoli u : articoli){
            if(u.getTitolo().equals(artTit)){
                return u;
            }
        }
        
        return null; 
    }
    
}
