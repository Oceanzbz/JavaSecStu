package com.ocean;


public class User {
    String name;
    int age;
    int id;
    public User() {
        System.out.println("无参构造");
    }
    public User(String name, int age, int id) {
        System.out.println("有参构造");
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        System.out.println("get name");
        return name;
    }

    public void setName(String name) {
        System.out.println("set name");
        this.name = name;
    }

    public int getAge() {
        System.out.println("getage");
        return age;
    }

    public void setAge(int age) {
        System.out.println("set age");
        this.age = age;
    }

    public int getId() {
        System.out.println("get id");
        return id;
    }

    public void setId(int id) {
        System.out.println("set id");
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
