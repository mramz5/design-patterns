package patterns.creational.factory_method.abstract_creator.products;

public abstract class Person {
    protected long id;
    protected String name;

    public abstract String getFullInfo();
}
