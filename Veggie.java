public class Veggie extends Product{
    // TODO: Implement this class.
    
    private boolean isOrganic;
    public Veggie(String name, int price, int stock, boolean isOrganic){
        super(name, price, stock);
        this.isOrganic = isOrganic;
    }

    @Override
    public double checkDiscount(int quantity) {
    if (isOrganic) {
        if (quantity >= 5) {
            return this.getPrice() * 0.2;
        } 
        else if (quantity >= 3) {
            return this.getPrice() * 0.1;
        }
    } 
    else {
        if (quantity >= 5) {
            return this.getPrice() * 0.25;
        } 
        else if (quantity >= 3) {
            return this.getPrice() * 0.2;
        }
    }
    return 0;
}

    public boolean isOrganic() {
        return isOrganic;
    }
}
