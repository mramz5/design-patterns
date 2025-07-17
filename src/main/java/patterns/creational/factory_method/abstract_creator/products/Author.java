package patterns.creational.factory_method.abstract_creator.products;

public class Author extends Person {
    public Author(long id,String name) {
        this.name=name;
        this.id=id;
    }

    @Override
    public String getFullInfo() {
        return "The Author is : ["+id+" "+name+"]";
    }
}
