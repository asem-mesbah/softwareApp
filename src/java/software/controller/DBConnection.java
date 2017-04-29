/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software.controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author asem
 */
public class DBConnection {

  public static SessionFactory sessionfactory;

    public DBConnection() {

        sessionfactory = new Configuration().configure().buildSessionFactory();

    }

    public void getSessionFactory() {
        if (sessionfactory.isClosed()) {
            sessionfactory = new Configuration().configure().buildSessionFactory();
        }
    }

    public void closeSessionFactory() {
        sessionfactory.close();
    }
    
    
    public static void main(String[] args) {
        new DBConnection();
        
        sessionfactory.close();
    }
    
    

}
