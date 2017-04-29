/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software.controller;

import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import software.model.UserDetails;

/**
 *
 * @author asem
 */
public class userControl {
    
    DBConnection db;
    
    public userControl() {
        db = new DBConnection();
        
    }
    
    public void insertUserDetails(UserDetails ua) {
        
        Session session = db.sessionfactory.openSession();
        session.beginTransaction();
        session.save(ua);
        session.getTransaction().commit();
        session.close();
    }
    
    public ArrayList<UserDetails> getAllUsers() {
        
        ArrayList<UserDetails> users = new ArrayList<>();
        
        Session session = db.sessionfactory.openSession();
        Query query = (Query) session.createQuery("from UserDetails");
        users = (ArrayList<UserDetails>) query.list();
        
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getUserName());
        }
        
        return users;
    }
    
    public void updateUser(int userid, UserDetails newUser) {
        Session session = db.sessionfactory.openSession();
        session.beginTransaction();
        
        UserDetails usr = (UserDetails) session.get(UserDetails.class, userid);
        
        usr.setUserName(newUser.getUserName());
        
        session.save(usr);
        session.getTransaction().commit();
        session.close();
        
    }
    
    public void deleteUser(int userId) {
        Session session = db.sessionfactory.openSession();
        session.beginTransaction();
        
        UserDetails usr = (UserDetails) session.get(UserDetails.class, userId);
        
        session.delete(usr);
        
        session.getTransaction().commit();
        session.close();
        
    }
    
    public static void main(String[] args) {
        
        userControl uc = new userControl();
        UserDetails usrd = new UserDetails();
        usrd.setUserName("Hamada");
        usrd.setWork("jhkjhkhhjhjhk");
        usrd.setEmail("fhhhjkkhkkjjl");
        usrd.setBirth_date(new Date());
        usrd.setPhone_number(46545464);
        usrd.setEducation("fhjgdshhfdhjkl");
        
//        uc.updateUser(2, usrd);
//        
        
        uc.deleteUser(2);
        uc.getAllUsers();
        
    }
    
}
