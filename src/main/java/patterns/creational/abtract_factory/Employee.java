package patterns.creational.abtract_factory;

public class Employee implements Person {
    @Override
    public void talk() {
        System.out.println("Employee is asking about his task from his employer");
    }
}
