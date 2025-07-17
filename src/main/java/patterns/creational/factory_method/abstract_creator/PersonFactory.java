package patterns.creational.factory_method.abstract_creator;

import patterns.creational.factory_method.abstract_creator.products.Person;

public abstract class PersonFactory {
    protected abstract Person factoryMethod();
    public Person getPerson(){return factoryMethod();}
}
