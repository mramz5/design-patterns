package patterns.creational.abtract_factory;

public interface AbstractDepartmentFactory extends AbstractFactory{
    Department factoryMethod(String type);
}


