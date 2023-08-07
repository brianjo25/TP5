public class Veggie extends Product{
    // TODO: Implement this class.
    
    
    private boolean isOrganic;

    /**
     * Konstruktor yang sekaligus menerima parameter name, price, stock, isOrganic
     * @param name
     * @param price
     * @param stock
     * @param isOrganic
     */
    public Veggie(String name, int price, int stock, boolean isOrganic){
        super(name, price, stock);
        this.isOrganic = isOrganic;
    }


    /**
     * Perhitungan yang dilakukan untuk mendapatkan nilai potongan
     * sesuai dengan pembelian yang dilakukan sesuai ketentuan di soal
     */
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

/**
 * Getter untuk nilai isOrganic
 * @return
 */
    public boolean isOrganic() {
        return isOrganic;
    }
}
