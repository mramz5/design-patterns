package patterns.creational.abtract_factory;

public class Servant implements Person {
    @Override
    public void talk() {
        System.out.println("Servant is talking about his life");
    }
}
