package com.ocean;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class Person {
    public int age;
    public String name;

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    public Object object;
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    public address address;
    public zbz zbz;
    public Person(){
        System.out.println("per构造函数");
    }
    public Person(int age, String name,Object object,address address,zbz zbz) {
        this.age = age;
        this.name = name;
        this.object = object;
        this.address = address;
        this.zbz = zbz;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
