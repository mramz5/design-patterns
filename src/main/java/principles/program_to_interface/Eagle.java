package principles.program_to_interface;

public class Eagle implements Flyable {
    @Override
    public void fly() {
        System.out.println("Eagle is flying");
    }
}
