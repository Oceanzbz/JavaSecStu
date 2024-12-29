package com.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        RemoteObjImpl remoteObj = new RemoteObjImpl();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("remoteObj",remoteObj);


    }
}
