import static org.junit.Assert.*;
import org.junit.Test;

public class CartTest {

    @Test
    public void testGetTotalPriceEmptyCart() {
        Customer customer = new Customer(false);
        Cart cart = new Cart(customer);

        double expectedOutput = 0.0;
        double actualOutput = cart.getTotalPrice();

        assertEquals(expectedOutput, actualOutput, 0.01);
    }

}

  @Test
    public void testGetTotalPriceNonPremiumCustomer() {
        Customer customer = new Customer(false);
        Cart cart = new Cart(customer);

        Product product1 = new Fruit("Apple", 5000, 2, true);
        Product product2 = new Veggie("Carrot", 3000, 3, true);

        cart.addOrderItem(new OrderItem(product1, 2));
        cart.addOrderItem(new OrderItem(product2, 3));

        double expectedOutput = 19500.0; // (2 * 5000) + (3 * 3000) = 10000 + 9000 = 19000
        double actualOutput = cart.getTotalPrice();

        assertEquals(expectedOutput, actualOutput, 0.01);
    }