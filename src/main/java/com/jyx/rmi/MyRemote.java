package com.jyx.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiangyexin
 * Date: 2018-08-18
 * Time: 22:03
 */
public interface MyRemote extends Remote {
    String sayHello() throws RemoteException;
}
