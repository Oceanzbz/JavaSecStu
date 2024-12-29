package com.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteObjImpl extends UnicastRemoteObject implements RemoteObj{
    protected RemoteObjImpl() throws RemoteException {
    }

    @Override
    public String SayHello() {
        System.out.println("Hello World!");
        return "Hello World!";
    }
}
