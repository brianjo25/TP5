abstract class Product {
    // TODO: Implement this class.
    private String name;
    private int price;
    private int stock;

    public Product(String name, int price, int stock){
        this.name = name;
        this.price = price;
        this. stock = stock;
    }
    
    public double checkDiscount(int quantity) {
        return 0;
    }

   public int getPrice(){
    return price;
   }
   public String getName(){
    return name;
   }
   public int getStock(){
    return stock;
   }
}
