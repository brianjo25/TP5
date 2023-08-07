public class Fruit extends Product {
    private boolean isLocal;

    /**
     * Buat objek baru dengan parameter yang diterima dibawah ini
     * @param name
     * @param price
     * @param stock
     * @param isLocal
     */
    public Fruit(String name, int price, int stock, boolean isLocal){
        super(name, price, stock);
        this.isLocal = isLocal;
    }


    /**
     * Melakukan perthitungan dan mereturn potongan yang diterima
     * dari transaksi sesuai dengan ketentuan yang sudah diberi di soal
     */
    @Override
    public double checkDiscount(int quantity) {
        if (isLocal) {
            if (quantity >= 5) {
                return this.getPrice() * 0.3;
            } else if (quantity >= 3) {
                return this.getPrice() * 0.2;
            }
        } else {
            if (quantity >= 5) {
                return this.getPrice() * 0.2;
            } else if (quantity >= 3) {
                return this.getPrice() * 0.15;
            }
        }
        return 0;
    }
    
    /**
     * Getter yang akan membantu menenetukan apakah fruit bernilai local atau tidak
     * @return
     */
    public boolean isLocal() {
        return isLocal;
    }
}
