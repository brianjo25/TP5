public class Fruit extends Product {
    private boolean isLocal;
    public Fruit(String name, int price, int stock, boolean isLocal){
        super(name, price, stock);
        this.isLocal = isLocal;
    }

    public boolean getLocal(){
        return isLocal;
    }

    @Override
    public double checkDiscount(int quantity) {
        if (isLocal == true){
            if (quantity >= 5){
                return this.getPrice() * 0.3;
            }
            else if (quantity >= 3){
                return this.getPrice()*0.2;
            }

        else{
            if (quantity >= 5){
                return this.getPrice() * 0.2;
            }
            else if (quantity >= 3){
                return this.getPrice() * 0.15;
            }
            }
        }
        return 0;
    }
}
