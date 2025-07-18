package TP3.PART1;
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void createOrder(Order order) {
        orderService.createOrder(order);
    }
}
