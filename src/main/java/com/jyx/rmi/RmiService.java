package com.jyx.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiangyexin
 * Date: 2018-08-18
 * Time: 22:25
 */
public class RmiService {
    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            LocateRegistry.createRegistry(8739);
            Naming.bind("rmi://localhost:8739/RemoteHello", service);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
