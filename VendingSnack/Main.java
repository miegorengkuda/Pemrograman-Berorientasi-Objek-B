import java.util.*;

public class Main {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        vm.addProduct(new Product(1, "Chitato", 10000, 5));
        vm.addProduct(new Product(2, "Happy Tos", 8000, 3));
        vm.addProduct(new Product(3, "Silver Queen", 12000, 1));
        vm.addProduct(new Product(4, "Croissant", 9000, 4));
        vm.addProduct(new Product(5, "Le Minerale", 4000, 10));
        vm.addProduct(new Product(6, "Coca Cola", 7000, 4));
        vm.addProduct(new Product(7, "Fruit Tea", 5000, 7));

        Scanner input = new Scanner(System.in);
        int pilih;

        do {
            vm.displayProducts();
            System.out.print("Pilih nomor produk (id) atau 0 untuk keluar: ");
            pilih = input.nextInt();

            if (pilih == 0) break;

            Product selected = vm.selectProduct(pilih);
            if (selected == null) {
                System.out.println("Produk tidak ditemukan!");
                continue;
            }
            
            if (!selected.isAvailable()) {
                System.out.println("Maaf, stok " + selected.name + " habis. Silakan pilih produk lain.");
                System.out.println("Mohon Admin segera melakukan isi ulang!!");
            continue;
            }

            System.out.print("Masukkan uang: Rp");
            int uang = input.nextInt();
            vm.insertMoney(uang);
            vm.dispenseProduct(selected);
            vm.remindAdmin();

        } while (true);
        
    
        vm.showLogs();
        vm.refund();
        System.out.println("=== Terima kasih telah menggunakan mesin ini! ===");
    }
}
