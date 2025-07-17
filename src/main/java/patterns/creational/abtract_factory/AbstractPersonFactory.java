package patterns.creational.abtract_factory;

public interface AbstractPersonFactory extends AbstractFactory{
    Person factoryMethod(String type);
}
