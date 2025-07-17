package patterns.creational.factory_method.abstract_creator;

import patterns.creational.factory_method.abstract_creator.products.Author;

import java.util.Random;

public class AuthorFactory extends PersonFactory {
    @Override
    protected Author factoryMethod() {
        return new Author(new Random().nextInt(10)+1,"AUTHOR");
    }
}
