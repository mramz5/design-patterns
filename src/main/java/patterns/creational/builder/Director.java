package patterns.creational.builder;

public class Director {
    public void build(Builder builder){
        builder.setBody(new Body());
        builder.setEngine(new Engine());
        builder.setWheels(4);
        builder.setSteeringWheel(new SteeringWheel());
    }
}
