package patterns.creational.abtract_factory;

public class FactoryProducer {
    private static FactoryProducer factoryProducer;
    private FactoryProducer() {}
    public static synchronized FactoryProducer getInstance() {
        if (factoryProducer == null)
            factoryProducer = new FactoryProducer();
        return factoryProducer;
    }

    public AbstractFactory getFactory(String type) {
        return switch (type.toLowerCase()) {
            case ("department") -> new DepartmentFactory();
            case ("person") -> new PersonFactory();
            default -> throw new IllegalArgumentException("Not supported type : " + type);
        };
    }
}
