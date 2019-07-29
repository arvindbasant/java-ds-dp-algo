package designPatterns.behavioral.state;

import java.util.Date;

public class Order {

    private OrderState orderState;

    public Order(OrderState baseState) {
        this.orderState = baseState;
    }

    private int Id;
    private String Customer;
    private Date OrderDate;


    public OrderStatus status() {
        return orderState.getStatus();
    }

    public boolean canCancel() {
        return orderState.canCancel(this);
    }

    public void cancel() {
        if (canCancel())
            orderState.cancel(this);

    }

    public boolean canShip() {
        return orderState.canShip(this);
    }

    public void ship() {
        if (canShip())
            orderState.ship(this);
    }

    void change(OrderState orderState) {
        this.orderState = orderState;
    }


    // getters and setters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }
}
