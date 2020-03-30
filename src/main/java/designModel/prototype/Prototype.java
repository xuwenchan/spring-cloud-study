package designModel.prototype;

/*
* 原型设计模式
* 原型模式的定义：
* 用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。
* 在这里，原型实例指定了要创建的对象的种类。用这种方式创建对象非常高效，
* 根本无须知道对象创建的细节。例如，Windows 操作系统的安装通常较耗时，
* 如果复制就快了很多。
*
* 1. 模式的结构
    原型模式包含以下主要角色。
    抽象原型类：规定了具体原型对象必须实现的接口。
    具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。
    访问类：使用具体原型类中的 clone() 方法来复制新的对象。
* */

/*
* 原型模式的克隆分为浅克隆和深克隆，
* Java 中的 Object 类提供了浅克隆的 clone() 方法，
* 具体原型类只要实现 Cloneable 接口就可实现对象的浅克隆，
* 这里的 Cloneable 接口就是抽象原型类。其代码如下：
* */

/*
原型模式的应用实例
* 用原型模式模拟“孙悟空”复制自己。
分析：孙悟空拔下猴毛轻轻一吹就变出很多孙悟空，这实际上是用到了原型模式。这里的孙悟空类 SunWukong 是具体原型类，而 Java 中的 Cloneable 接口是抽象原型类。
* */
class Realizetype implements Cloneable{
    Realizetype(){
        System.out.println("具体原型类创建成功");
    }

    public Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功");
        return (Realizetype)super.clone();
    }
}


public class Prototype {
    public static void main(String[] args)throws CloneNotSupportedException
    {
        Realizetype obj1=new Realizetype();
        Realizetype obj2=(Realizetype)obj1.clone();
        System.out.println("obj1==obj2?"+(obj1==obj2));
    }

}
