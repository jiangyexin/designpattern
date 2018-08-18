package com.jyx.rmi;

import java.rmi.Naming;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: jiangyexin
 * Date: 2018-08-18
 * Time: 22:10
 */
public class MyRemoteClient {
    public static void main(String[] args) {
        MyRemoteClient client = new MyRemoteClient();
        client.invoke();

    }

    public void invoke() {
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://localhost:8739/RemoteHello");
            String result = service.sayHello();
            System.out.println(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
