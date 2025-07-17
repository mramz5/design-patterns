package patterns.creational.builder;

public abstract class Part {}
class Engine extends Part{}
class Body extends Part{}
class SteeringWheel extends Part{}

abstract class AbstractCar{
    private Engine engine;
    private Body body;
    private SteeringWheel steeringWheel;
    private int wheels;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public void setSteeringWheel(SteeringWheel steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

}
class SportCar extends AbstractCar{}
class PersonalCar extends AbstractCar{}
