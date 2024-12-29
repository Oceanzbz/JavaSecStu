package com.ocean;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteObj extends Remote {
    String test() throws RemoteException;
    public Object RmiDemo() throws Exception;
}
