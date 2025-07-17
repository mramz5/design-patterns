package principles.program_to_interface;

public class Main {

    public static void main(String[] args){
        //client does not need to know about th implementation it just needs to work with the interface
        //the object reference changes dynamically at run-time
        //loose coupling
        Flyable[] flyables=getFlyables();
        System.out.println("Flying with different birds:");
        for (Flyable flyable : flyables)
            flyable.fly();


    }

    public static Flyable[] getFlyables(){
        Flyable[] flyables=new Flyable[2];
        flyables[0]=new Eagle();
        flyables[1]=new Parrot();
        return flyables;
    }
}

