/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author asem
 */
@Entity
@Table(name = "UserAccount")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserAccount implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String userName;
    @Column(unique = true, length = 70, nullable = false)
    private String Email;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Groups.class)
    @JoinTable(name = "group_members", joinColumns = {
        @JoinColumn(name = "user_id")}, inverseJoinColumns = {
        @JoinColumn(name = "group_id")})
    List<Groups> grps = new ArrayList();

    @ManyToMany
    @JoinTable(name = "user_friends", joinColumns = {
        @JoinColumn(name = "user_id")}, inverseJoinColumns = {
        @JoinColumn(name = "friend_id")})
    List<UserAccount> friends = new ArrayList();

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = UserAccount.class)
    @JoinTable(name = "post_tags", joinColumns = {
        @JoinColumn(name = "user_id")}, inverseJoinColumns = {
        @JoinColumn(name = "post_id")})
    List<Post> user_tags = new ArrayList();

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
