package principles.program_to_interface;

public class Parrot implements Flyable {
    @Override
    public void fly() {
        System.out.println("Parrot is flying");
    }
}
