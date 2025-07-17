package patterns.creational.prototype;

import java.util.Hashtable;

public class Challenge {
    public static void main(String[] args) {
    }
}

abstract class BasicCar implements Cloneable{
    protected String model;
    protected float price;

    public BasicCar(float price) {
        this.price = price;
    }

    public BasicCar(String model, float price) {
        this.model = model;
        this.price = price;
    }

    public abstract BasicCar clone();

    @Override
    public String toString() {
        return "car is : " + model +
                " with price = " + price;
    }
}


class Nano extends BasicCar{
    public Nano(float price) {
        super(price);
    }

    public Nano(String model, float price) {
        super(model, price);
    }

    public Nano(Nano car){
        super(car.model,car.price);
    }

    public Nano clone(){return new Nano(this);}
}


class Ford extends BasicCar{
    public Ford(float price) {
        super(price);
    }
    public Ford(String model, float price) {
        super(model, price);
    }

    public Ford(Ford car){
        super(car.model,car.price);
    }

    @Override
    public BasicCar clone() {
        return new Ford(this);
    }
}

class CarCache{
    private CarCache(){}
    private static class CarCacheStatic{
        private static final CarCache carCache=new CarCache();
    }
    public static CarCache getInstance(){return CarCacheStatic.carCache;}
    private static final Hashtable<Integer,BasicCar> carLoader=new Hashtable<>();

    public static void load(){
        carLoader.put(1,new Ford("model1",1200));
        carLoader.put(2,new Ford("model2",5000));
        carLoader.put(3,new Ford("model0",900));
        carLoader.put(4,new Nano("model3",1970));
        carLoader.put(5,new Nano("model5",2310));
        carLoader.put(6,new Nano("model8",4590));
    }

    public BasicCar getCar(int id){
        return carLoader.get(id).clone();
    }
}