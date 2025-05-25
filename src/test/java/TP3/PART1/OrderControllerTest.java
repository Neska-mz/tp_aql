package TP3.PART1;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @Test
    void testCreateOrder() {
        // Arrange
        OrderService orderService = mock(OrderService.class);
        OrderDao orderDao = mock(OrderDao.class);
        OrderController orderController = new OrderController(orderService);
        Order order = new Order("123", 100.0);

        // Act
        orderController.createOrder(order);

        // Assert
        verify(orderService).createOrder(order);
    }
}