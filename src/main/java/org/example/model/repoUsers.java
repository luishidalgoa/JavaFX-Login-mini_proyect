package org.example.model;

import org.example.Utils.XMLManager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class repoUsers {
    @XmlTransient
    private static repoUsers _instance;
    private ArrayList<User> users=new ArrayList<>();

    public repoUsers() {
        users=new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }
    public boolean addUser(User u){
        for(User aux:users){
            if(u.equals(aux)){
               return false;
            }
        }
        users.add(u);
        return true;
    }
    public static repoUsers get_instance() {
        if(_instance==null){
            _instance=new repoUsers();
        }
        return _instance;
    }
    public static void set_instance(repoUsers aux){
        _instance=aux;
    }
}
