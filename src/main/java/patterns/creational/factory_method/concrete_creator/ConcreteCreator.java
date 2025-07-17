package patterns.creational.factory_method.concrete_creator;

public class ConcreteCreator {
    public static void main(String[] args) {
        try {
            AnimalFactory factory = new AnimalFactory();
            Animal animal = factory.getAnimal("DUCK");
            animal.eat();
            animal.walk();

            Animal monkey=factory.getAnimal("MONKEY");
            monkey.walk();

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}

class AnimalFactory{
    public Animal getAnimal(String type) throws IllegalArgumentException{
        switch (type.toLowerCase()){
            case "tiger":
                return new Tiger();
            case "duck":
                return new Duck();
            default :
                throw new IllegalArgumentException("Animal type : "+type+" cannot be instantiated");
        }
    }
}

interface Animal{
    void walk();
    void eat();
}

class Tiger implements Animal {
    @Override
    public void walk() {
        System.out.println("Tiger is walking");
    }

    @Override
    public void eat() {
        System.out.println("Tiger is eating a meat");
    }
}

class Duck implements Animal {
    @Override
    public void walk() {
        System.out.println("Duck is walking");
    }

    @Override
    public void eat() {
        System.out.println("Duck is eating seed");
    }
}