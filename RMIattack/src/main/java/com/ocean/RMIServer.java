package com.ocean;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        IRemoteObj iRemoteObj = new IRemoteObjImpl();

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("RmiDemo",iRemoteObj);

    }

}
