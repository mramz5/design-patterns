package principles.interface_segregation;

import java.util.List;

public interface OnlineServices extends OnlineShop {
    void acceptOnlineOrders(List orders);
    boolean authenticateUser(String user);
}
