import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ShyourBox {
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Cart> carts = new ArrayList<Cart>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        ShyourBox shyourboxApp = new ShyourBox();
        System.out.println("Welcome to ShyourBox! Yuk beli jangan shy shy!");

        String productAddress = "input/daftarProduk.txt";
        String customerAddress = "input/daftarCustomer.txt";

        shyourboxApp.addProduct(productAddress);
        shyourboxApp.addCustomer(customerAddress);

        int choice;
        do {
            System.out.println("Menu" +
                    "\n1. Beli Produk" +
                    "\n2. Cari Produk" +
                    "\n3. Print Struk" +
                    "\n0. Keluar");
            System.out.print("Pilih menu: ");
            choice = shyourboxApp.scanner.nextInt();
            shyourboxApp.scanner.nextLine();

            switch (choice) {
                case 1:
                    shyourboxApp.buyProduct();
                    break;
                case 2:
                    System.out.print("Cari produk dengan nama: ");
                    String name = shyourboxApp.scanner.nextLine();
                    Product foundProduct = shyourboxApp.searchProduct(name);
                    if (foundProduct != null) {
                        if (foundProduct instanceof Fruit) {
                            Fruit fruit = (Fruit) foundProduct;
                            String productType = fruit.isLocal() ? "Buah Lokal" : "Buah non-Lokal";
                            System.out.println("[" + productType + "]");
                        } else if (foundProduct instanceof Veggie) {
                            Veggie veggie = (Veggie) foundProduct;
                            String productType = veggie.isOrganic() ? "Sayur Organik" : "Sayur non-Organik";
                            System.out.println("[" + productType + "]");
                        }

                        System.out.println("Nama Produk: " + foundProduct.getProductName());
                        System.out.println("Harga: " + foundProduct.getPrice());
                        System.out.println("Stok: " + foundProduct.getStock());
                        System.out.println();
                    } else {
                        System.out.println("Produk tidak ditemukan!\n");
                    }
                    break;

                case 3:
                    shyourboxApp.printReceipt();
                    System.out.println();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Yay!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        } while (choice != 0);
        shyourboxApp.scanner.close();
    }

    private void addCustomer(String customerAddress) {
    }

    private void addProduct(String productAddress) {
    }

    public void buyProduct() {
        System.out.print("Masukkan nama customer: ");
        String namaCustomer = scanner.nextLine();
        Customer customer = findCustomer(namaCustomer);

        if (customer != null) {
            System.out.println("====MASUKKAN ITEM KE KERANJANG====");
            System.out.println();

            boolean selesaiBelanja = false;

            while (!selesaiBelanja) {
                System.out.print("Masukkan nama produk (X untuk selesai): ");
                String produkYangDibeli = scanner.nextLine();

                if (produkYangDibeli.equalsIgnoreCase("X")) {
                    System.out.println("Terima kasih sudah berbelanja, " + namaCustomer + "\n");
                    break;
                } else {
                    Product produkDibeli = searchProduct(produkYangDibeli);

                    if (produkDibeli != null) {
                        System.out.print("Masukkan Jumlah (kg): ");
                        int jumlahDibeli = scanner.nextInt();
                        scanner.nextLine();

                        if (produkDibeli.getStock() >= jumlahDibeli) {
                            OrderItem produkDanJumlahDibeli = new OrderItem(produkDibeli, jumlahDibeli);
                            customer.getCart().addOrderItem(produkDanJumlahDibeli);
                            produkDibeli.reduceStock(jumlahDibeli); // Mengurangi stok produk
                            System.out.println("Produk Berhasil ditambahkan!\n");
                        } else {
                            System.out.println("Mohon maaf, stok tidak mencukupi!\n");
                        }
                    } else {
                        System.out.println("Mohon maaf, produk tidak tersedia!\n");
                    }
                }
            }
        } else {
            System.out.println("Mohon maaf, customer atas nama " + namaCustomer + " tidak terdaftar!\n");
        }
    }

    // Metode lainnya tetap sama

    private Product searchProduct(String produkYangDibeli) {
        return null;
    }

    private Customer findCustomer(String namaCustomer) {
        return null;
    }

    public void printReceipt() {
        if (carts.isEmpty()) {
            System.out.println("Tidak ada transaksi untuk dicetak.");
            return;
        }

        try {
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(0));
            String receiptFileName = "receipt_" + timeStamp + ".txt";

            FileWriter writer = new FileWriter(receiptFileName);
            double totalSpent = 0;

            for (Cart cart : carts) {
                Customer customer = cart.getCustomer();
                writer.write("====================================\n");
                writer.write("ShyourBox Receipt\n");
                writer.write("Tanggal: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date(0)) + "\n");
                writer.write("Customer: " + customer.getName() + "\n");
                writer.write("====================================\n");

                ArrayList<OrderItem> items = cart.getOrderItemList();
                for (OrderItem item : items) {
                    Product product = item.getProduct();
                    writer.write(product.getProductName() + " (" + item.getQuantity() + " kg) - Rp" + item.getFinalPrice() + "\n");
                    totalSpent += item.getFinalPrice();
                }

                writer.write("====================================\n");
                writer.write("Total: Rp" + totalSpent + "\n");
                writer.write("====================================\n");
                writer.write("\n");
            }

            writer.close();
            System.out.println("Struk belanja berhasil dicetak: " + receiptFileName);
        } catch (IOException e) {
            System.out.println("Gagal mencetak struk belanja.");
        }
    }
}
