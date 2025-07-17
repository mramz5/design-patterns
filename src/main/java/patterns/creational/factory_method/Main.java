package patterns.creational.factory_method;

import patterns.creational.factory_method.abstract_creator.products.Employee;
import patterns.creational.factory_method.static_method_creator.PersonFactory;

public class Main {
    public static void main(String[] args) {

        Employee employee = (Employee) PersonFactory.getPerson("EMPLOYEE");
        System.out.println(employee.getFullInfo());

    }
}
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//abstract class Product {
//    protected int id;
//    protected String name;
//    protected String model;
//    protected double price;
//
//    protected enum Unit {
//        GRAM,
//        COUNT
//    }
//
//    protected abstract double calculateByUnit(Unit unit, double value);
//}
//
//class Computer extends Product {
//    public Computer() {
//    }
//
//    public Computer(int id, String name, String model, double price) {
//        super(id, name, model, price);
//    }
//
//    @Override
//    protected double calculateByUnit(Unit unit, double value) {
//        if (!Unit.COUNT.equals(unit))
//            throw new UnsupportedOperationException();
//        return value * price;
//    }
//}
//
//class Sugar extends Product {
//    public Sugar() {
//    }
//
//    public Sugar(int id, String name, String model, double price) {
//        super(id, name, model, price);
//    }
//
//    @Override
//    protected double calculateByUnit(Unit unit, double value) {
//        if (!Unit.GRAM.equals(unit) || Math.floor(value) != value)
//            throw new UnsupportedOperationException();
//        return Math.floor(value * price);
//    }
//}
//
//abstract class AbstractProductCreator {
//    protected abstract Product getProduct();
//}
//
//class ComputerCreator extends AbstractProductCreator {
//
//    @Override
//    protected Product getProduct() {
//        return new Computer(100, "asus", "tuf", 1500);
//    }
//}
//
//class SugarCreator extends AbstractProductCreator {
//
//    @Override
//    protected Product getProduct() {
//        return new Sugar(200, "sugar", "yazd sugar", 10);
//    }
//}
//
//class Main2 {
//    public static void main(String[] args) {
//        Product product = new ComputerCreator().getProduct();
//        System.out.println(product.calculateByUnit(Product.Unit.COUNT, 2));
//    }
//}