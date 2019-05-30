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
public class ArticoliFactory {
    
   private static ArticoliFactory singleton;
    //private ArrayList<Utente> usersList = new ArrayList<Utente>();

    private ArticoliFactory() {

    }

    public static ArticoliFactory getInstance() {
        if (singleton == null) {
            singleton = new ArticoliFactory();
        }
        return singleton;
    }

    public ArrayList<Articoli> getAllArticoli() {
        DbConnection connectFactory = DbConnection.getInstance();
        Connection conn = connectFactory.getConnection();
        ArrayList<Articoli> usersList = new ArrayList<>();

        try {

            //Sintassi sql contro sql injection
            String sql = "select * from articolo";
            Statement stmt = conn.createStatement();

            ResultSet set = stmt.executeQuery(sql);

            //Se la query mi ha restituito con successo l'utente
            while (set.next()) {
                Articoli u = new Articoli();
                u.setIdArt(set.getInt("idArt"));
                u.setTitolo(set.getString("titolo"));
                u.setTesto(set.getString("testo"));
                u.setImmagine(set.getString("immagine"));
                u.setStato(set.getString("stato"));
                u.setData(set.getString("pubblicazione"));
                u.setCategoria(set.getString("categoria"));

                usersList.add(u);
            }

            //Chiudo la connessione
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(ArticoliFactory.class.getName()).log(Level.SEVERE, null, e);
        }

        return usersList;
    }

    public Articoli getArticolo(int idArt, String titolo) {  
        DbConnection connFact = DbConnection.getInstance();
        Connection conn = connFact.getConnection();
        Articoli u=null;
        try {

            //Sintassi sql contro sql injection
            String sql = "select * from articolo where idArt = ? and titolo = ? ";
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idArt);
            stmt.setString(2, titolo);

            ResultSet set = stmt.executeQuery();

            //Se la query mi ha restituito con successo l'utente
            while (set.next()) {
                u = new Articoli();
                u.setIdArt(set.getInt("idArt"));
                u.setTitolo(set.getString("titolo"));
                u.setTesto(set.getString("testo"));
                u.setImmagine(set.getString("immagine"));
                u.setStato(set.getString("stato"));
                u.setData(set.getString("pubblicazione"));
                u.setCategoria(set.getString("categoria"));
            }

            //Chiudo la connessione
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(ArticoliFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        //L'utente con username urs e password psw non esiste
        return u;
    }

    public boolean removeArticolo(int idArt) {
        Connection conn = null;
        try {
            DbConnection connFact = DbConnection.getInstance();
            conn = connFact.getConnection();

            conn.setAutoCommit(false);

            //Query relativa alla rimozione dei suoi libri
            String sql0 = "delete from articolo where idArt = ?";
            PreparedStatement remL = conn.prepareStatement(sql0);
            remL.setInt(1, idArt);
            remL.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);

            //Chiudo la connessione
            remL.close();
            conn.close();
            return true;

        } catch (SQLException e) {
            Logger.getLogger(ArticoliFactory.class.getName()).log(Level.SEVERE, null, e);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException eR) {
                    Logger.getLogger(ArticoliFactory.class.getName()).log(Level.SEVERE, null, eR);
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
