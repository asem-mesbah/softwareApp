/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software.controller;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import software.model.Post;

/**
 *
 * @author asem
 */
public class PostsControl {
      PostsControl pc=new PostsControl();
    DBConnection db ;
    public PostsControl (){
        db = new DBConnection();
        Post pc = new Post() ;
    }
       public void insertPost(Post  pc) {
        
        Session session = db.sessionfactory.openSession();
        session.beginTransaction();
        session.save(pc);
        session.getTransaction().commit();
        session.close();
    }
     public ArrayList<Post> getPostText() {
        
         ArrayList<Post> pc = new ArrayList<>();
        
        Session session = db.sessionfactory.openSession();
        Query query = (Query) session.createQuery("from Post");
        pc= (ArrayList<Post>) query.list();
        
        for (int i = 0; i < pc.size(); i++) {
            System.out.println(pc.get(i).getPost_text());
         
        }
        
        return pc;
    }
    public void updatePost(int post_id, Post newPost) {
        Session session = db.sessionfactory.openSession();
        session.beginTransaction();
        
        Post po = (Post) session.get(Post.class, post_id);
        
        po.setPost_text(newPost.getPost_text());
        
        session.save(po);
        session.getTransaction().commit();
        session.close();
        
    }
     public void deletPost(int post_id) {
        Session session = db.sessionfactory.openSession();
        session.beginTransaction();
        
        Post po = (Post) session.get(Post.class, post_id);
        
        session.delete(po);
        
        session.getTransaction().commit();
        session.close();
        
    }
    
    
    
    
    
    
}
