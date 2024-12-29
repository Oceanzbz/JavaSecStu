package com.ocean;

import com.thoughtworks.xstream.XStream;

public class Xstream_stu {
    public static void main(String[] args) {
        XStream xStream = new XStream();
        Person person = new Person("ocean", 19, new Company("zzzz", "shandong"));
        String xml = xStream.toXML(person);
        //System.out.println(xml);

        Object o = xStream.fromXML(xml);
        System.out.println(o);
    }
}
