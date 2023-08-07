import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VeggieTest {

    @Test
    public void testCheckDiscountOrganic() {
        Veggie organicVeggie = new Veggie("Organic Veggie", 8000, 10, true);

        assertEquals(1600.0, organicVeggie.checkDiscount(5), 0.01);
        assertEquals(800.0, organicVeggie.checkDiscount(3), 0.01);
    }

    @Test
    public void testCheckDiscountNonOrganic() {
        Veggie nonOrganicVeggie = new Veggie("Non-Organic Veggie", 10000, 10, false);

        assertEquals(2500.0, nonOrganicVeggie.checkDiscount(5), 0.01);
        assertEquals(2000.0, nonOrganicVeggie.checkDiscount(3), 0.01);
    }

    @Test
    public void testCheckDiscountNoDiscount() {
        Veggie veggie = new Veggie("Regular Veggie", 12000, 10, true);

        assertEquals(0.0, veggie.checkDiscount(2), 0.01);
    }

    @Test
    public void testIsOrganic() {
        Veggie organicVeggie = new Veggie("Organic Veggie", 8000, 10, true);
        Veggie nonOrganicVeggie = new Veggie("Non-Organic Veggie", 10000, 10, false);

        assertTrue(organicVeggie.isOrganic());
        assertFalse(nonOrganicVeggie.isOrganic());
    }
}
