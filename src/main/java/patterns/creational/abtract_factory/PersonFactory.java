package patterns.creational.abtract_factory;

public class PersonFactory implements AbstractPersonFactory {
    @Override
    public Person factoryMethod(String type) {
        return switch (type.toLowerCase()){
            case ("employee")->new Employee();
            case ("servant")->new Servant();
            default -> throw new IllegalArgumentException("Not supported type : "+type);
        };
    }
}
