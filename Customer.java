public class Customer {
    // TODO: Implement this class.
    private String name;
    private boolean isPremium;
    private Cart cart = new Cart(this);


    /**
     * Konstruktor untuk name dan isPremium
     * @param object
     */
    public Customer(Object object){
    this.name = name;
    this.isPremium = isPremium;
    }

    
    /**
     * Konstruktor yang menerima parameter
     * @param customerName
     * @param isPremium2
     */
    public Customer(String customerName, boolean isPremium2) {
    }


    /**
     * 3 hal di bawah ini adalah getter
     * untuk mendapatkan nilai dari nama, isPremium, dan cart
     * @return
     */

    public String getName(){
        return name;
    }
    public boolean isPremium(){
        return isPremium;
    }
    public Cart getCart(){
        return cart;
    }
}
