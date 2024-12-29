package com.ocean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.jws.soap.SOAPBinding;


public class FastjsonStu {
    public static void main(String[] args) {
        //将一个java对象序列化为json字符串
        User ocean = new User("ocean", 22, 123456);

        System.out.println(JSON.toJSONString(ocean));
//        //将一个json字符传反序列化为 java对象
//        //json字符串还原位对象的两种方法：
//        //这里使用parse会将jsonstring反序列化成json对象
//        Object parse = JSON.parse(jsonString);
//        System.out.println(parse.getClass().getName());
//        //这里使用paseObject会将jsonstring反序列化成json对象
//        JSONObject jsonObject = JSON.parseObject(jsonString);
//        System.out.println(jsonObject.getClass().getName());
//        //使用parseObject将json字符串反学列化成指定的java对象
//        User user = JSON.parseObject(jsonString, User.class);
//        System.out.println(user);
//        String jsonString1 = JSON.toJSONString(ocean, SerializerFeature.WriteClassName);
//        System.out.println(jsonString1);
//        //parse反序列化
//        Object parse1 = JSON.parse(jsonString1);
//        System.out.println(parse1);
//        //parseObject反序列化
//        JSONObject jsonObject1 = JSON.parseObject(jsonString1);
//        System.out.println(jsonObject1);


    }
}
