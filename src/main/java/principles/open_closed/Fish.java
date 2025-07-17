package principles.open_closed;

public class Fish implements Animal{
    @Override
    public void walk() {
        System.out.println("The fish is swimming");
    }
}
