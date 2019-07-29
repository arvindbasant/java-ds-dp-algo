package designPatterns.behavioral.state;

public class OrderCanceledState implements OrderState {
    @Override
    public boolean canShip(Order order) {
        return false;
    }

    @Override
    public void ship(Order order) {
        try {
            throw new Exception("Canceled order can't be shipped");
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
            throw new Exception("Order already canceled");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderStatus getStatus() {
        return OrderStatus.CANCELED;
    }
}
