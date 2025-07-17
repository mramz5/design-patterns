package patterns.creational.factory_method.static_method_creator;


import patterns.creational.factory_method.abstract_creator.products.Author;
import patterns.creational.factory_method.abstract_creator.products.Employee;
import patterns.creational.factory_method.abstract_creator.products.Person;

public class PersonFactory {
    public static Person getPerson(String type){
        switch (type.toLowerCase()){
            case "employee":
                return new Employee(0,"EMP");
            case "author":
                return new Author(1,"AUTHOR");
            default:
                throw new IllegalArgumentException("Person not found");
        }
    }
}

