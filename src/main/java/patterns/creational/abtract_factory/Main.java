package patterns.creational.abtract_factory;

public class Main {
    public static void main(String[] args) {
        FactoryProducer producer = FactoryProducer.getInstance();
        PersonFactory factory = (PersonFactory) producer.getFactory("Person");
        Person person = factory.factoryMethod("EMPLOYEE");
        person.talk();
    }
}

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public abstract class Computer {
//    private int id;
//    private String name;
//    private double price;
//}
//
//class WorkComputer extends Computer {
//    public WorkComputer(int id, String name, double price) {
//        super(id, name, price);
//    }
//}
//
//class GamingComputer extends Computer {
//    public GamingComputer(int id, String name, double price) {
//        super(id, name, price);
//    }
//}
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//abstract class Keyboard {
//    private String name;
//    private String company;
//}
//
//class WorkKeyboard extends Keyboard {
//    public WorkKeyboard(String name, String company) {
//        super(name, company);
//    }
//}
//
//
//class GamingKeyboard extends Keyboard {
//    public GamingKeyboard(String name, String company) {
//        super(name, company);
//    }
//}
//
////new coupling
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//abstract class Mouse {
//    private String model;
//    private double wireLength;
//    private double price;
//}
//
//class WorkMouse extends Mouse {
//    public WorkMouse(String model, double wireLength, double price) {
//        super(model, wireLength, price);
//    }
//}
//
//class GamingMouse extends Mouse {
//    public GamingMouse(String model, double wireLength, double price) {
//        super(model, wireLength, price);
//    }
//}
//
//interface Creator {
//    Computer createComputer();
//
//    Keyboard createKeyboard();
//
//    //new coupling
//    Mouse createMouse();
//}
//
//class GamingPartCreator implements Creator {
//
//    @Override
//    public GamingComputer createComputer() {
//        return new GamingComputer(1, "asus tuf", 1000);
//    }
//
//    @Override
//    public GamingKeyboard createKeyboard() {
//        return new GamingKeyboard("gk-f12", "msi");
//    }
//
//    //new coupling
//    @Override
//    public Mouse createMouse() {
//        return new WorkMouse("acer", 2, 10);
//    }
//}
//
//class WorkPartCreator implements Creator {
//
//    @Override
//    public WorkComputer createComputer() {
//        return new WorkComputer(2, "acer", 90);
//    }
//
//    @Override
//    public WorkKeyboard createKeyboard() {
//        return new WorkKeyboard("ocw-89", "hp");
//    }
//
//    //new coupling
//    @Override
//    public WorkMouse createMouse() {
//        return new WorkMouse("logitech", 1.5, 8);
//    }
//}
//
//class Main2 {
//    public static void main(String[] args) {
//        Creator creator=new WorkPartCreator();
//        Keyboard workingKeyboard=creator.createKeyboard();

//        Creator creator = new WorkPartCreator();
//        Computer computer = creator.createComputer();
//        Keyboard keyboard = creator.createKeyboard();
//        Mouse mouse=creator.createMouse();
//
//        System.out.println(computer);
//        System.out.println(keyboard);
//        System.out.println(mouse);
//    }
//}