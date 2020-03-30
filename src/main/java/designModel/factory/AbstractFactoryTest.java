package designModel.factory;

// 抽象工厂类  定义不同的产品之间的标准，商务车
interface ICarA {
    public void drive();
}


// 抽象工厂类  定义不同的产品之间的标准 跑车族
interface ICarB {
    public void drive();
}

//具体产品类
class productAHongqi implements ICarA {
    @Override
    public void drive() {
        System.out.println("开商务族--红旗车");
    }
}

//具体工厂类
class productABmw implements ICarA {
    @Override
    public void drive() {
        System.out.println("开商务族--宝马车 ...");
    }
}

//具体产品类
class producSporttBAudi implements ICarB {
    @Override
    public void drive() {
        System.out.println("开跑车族--奥迪车...");
    }
}


//具体工厂类
class productSportBBenz implements ICarB {
    @Override
    public void drive() {
        System.out.println("开跑车族--奔驰车 ...");
    }
}


/**
 * 抽象工厂类 创建跑车族跑车
 * @author Administrator
 *
 */
abstract class abstractoryFactory1 {
    abstract ICarB getProductBBenz();
    abstract ICarB getProductBAudi();
}


/**
 * 抽象工厂类  创建商务族跑车
 * @author Administrator
 *
 */
abstract class abstractoryFactory2 {
    abstract ICarA getProductABmw();
    abstract ICarA getProductBHongqi();
}


/**
 * 具体工厂类 跑车族
 * @author Administrator
 *
 */
class Factory1 extends abstractoryFactory1 {

    @Override
    ICarB getProductBBenz() {
        return new productSportBBenz();
    }

    @Override
    ICarB getProductBAudi() {
        return new producSporttBAudi();
    }
}


/**
 * 具体工厂类
 * 商务族
 * @author Administrator
 *
 */
class Factory2 extends abstractoryFactory2 {
    @Override
    ICarA getProductABmw() {
        return new productABmw();
    }

    @Override
    ICarA getProductBHongqi() {
        return new productAHongqi();
    }
}


public class AbstractFactoryTest {
    public static void main(String[] args) {
        //工厂一制造的产品族车
        abstractoryFactory1 factory1 = new Factory1();
        ICarB productsportAbenz = factory1.getProductBBenz();
        ICarB productsportBaudi = factory1.getProductBAudi();

        productsportAbenz.drive();
        productsportBaudi.drive();
        //工厂二制造的产品族车
        abstractoryFactory2 factory2 = new Factory2();
        ICarA productAbmw = factory2.getProductABmw();
        ICarA productBhongqi = factory2.getProductBHongqi();
        productAbmw.drive();
        productBhongqi.drive();
    }
}
