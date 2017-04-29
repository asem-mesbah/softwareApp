/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author asem
 */
@Entity
@Table(name = "Post")
public class Post {

    @Id
    private int post_id;
    private int group_id;
    private String post_data;
    private String post_text;
    private String post_image;
    private String video_url;
    private String post_type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount user_poster;

    @ManyToOne
    @JoinColumn(name = "grp_id")
    Groups grp_id;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = UserAccount.class)
    @JoinTable(name = "post_tags", joinColumns = {
        @JoinColumn(name = "post_id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id")})
    List<UserAccount> User_posts = new ArrayList();

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getPost_data() {
        return post_data;
    }

    public void setPost_data(String post_data) {
        this.post_data = post_data;
    }

    public String getPost_text() {
        return post_text;
    }

    public void setPost_text(String post_text) {
        this.post_text = post_text;
    }

    public String getPost_image() {
        return post_image;
    }

    public void setPost_image(String post_image) {
        this.post_image = post_image;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getPost_type() {
        return post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public UserAccount getUser_poster() {
        return user_poster;
    }

    public void setUser_poster(UserAccount user_poster) {
        this.user_poster = user_poster;
    }

}
