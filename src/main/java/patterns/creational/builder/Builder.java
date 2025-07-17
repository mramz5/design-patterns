package patterns.creational.builder;

public interface Builder {
    void setEngine(Engine engine);

    void setWheels(int numbers);

    void setBody(Body body);

    void setSteeringWheel(SteeringWheel steeringWheel);

    void reset();
}

//we did not used inheritance because maybe each class has its own logic
class SportCarBuilder implements Builder {
    SportCar sportCar = new SportCar();

    @Override
    public void setEngine(Engine engine) {
        sportCar.setEngine(engine);
    }

    @Override
    public void setWheels(int numbers) {
        sportCar.setWheels(numbers);
    }

    @Override
    public void setBody(Body body) {
        sportCar.setBody(body);
    }

    @Override
    public void setSteeringWheel(SteeringWheel steeringWheel) {
        sportCar.setSteeringWheel(steeringWheel);
    }

    @Override
    public void reset() {
        sportCar = new SportCar();
    }

    public AbstractCar getCar() {
        return sportCar;
    }
}

class PersonalCarBuilder implements Builder {
    private PersonalCar personalCar = new PersonalCar();

    @Override
    public void setEngine(Engine engine) {
        personalCar.setEngine(engine);
    }

    @Override
    public void setWheels(int numbers) {
        personalCar.setWheels(numbers);
    }

    @Override
    public void setBody(Body body) {
        personalCar.setBody(body);
    }

    @Override
    public void setSteeringWheel(SteeringWheel steeringWheel) {
        personalCar.setSteeringWheel(steeringWheel);
    }

    @Override
    public void reset() {
        personalCar=new PersonalCar();
    }

    public AbstractCar getCar() {
        return personalCar;
    }
}
