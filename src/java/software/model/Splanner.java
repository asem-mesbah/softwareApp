/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author asem
 */
@Entity
@Table(name="Splanner")
public class Splanner {
    @Id
    private int SPlan_id ;
    private Date duration ;
    private String content ;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount user;

    public int getSPlan_id() {
        return SPlan_id;
    }

    public void setSPlan_id(int SPlan_id) {
        this.SPlan_id = SPlan_id;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
   
    
}
