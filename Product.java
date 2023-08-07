abstract class Product {
    // TODO: Implement this class.
    private String name;
    private int price;
    private int stock;

    /**
     * Kontruktor untuk nama, price, dan stock
     * @param name
     * @param price
     * @param stock
     */

    public Product(String name, int price, int stock){
        this.name = name;
        this.price = price;
        this. stock = stock;
    }
    

    public double checkDiscount(int quantity) {
        return 0;
    }

    /**
     * Getter untuk mendapatkan nilai price
     * @return
     */
   public int getPrice(){
    return price;
   }

   /**
    * Getter untuk mendapatkan name
    * @return
    */
   public String getName(){
    return name;
   }

   /**
    * Getter untuk mendapatkan nilai Stock
    * @return
    */
   public int getStock(){
    return stock;
   }

   /**
    * Getter untuk mendapatkan nilai product
    * @return
    */
public String getProductName() {
    return name;
}

/**
 * Perhitungan untuk mengurangig stock saat ada pembelian
 * @param jumlahDibeli
 */
public void reduceStock(int jumlahDibeli) {
    this.stock -= jumlahDibeli;
    }
}
