package org.example.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Admin")
public final class Admin extends User{
    public Admin() {
    }

    public Admin(String username, String password, String dni,String WP) {
        super(username, password,dni,WP);
    }
}