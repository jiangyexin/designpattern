package com.jyx.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiangyexin
 * Date: 2018-08-18
 * Time: 22:04
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    public MyRemoteImpl() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        System.out.println("service impl say");
        return "server say hello to client";
    }

    public static void main(String[] args) {
        try{
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("HelloRemote", service);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
