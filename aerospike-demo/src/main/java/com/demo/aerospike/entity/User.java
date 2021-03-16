package com.demo.aerospike.entity;

import org.springframework.data.annotation.Id;
import java.io.Serializable;
import java.util.HashMap;

public class User implements Serializable {

    @Id
    private String id;


    private HashMap<String, String> eUserIds = new HashMap();

    private String envelope;

    private String testString;

    private String testString2;

    private String testString3;

    public User(String id, HashMap<String, String> eUserIds) {
        this.id = id;
        this.eUserIds = eUserIds;
    }

    public void seteUserIds(HashMap<String, String> eUserIds) {
        this.eUserIds = eUserIds;
    }

    public String getId() {
        return id;
    }

    public HashMap<String, String>  getEUserIds() {
        return eUserIds;
    }

    public String getEnvelope() {
        return envelope;
    }

    public void setEnvelope(String envelope) {
        this.envelope = envelope;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    public String getTestString2() {
        return testString2;
    }

    public void setTestString2(String testString2) {
        this.testString2 = testString2;
    }

    public String getTestString3() {
        return testString3;
    }

    public void setTestString3(String testString3) {
        this.testString3 = testString3;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", envelope='" + envelope + '\'' +
                ", testString='" + testString + '\'' +
                ", testString2='" + testString2 + '\'' +
                ", testString3='" + testString3 + '\'' +
                ", eUserIds=" + eUserIds +
                '}';
    }
}