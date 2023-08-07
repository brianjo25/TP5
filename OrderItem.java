public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product , int quantity) {
        this.product = product;
        this.quantity=quantity;
    }

    public int getFinalPrice() {
    double originalPrice = this.product.getPrice();
    double discountPercentage = this.product.checkDiscount(this.quantity) / 100.0;
    double discountedPrice = originalPrice * (1 - discountPercentage);
    int finalPrice = (int) (discountedPrice * this.quantity);
    return finalPrice;
    }

    public Product getProduct(){
        return product;
    }
    public int getQuantity(){
        return quantity;
    }
}
