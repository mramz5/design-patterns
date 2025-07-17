package patterns.creational.factory_method.abstract_creator.products;

public class Employee extends Person {
    public Employee(long id,String name) {
        this.name=name;
        this.id=id;
    }

    @Override
    public String getFullInfo() {
       return  "The Employee is :["+id+" "+name+"]";
    }
}
