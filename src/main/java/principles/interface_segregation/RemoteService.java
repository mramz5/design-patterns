package principles.interface_segregation;

import java.util.List;

public interface RemoteService extends principles.interface_segregation.OnlineShop {
    void acceptTelephoneOrders(List orders);}
