package com.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteObj  extends Remote {
    public String SayHello() throws RemoteException;
}
