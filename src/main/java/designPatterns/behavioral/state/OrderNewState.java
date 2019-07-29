package designPatterns.behavioral.state;

public class OrderNewState implements OrderState {
    @Override
    public boolean canShip(Order order) {
        return true;
    }

    @Override
    public void ship(Order order) {
        order.change(new OrderShippedState());
    }

    @Override
    public boolean canCancel(Order order) {
        return true;
    }

    @Override
    public void cancel(Order order) {
        order.change(new OrderCanceledState());
    }

    @Override
    public OrderStatus getStatus() {
        return OrderStatus.NEW;
    }
}
