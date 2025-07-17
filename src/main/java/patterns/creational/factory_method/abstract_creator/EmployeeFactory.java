package patterns.creational.factory_method.abstract_creator;

import patterns.creational.factory_method.abstract_creator.products.Employee;

import java.util.Random;

public class EmployeeFactory extends PersonFactory {
    @Override
    protected Employee factoryMethod() {
        return new Employee(new Random().nextInt(32)+1,"EMPLOYEE");
    }
}
