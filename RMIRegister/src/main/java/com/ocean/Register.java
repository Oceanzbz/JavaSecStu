package com.ocean;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class Register {
    public static void main(String[] args) throws RemoteException {
        LocateRegistry.createRegistry(1099);

    }
}
