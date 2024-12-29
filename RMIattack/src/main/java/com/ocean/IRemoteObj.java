package com.ocean;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteObj extends Remote {

    public Object RmiDemo() throws Exception;

}
