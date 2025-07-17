package patterns.behavioral.command.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface Order {
    void execute();
}

class Buy implements Order {
    private Stock stock;

    public Buy(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}

class Sell implements Order {
    private final Stock stock;

    public Sell(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}

class Stock {
    public void buy() {
        System.out.println("laptop bought for 1000$");
    }

    public void sell() {
        System.out.println("laptop sold for 450$");
    }
}

class StockInvoker {
    private final List<Order> orders = new ArrayList<>();

    public void takeOrder(Order order) {
        if (Objects.nonNull(order))
            orders.add(order);
    }

    public void placeOrders() {
        orders.forEach(Order::execute);
        orders.clear();
    }
}

class Main{
    public static void main(String[] args) {
        Stock stock=new Stock();
        StockInvoker stockInvoker=new StockInvoker();
        stockInvoker.takeOrder(new Buy(stock));
        stockInvoker.takeOrder(new Buy(stock));
        stockInvoker.takeOrder(new Sell(stock));
        stockInvoker.takeOrder(new Sell(stock));

        stockInvoker.placeOrders();
    }
}

