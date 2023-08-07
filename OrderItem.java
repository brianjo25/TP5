public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product , int quantity) {
        this.product = product;
        this.quantity=quantity;
    }

    public OrderItem(String string, int i, int j) {
    }

    public int getFinalPrice() {
        double originalPrice = this.product.getPrice();
        double discountPercentage = this.product.checkDiscount(this.quantity);
        double discountedPrice = originalPrice - (originalPrice * discountPercentage);
        double finalPrice = discountedPrice * this.quantity;
        return (int) Math.round(finalPrice);
    }
    
    

    public Product getProduct(){
        return product;
    }
    public int getQuantity(){
        return quantity;
    }
}
