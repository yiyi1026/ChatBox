package com.huiyu.ChatBox.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "customer")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", unique = true)
    private String name;

    protected User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d, name='%s']", id, name);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
