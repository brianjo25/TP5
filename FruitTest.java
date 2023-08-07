import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FruitTest {

    @Test
    public void testCheckDiscountLocal() {
        Fruit localFruit = new Fruit("Local Fruit", 10000, 10, true);

        assertEquals(3000.0, localFruit.checkDiscount(5), 0.01);
        assertEquals(2000.0, localFruit.checkDiscount(3), 0.01);
    }

    @Test
    public void testCheckDiscountNonLocal() {
        Fruit nonLocalFruit = new Fruit("Non-Local Fruit", 12000, 10, false);

        assertEquals(2400.0, nonLocalFruit.checkDiscount(5), 0.01);
        assertEquals(1800.0, nonLocalFruit.checkDiscount(3), 0.01);
    }

    @Test
    public void testCheckDiscountNoDiscount() {
        Fruit fruit = new Fruit("Regular Fruit", 15000, 10, true);

        assertEquals(0.0, fruit.checkDiscount(2), 0.01);
    }

    @Test
    public void testIsLocal() {
        Fruit localFruit = new Fruit("Local Fruit", 10000, 10, true);
        Fruit nonLocalFruit = new Fruit("Non-Local Fruit", 12000, 10, false);

        assertTrue(localFruit.isLocal());
        assertFalse(nonLocalFruit.isLocal());
    }
}
