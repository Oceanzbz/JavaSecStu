package com.ocean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class stujackson {
    public static void main(String[] args) throws IOException {


        Person person = new Person();
        zbz zbz = new zbz();
        person.object = zbz;
        //person.address = new addressImpl();

//        String s = objectMapper.writeValueAsString(person);
//        System.out.println(s);
        ObjectMapper objectMapper = new ObjectMapper();
        Person person1 = objectMapper.readValue("{\"age\":0,\"name\":null,\"object\":{\"@class\":\"com.ocean.zbz\",\"cmd\":\"open -a Calculator\"},\"address\":null,\"zbz\":null}", Person.class);
        System.out.println(person1);

        //设置NON_CONCRETE_AND_ARRAYS
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//
//        String json = objectMapper.writeValueAsString(person);
//        System.out.println(json);

        //设置NON_CONCRETE_AND_ARRAYS
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_CONCRETE_AND_ARRAYS);
//
//        String json = objectMapper.writeValueAsString(ocean);
//        System.out.println(json);




        // 设置JAVA_LANG_OBJECT
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
//
//        String json = objectMapper.writeValueAsString(ocean);
//        System.out.println(json);
        //OBJECT_AND_NON_CONCRETE
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
//
//        String json = objectMapper.writeValueAsString(ocean);
//        System.out.println(json);

        //序列化
//        String s = objectMapper.writeValueAsString(ocean);
//        System.out.println(s);
        //反序列化
//        String jack = "{\"age\":22,\"name\":\"zbz\"}";
//        Person person = objectMapper.readValue(jack, Person.class);
//        System.out.println(person.getAge());



    }
}
