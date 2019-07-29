package designPatterns.behavioral.state;

public interface OrderState {

    boolean canShip(Order order);
    void ship(Order order);

    boolean canCancel(Order order);
    void cancel(Order order);

    OrderStatus getStatus();

}
