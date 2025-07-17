package principles.interface_segregation;

import java.util.List;

public class DigikalaSupport implements RemoteService{
    @Override
    public void showProducts() {
        System.out.println("We have these products");
    }

    @Override
    public void acceptTelephoneOrders(List orders) {
        System.out.println("Accepting products from telephone");
    }
}
