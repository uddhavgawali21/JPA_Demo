package com.ud.JPA_Demo.entity;

import jakarta.persistence.*;

@Entity                      //To make this class as table
public class Student {

    @Id                     //make primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "f_name")          //To change column name in db
    private String name;
    private String city;
    private int age;

    public Student(){};

    public Student(int id,String name, String city, int age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
