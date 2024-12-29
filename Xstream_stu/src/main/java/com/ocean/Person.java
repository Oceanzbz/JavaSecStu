package com.ocean;

import java.io.IOException;
import java.io.Serializable;

public class Person implements Serializable {
    public String name;
    public int age;
    public Company company;

    public Person() {
    }

    public Person(String name, int age, Company company) {
        this.name = name;
        this.age = age;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
//    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
//        s.defaultReadObject();
//        System.out.println("Read People");
//    }

}
