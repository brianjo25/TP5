import java.util.ArrayList;

public class Cart {
    private Customer customer;
    private ArrayList<OrderItem> orderList = new ArrayList<>();


    /**
     * konstruktor untuk costumer
     * @param customer
     */
    Cart(Customer customer) {
        this.customer = customer;
    }

    /**
     * Perhitungan untuk mendapatkan total price
     * @return
     */
    public double getTotalPrice() {
        double totalPrice = 0;
        for (OrderItem item : orderList) {
            totalPrice += item.getFinalPrice();
        }

        if (totalPrice >= 300000 && this.customer.isPremium()) {
            double discount = totalPrice * 0.1;
            totalPrice -= discount;
        }

        return totalPrice;
    }


    /**
     * Konstruktor untuk orderItem
     * @param orderItem
     */
    public void addOrderItem(OrderItem orderItem) {
        this.orderList.add(orderItem);
    }

    /**
     * Untuk akses dan mendapatkan orderList
     * @return
     */
    public ArrayList<OrderItem> getOrderItemList() {
        return orderList;
    }

    /**
     * Mereturn null jika getCustomer tidak menemukan customernya
     * @return
     */
    public Customer getCustomer() {
        return null;
    }
}
