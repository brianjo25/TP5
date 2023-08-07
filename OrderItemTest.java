import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderItemTest {

    
    @Test
    public void testGetFinalPriceWithoutDiscount() {
        Product product = new Fruit("Regular Fruit", 12000, 10, true);
        OrderItem orderItem = new OrderItem(product, 2);

        assertEquals(24000, orderItem.getFinalPrice());
    }

    @Test
    public void testGetProduct() {
        Product product = new Veggie("Organic Veggie", 8000, 10, true);
        OrderItem orderItem = new OrderItem(product, 5);

        assertEquals(product, orderItem.getProduct());
    }

    @Test
    public void testGetQuantity() {
        Product product = new Fruit("Regular Fruit", 12000, 10, true);
        OrderItem orderItem = new OrderItem(product, 3);

        assertEquals(3, orderItem.getQuantity());
    }
}
