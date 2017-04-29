/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author asem
 */
@Entity
@Table
public class Comments {

    @Id
    private int comment_id;

    private String content;

    @OneToOne
    @JoinColumn(name = "post_id")
    private Post post_id;

    @ManyToOne
    @JoinColumn(name = "user_id")

    private UserAccount user_id;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
