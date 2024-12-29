package com.ocean;
import java.io.IOException;
import java.io.Serializable;

public class User implements Serializable {
    public User() {
    }

    public Object getName() throws IOException {
        Runtime.getRuntime().exec("open -a Calculator");
        return "1";
    }

    public Object setName(String name) {
        System.out.println("setname");
        return "2";
    }
}
