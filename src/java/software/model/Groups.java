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
import javax.persistence.Table;

/**
 *
 * @author asem
 */
@Entity
@Table(name = "Groups")
public class Groups {

    @Id
    private int group_id;
    private String group_name;
    private String group_type;
    private String GData_creation;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = UserAccount.class)
    @JoinTable(name = "group_members", joinColumns = {
        @JoinColumn(name = "group_id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id")
    })
    List<UserAccount> users = new ArrayList();

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getGroup_type() {
        return group_type;
    }

    public void setGroup_type(String group_type) {
        this.group_type = group_type;
    }

    public String getGData_creation() {
        return GData_creation;
    }

    public void setGData_creation(String GData_creation) {
        this.GData_creation = GData_creation;
    }

}
