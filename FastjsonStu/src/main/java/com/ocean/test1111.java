package com.ocean;


import java.io.*;

import java.util.Base64;
import java.util.HashMap;

public class test1111 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HashMap<Object,Object> hashMap = new HashMap<>();
        hashMap.put("1","1");
        hashMap.put("2","2");
        String base64 = serial(hashMap);
        System.out.println(base64);
        deserial(Base64.getDecoder().decode(base64));
    }
    public static String serial(Object o) throws IOException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.close();

        String base64String = Base64.getEncoder().encodeToString(baos.toByteArray());
        return base64String;

    }
    public static void deserial(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        ois.readObject();
    }
}
