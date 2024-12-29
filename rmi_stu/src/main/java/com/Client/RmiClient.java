package com.Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import com.Server.RemoteObj;

public class RmiClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        RemoteObj remoteObj = (RemoteObj)registry.lookup("remoteObj");
        String s = remoteObj.SayHello();
        System.out.println(s);
    }
}
