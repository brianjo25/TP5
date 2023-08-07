import java.util.ArrayList;

public class Cart {
    private Customer customer;
    private ArrayList<OrderItem> orderList= new ArrayList<>();

    Cart(Customer customer) {
        // TODO: Implement this method.
        this.customer = customer;
    }

    public double getTotalPrice() {
        // TODO: Implement this method.
        double totalPrice = 0;
        for (OrderItem item : orderList){
            totalPrice += item.getFinalPrice();  
        }

        if(totalPrice >= 300000 && this.customer.isPremium()){
            double diskon = totalPrice * 0.1;
            totalPrice -= diskon;
        }
        return totalPrice;
    } 

    public void addOrderItem(OrderItem orderItem) {
        // TODO: Implement this method.
        this.orderList.add(orderItem);
    }

    public ArrayList<OrderItem> getOrderItemList(){
        return orderList;
    }
}
