 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author gznag
 */
public class ValutazioniFactory {
    
    private static ValutazioniFactory singleton;
    //private ArrayList<Utente> usersList = new ArrayList<Utente>();

    private ValutazioniFactory() {

    }

    public static ValutazioniFactory getInstance() {
        if (singleton == null) {
            singleton = new ValutazioniFactory();
        }
        return singleton;
    }

    public ArrayList<Valutazioni> getAllValutazioni() {
        DbConnection connectFactory = DbConnection.getInstance();
        Connection conn = connectFactory.getConnection();
        ArrayList<Valutazioni> usersList = new ArrayList<Valutazioni>();

        try {

            //Sintassi sql contro sql injection
            String sql = "select * from valutazioni";
            Statement stmt = conn.createStatement();

            ResultSet set = stmt.executeQuery(sql);

            //Se la query mi ha restituito con successo l'utente
            while (set.next()) {
                Valutazioni u = new Valutazioni();
                u.setIdValu(set.getInt("IdValu"));
                u.setIdArt(set.getInt("IdArt"));
                u.setCommentoAutori(set.getString("commentoAutori"));
                u.setCommentoOrganizzatori(set.getString("commentoOrganizzatori"));
                u.setVoto(set.getInt("voto"));

                usersList.add(u);
            }

            //Chiudo la connessione
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(ValutazioniFactory.class.getName()).log(Level.SEVERE, null, e);
        }

        return usersList;
    }

    public Valutazioni getValutazione(int idArt, int idValu) {  
        DbConnection connFact = DbConnection.getInstance();
        Connection conn = connFact.getConnection();
        Valutazioni u=null;
        try {

            //Sintassi sql contro sql injection
            String sql = "select * from valutazioni where idValu = ? and idArt = ? ";
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idArt);
            stmt.setInt(2, idValu);

            ResultSet set = stmt.executeQuery();

            //Se la query mi ha restituito con successo l'utente
            while (set.next()) {
                u = new Valutazioni();
                u.setIdValu(set.getInt("IdValu"));
                u.setIdArt(set.getInt("IdArt"));
                u.setCommentoAutori(set.getString("commentoAutori"));
                u.setCommentoOrganizzatori(set.getString("commentoOrganizzatori"));
                u.setVoto(set.getInt("voto"));
            }

            //Chiudo la connessione
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(ValutazioniFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        //L'utente con username urs e password psw non esiste
        return u;
    }

    public boolean removeValu(int idValu) {
        Connection conn = null;
        try {
            DbConnection connFact = DbConnection.getInstance();
            conn = connFact.getConnection();

            conn.setAutoCommit(false);

            //Query relativa alla rimozione dei suoi libri
            String sql0 = "delete from valutazioni where idValu = ?";
            PreparedStatement remL = conn.prepareStatement(sql0);
            remL.setInt(1, idValu);
            remL.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);

            //Chiudo la connessione
            remL.close();
            conn.close();
            return true;

        } catch (SQLException e) {
            Logger.getLogger(ValutazioniFactory.class.getName()).log(Level.SEVERE, null, e);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException eR) {
                    Logger.getLogger(ValutazioniFactory.class.getName()).log(Level.SEVERE, null, eR);
                }
            }
        }
        return false;
    }

    void testConnection() {
        DbConnection connectFactory = DbConnection.getInstance();
        Connection conn = connectFactory.getConnection();

        if (conn != null) {
            System.out.println("Connessione eseguita con successo");
        }
    }
    
    
}
