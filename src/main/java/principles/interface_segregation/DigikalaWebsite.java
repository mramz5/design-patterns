package principles.interface_segregation;

import java.util.List;

public class DigikalaWebsite implements OnlineServices{
    @Override
    public void acceptOnlineOrders(List orders) {
        System.out.println("Accepting orders online :"+orders);
    }

    @Override
    public boolean authenticateUser(String user) {
        if (user.equals("USER")) {
            System.out.println("User authenticated");
            return true;
        }
        return false;
    }
    @Override
    public void showProducts() {
        System.out.println("Showing products");
    }
}
