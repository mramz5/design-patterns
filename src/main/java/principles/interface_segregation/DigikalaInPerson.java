package principles.interface_segregation;

public class DigikalaInPerson implements InPersonServices{
    @Override
    public void acceptInPersonCustomer(Object customer) {
        System.out.println("accepting orders In person ");
    }

    @Override
    public void showProducts() {
        System.out.println("Seeing products inside the company");
    }
}
