package org.example.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public final class Admin extends User{
    public Admin() {
    }

    public Admin(String username, String password) {
        super(username, password);
    }
}
