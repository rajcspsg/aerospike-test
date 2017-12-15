package com.demo.aerospike.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.HashMap;

public class User implements Serializable{

    @Id
    private String id;

    private HashMap<String, String> eUserIds = new HashMap();

    public User(String id, HashMap<String, String> eUserIds) {
        this.id = id;
        this.eUserIds = eUserIds;
    }

    public String getId() {
        return id;
    }

    public HashMap<String, String>  getEUserIds() {
        return eUserIds;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", eUserIds=" + eUserIds + "]";
    }

}
