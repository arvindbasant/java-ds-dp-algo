package designPatterns.behavioral.state;

public class OrderShippedState implements OrderState{
    @Override
    public boolean canShip(Order order) {
        return false;
    }

    @Override
    public void ship(Order order) {
        try {
            throw new Exception("Order already shipped");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean canCancel(Order order) {
        return false;
    }

    @Override
    public void cancel(Order order) {
        try {
            throw new Exception("Shipped order can't be cancelled");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderStatus getStatus() {
        return OrderStatus.SHIPPED;
    }
}
