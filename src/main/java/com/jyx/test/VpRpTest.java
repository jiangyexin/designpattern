package com.jyx.test;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-08-21 11:37
 **/
public class VpRpTest {
    public static void main(String[] args){
        V v1 = new V();
        v1.i = 10;
        handler(v1,30);
        System.out.println("v1:"+v1.i);
    }
    public static void handler(V v,int i){
        v.i = i;
        V v8 = new V();
        v = v8;
        System.out.println(v.i);
    }
}
class V{
    public int i = 1;
}
