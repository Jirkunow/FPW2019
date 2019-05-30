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
public class UserFactory {
    
    
    private static UserFactory singleton;
    //private ArrayList<Utente> usersList = new ArrayList<Utente>();

    private UserFactory() {

    }

    public static UserFactory getInstance() {
        if (singleton == null) {
            singleton = new UserFactory();
        }
        return singleton;
    }

    public ArrayList<User> getAllUsers() {
        DbConnection connectFactory = DbConnection.getInstance();
        Connection conn = connectFactory.getConnection();
        ArrayList<User> usersList = new ArrayList<User>();

        try {

            //Sintassi sql contro sql injection
            String sql = "select * from user";
            Statement stmt = conn.createStatement();

            ResultSet set = stmt.executeQuery(sql);

            //Se la query mi ha restituito con successo l'utente
            while (set.next()) {
                User u = new User();
                u.setNome(set.getString("nome"));
                u.setEmail(set.getString("email"));

                usersList.add(u);
            }

            //Chiudo la connessione
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
        }

        return usersList;
    }

    public boolean login(String usr, String psw) {
        DbConnection connFact = DbConnection.getInstance();
        Connection conn = connFact.getConnection();

        boolean is_logged = false;

        try {

            //Sintassi sql contro sql injection
            String sql = "select * from utente where email = ? and password = ? ";
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, usr);
            stmt.setString(2, psw);

            ResultSet set = stmt.executeQuery();

            //Se la query mi ha restituito con successo l'utente
            while (set.next()) {
                is_logged = true;
            }

            //Chiudo la connessione
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        //L'utente con username urs e password psw non esiste
        return is_logged;
    }

    public User getUser(String usr, String psw) {  
        DbConnection connFact = DbConnection.getInstance();
        
        
        Connection conn = connFact.getConnection();
        User u=null;
        try {

            //Sintassi sql contro sql injection
            String sql = "select * from utente where email = ? and password = ? ";
            PreparedStatement stmt;
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, usr);
            stmt.setString(2, psw);

            ResultSet set = stmt.executeQuery();

            //Se la query mi ha restituito con successo l'utente
            while (set.next()) {
                u = new User();
                u.setID(set.getInt("id"));
                u.setNome(set.getString("nome"));
                u.setCognome(set.getString("cognome"));
                u.setEmail(set.getString("email"));
                u.setEnte(set.getString("ente"));
                u.setAutore(set.getString("autore"));
            }

            //Chiudo la connessione
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
        }
        //L'utente con username urs e password psw non esiste
        return u;
    }

    public boolean removeUser(int idUser) {
        Connection conn = null;
        try {
            DbConnection connFact = DbConnection.getInstance();
            conn = connFact.getConnection();

            conn.setAutoCommit(false);

            //Query relativa alla rimozione dei suoi libri
            String sql0 = "delete from articolo where autore = ?";
            PreparedStatement remL = conn.prepareStatement(sql0);
            remL.setInt(1, idUser);
            remL.executeUpdate();

            //Query relativa alla rimozione dell'utente
            String sql = "delete from user where id = ?";
            PreparedStatement remU = conn.prepareStatement(sql);

            remU.setInt(1, idUser);

            remU.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);

            //Chiudo la connessione
            remU.close();
            remL.close();
            conn.close();
            return true;

        } catch (SQLException e) {
            Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, e);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException eR) {
                    Logger.getLogger(UserFactory.class.getName()).log(Level.SEVERE, null, eR);
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
