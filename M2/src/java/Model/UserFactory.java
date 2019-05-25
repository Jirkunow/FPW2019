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
public class UserFactory {
    
    private static UserFactory singleton;

    private UserFactory(){
        
    }
    
    public static UserFactory getInstance(){
        if(singleton == null){
            singleton = new UserFactory();
        }
        
        return singleton;
    }
    
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        
        List<Articoli> articoli = new ArrayList();
        articoli = ArticoliFactory.getInstance().getArticoli();
         
        User u1 = new User();         
        u1.setArticoli(articoli.get(0));
        u1.setNome("Davide");
        u1.setCognome("Spano");
        u1.setEmail("davide.spano@unica.it");
        u1.setPassword("ciao");
        u1.setAutore("0");
        u1.setEnte("Università di Casteddu");
        u1.setFoto("No foto grazie");
        users.add(u1);
        
        User u2 = new User();
        u2.setNome("Pinco");
        u2.setCognome("Pallino");
        u2.setEmail("pinco.pallino@gmail.com"); 
        u2.setPassword("hello");
        u2.setArticoli(articoli.get(1));
        u2.setArticoli(articoli.get(2));
        u2.setAutore("si");
        u2.setEnte("Università di Pallonia");
        u2.setFoto("No foto grazie");
        users.add(u2);
        
        return users;
    }
    
    public User getUser(String email, String password){
        List<User> users = this.getUsers();
        for(User u : users){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                return u;
            }
        }
        
        return null; 
    }
}
