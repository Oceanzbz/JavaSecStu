package com.ocean;


import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(2222);
        registry.lookup("sss");
//        String[] list = registry.list();
//        for (String i : list) {
//            System.out.println("已经注册的服务：" + i);
//        }
//        IRemoteObj rmiDemo = (IRemoteObj)registry.lookup("RmiDemo");
//        rmiDemo.RmiDemo();


    }
}
