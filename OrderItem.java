public class OrderItem {
    private Product product;
    private int quantity;

    /**
     * Menjadi kontruktor untuk product dan quantity
     * @param product
     * @param quantity
     */
    public OrderItem(Product product , int quantity) {
        this.product = product;
        this.quantity=quantity;
    }

    public OrderItem(String string, int i, int j) {
    }

    /**
     * Melakukan perhitungan untuk mendapatkan nilai akhir
     * @return
     */
    public int getFinalPrice() {
        double originalPrice = this.product.getPrice();
        double discountPercentage = this.product.checkDiscount(this.quantity);
        double discountedPrice = originalPrice - (originalPrice * discountPercentage);
        double finalPrice = discountedPrice * this.quantity;
        return (int) Math.round(finalPrice);
    }
    
    
    /**
     * Getter untuk mendapatkan product
     * @return
     */
    public Product getProduct(){
        return product;
    }

    /**
     * Getter untuk mendapatkan quantity
     * @return
     */
    public int getQuantity(){
        return quantity;
    }
}
