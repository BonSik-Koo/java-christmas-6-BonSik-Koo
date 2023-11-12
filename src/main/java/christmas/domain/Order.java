package christmas.domain;

import java.util.List;

public class Order {
    private final Date date;
    private final OrderMenus orderMenus;

    public Order(Date date, List<OrderMenu> orderMenus) {
        this.date = date;
        this.orderMenus = new OrderMenus(orderMenus);
    }

}
