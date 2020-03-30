package designModel.singleton;

public class LazySingleton {
    //懒汉式单例,多线程情况下，线程安全的单例模式
    private static volatile LazySingleton instance=null;//保证instance在所有线程中同步
    //私有构造方法
    private LazySingleton(){

    }

    public static synchronized LazySingleton getInstance(){
        if(instance==null){
            instance=new LazySingleton();
        }
        return instance;
    }

}

class HungrySingleton{
    private static final HungrySingleton instance=new HungrySingleton();
    //私有构造函数
    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return instance;
    }
}
