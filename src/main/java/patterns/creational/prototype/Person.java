package patterns.creational.prototype;

import java.io.*;
import java.util.List;
import java.util.Objects;

public abstract class Person implements Serializable {

    private static final long serialVersionUID = 6866959843241865973L;
    protected String firstName;
    protected String lastName;
    protected List<Integer> numberList;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }

    //best approach
    public abstract Person clone();

    //first approaches

//    public Person clone(){
//        try {
//            return (Person) super.clone();
//        }catch (CloneNotSupportedException e){
//            e.printStackTrace();
//            return null;
//        }
//    }

//    public Person clone() {
//        try {
//            Person person = (Person) super.clone();
//            //deep copy -> initializing all references
//            person.numberList = new ArrayList<>();
//            return person;
//
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    //second approach: good but it is slower than the previous two

//    public Person clone(){
//        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("o.dat"));
//            ObjectInputStream in=new ObjectInputStream(new FileInputStream("o.dat"))){
//                out.writeObject(this);
//                return (Person) in.readObject();
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
    public abstract String getInfo();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!Objects.equals(firstName, person.firstName)) return false;
        return Objects.equals(lastName, person.lastName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }
}

class Employee extends Person {
    private static int counter = 0;
    private final long id;

    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
        this.id = counter++;
    }

    @Override
    public String getInfo() {
        return "[" + id + "-" + firstName + " " + lastName + "]";
    }

    public Employee(Employee employee) {
        super(employee.firstName, employee.lastName);
        this.id = counter++;
    }
    @Override
    public Person clone() {
        return new Employee(this);
    }

        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Employee employee = (Employee) o;

            return super.equals(o) && id == employee.id;
        }

    @Override
    public String toString() {
        return "[" + id +
                ", " + firstName  +
                ", " + lastName  +
                ", " + numberList+"]";
    }
}




class Author extends Person {
    private long authorName;

    public Author(String firstName, String lastName, long authorName) {
        super(firstName, lastName);
        this.authorName = authorName;
    }

    public Author(Author author) {
        super(author.firstName, author.lastName);
        this.authorName = author.authorName;
    }

    @Override
    public Person clone() {
        return new Author(this);
    }

    @Override
    public String getInfo() {
        return "[" + authorName + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Author author = (Author) o;

        return super.equals(o) && authorName == author.authorName;
    }
}
