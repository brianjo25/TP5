import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class CartTest {

    private Product apple;
    private Product banana;
    private Customer premiumCustomer;
    private Customer regularCustomer;
    private OrderItem appleOrder;
    private OrderItem bananaOrder;
    private Cart premiumCart;
    private Cart regularCart;

    @Before
    public void setup() {
        apple = new Fruit("Apple", 10000, 50, true);
        banana = new Fruit("Banana", 8000, 40, false);

        premiumCustomer = new Customer("Premium Customer", true);
        regularCustomer = new Customer("Regular Customer", false);

        appleOrder = new OrderItem(apple, 3);
        bananaOrder = new OrderItem(banana, 5);

        premiumCart = new Cart(premiumCustomer);
        regularCart = new Cart(regularCustomer);

        premiumCart.addOrderItem(appleOrder);
        regularCart.addOrderItem(bananaOrder);
    }

    @Test
    public void testGetOrderItemList() {
        ArrayList<OrderItem> premiumItems = premiumCart.getOrderItemList();
        assertEquals(1, premiumItems.size());
        assertEquals("Apple", premiumItems.get(0).getProduct().getProductName());

        ArrayList<OrderItem> regularItems = regularCart.getOrderItemList();
        assertEquals(1, regularItems.size());
        assertEquals("Banana", regularItems.get(0).getProduct().getProductName());
    }

    @Test
    public void testGetTotalPrice() {
        assertEquals(27000, premiumCart.getTotalPrice(), 0.001);
        assertEquals(40000, regularCart.getTotalPrice(), 0.001);
    }

    @Test
    public void testGetCustomer() {
        assertEquals(premiumCustomer, premiumCart.getCustomer());
        assertEquals(regularCustomer, regularCart.getCustomer());
    }
}
