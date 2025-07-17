package patterns.creational.prototype;

public class Main {
    public static void main(String[] args) {

//        Person employee1 = new Employee("Ali", "Zamani");
//        Person author1 = new Author("Hossein", "Ahmadi", 10);
//        Person employee2 = new Employee("Hassan", "Khan");
//        Person author2 = new Author("Morteza", "Dolabi", 1);
//        Person employee3 = new Employee("Esmail", "Torabi Zade");
//
//        Instant start=Instant.now();
//        Person person4 = employee1.clone();
//        person4.setFirstName("Copied Ali");
//        Person person5 = author2.clone();
//        Person person9 = employee3.clone();
//        System.out.println(Duration.between(start,Instant.now()).toNanos() +" ns");
//
//        System.out.println(person4.getInfo() + "\t" + (person4 == employee1) + "\t" + person4.equals(employee1));
//        System.out.println(employee1);
//        System.out.println(person5.getInfo() + "\t" + (person5 == author2) + "\t" + person5.equals(author2));
//        System.out.println(person9.getInfo() + "\t" + (person9 == employee3) + "\t" + person9.equals(employee3));

        CarCache.load();
        BasicCar car=CarCache.getInstance().getCar(2);
        System.out.println(car);
    }
}

