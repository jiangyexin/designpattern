package com.jyx.test;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-08-21 13:00
 * 浅复制 —-只是拷贝了基本类型的数据，而引用类型数据，复制后也是会发生引用，我们把这种拷贝叫做“（浅复制）浅拷贝”，换句话说，浅复制仅仅是指向被复制的内存地址，如果原地址中对象被改变了，那么浅复制出来的对象也会相应改变。

深复制 —-在计算机中开辟了一块新的内存地址用于存放复制的对象。

 super.clone() 是浅拷贝

 实现深拷贝就是要把类中的引用类型也进行拷贝 并递归  实现真正意义上的深拷贝
 **/
public class CopyCloneTest {
    static class Body implements Cloneable{
        public Head head;
        public Body() {}
        public Body(Head head) {this.head = head;}

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Body newBody =  (Body) super.clone();
            newBody.head = (Head) head.clone();
            return newBody;
        }

    }
    static class Head implements Cloneable{
        public  Face face;

        public Head() {}
        public Head(Face face){this.face = face;}
        @Override
        protected Object clone() throws CloneNotSupportedException {
            //return super.clone();
            Head newHead = (Head) super.clone();
            newHead.face = (Face) this.face.clone();
            return newHead;
        }
    }

    static class Face implements Cloneable{
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
    public static void main(String[] args) throws CloneNotSupportedException {

        Body body = new Body(new Head());

        Body body1 = (Body) body.clone();

        System.out.println("body == body1 : " + (body == body1) );

        System.out.println("body.head == body1.head : " +  (body.head == body1.head));


    }
}
