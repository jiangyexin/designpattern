package com.jyx.design.pattern.adapter;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2019-06-04 21:46
 **/
public class Adapter {
    public static void main(String[] args)
    {
        System.out.println("类适配器模式测试：");
        Target target = new ClassAdapter();
        target.request();
    }
}

//目标接口
interface Target
{
    void request();
}
//适配者接口
class Adaptee
{
    public void specificRequest()
    {
        System.out.println("适配者中的业务代码被调用！");
    }
}
//类适配器类
class ClassAdapter extends Adaptee implements Target
{
    @Override
    public void request()
    {
        specificRequest();
    }
}
