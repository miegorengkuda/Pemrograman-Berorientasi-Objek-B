import java.util.*;

class VendingMachine {
    List<Product> products = new ArrayList<>();
    List<Transaction> logs = new ArrayList<>();
    int balance = 0;

    public void addProduct(Product p) {
        products.add(p);
    }

    public void displayProducts() {
        System.out.println("\n=== Monster Mart Vending Machine Menu ===");
        for (Product p : products) {
            System.out.println(p.id + ". " + p.name + " - Rp" + p.price + " [" + p.stock + " stok]");
        }
    }

    public Product selectProduct(int id) {
        for (Product p : products) {
            if (p.id == id) return p;
        }
        return null;
    }

    public void insertMoney(int money) {
        balance += money;
        System.out.println("Saldo sekarang: Rp" + balance);
    }

    public void dispenseProduct(Product p) {
        if (balance < p.price) {
            System.out.println("Saldo tidak cukup! Silakan masukkan uang lagi.");
            return;
        }

        p.reduceStock();
        balance -= p.price;
        logs.add(new Transaction(p.name, p.price));
        System.out.println("Berhasil! Mengeluarkan: " + p.name);
        System.out.println("Sisa saldo: Rp" + balance);
    }
    
    public void remindAdmin(){
        for (Product p : products){
            if (p.stock == 0){
                System.out.println("Mohon Admin Segera isi ulang " + p.name);
            }
        }
    }

    public void refund() {
        System.out.println("Mengembalikan uang: Rp" + balance);
        balance = 0;
    }

    public void showLogs() {
        System.out.println("\n=== Log Transaksi ===");
        for (Transaction t : logs) {
            System.out.println(t);
        }
    }
}