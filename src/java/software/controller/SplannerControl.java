/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software.controller;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import software.model.Splanner;

/**
 *
 * @author asem
 */
public class SplannerControl { 
    Splanner sp=new Splanner();
    DBConnection db ;
    public SplannerControl (){
        db = new DBConnection();
        Splanner sp =new Splanner();
    }
    
    
    
    public void insertSplanner (){
        Session session= db.sessionfactory.openSession(); 
        session.beginTransaction();
        session.save(sp);
        session.getTransaction().commit();
        session.close();
     
    } 
    public ArrayList<Splanner> getSplannerData (){
    ArrayList<Splanner> sp = new ArrayList<>();
    Session session = db.sessionfactory.openSession();
    Query query = (Query) session.createQuery("from Splanner");
    sp = (ArrayList<Splanner>) query.list();
    for (int i = 0; i < sp.size(); i++) {
         System.out.println(sp.get(i).getSPlan_id ());
        }
    
    return sp ;
    } 
        public void updateSplanner(int  SPlan_id, Splanner newcontent) {
        Session session = db.sessionfactory.openSession();
        session.beginTransaction();
        Splanner usr = (Splanner) session.get(Splanner.class,SPlan_id);
        usr.setContent(newcontent.getContent());
        session.save(usr);
        session.getTransaction().commit();
        session.close();
        
    }
          
    public void deleteSplan(int Splan_id) {
        Session session = db.sessionfactory.openSession();
        session.beginTransaction();
        Splanner usr = (Splanner) session.get(Splanner.class, Splan_id);
        session.delete(usr);
        session.getTransaction().commit();
        session.close();
        
    }
    
}
