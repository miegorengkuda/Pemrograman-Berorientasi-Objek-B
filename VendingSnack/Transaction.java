import java.util.*;

class Transaction {
    String productName;
    int amountPaid;
    Date date;

    public Transaction(String productName, int amountPaid) {
        this.productName = productName;
        this.amountPaid = amountPaid;
        this.date = new Date();
    }

    public String toString() {
        return date + " | " + productName + " | Paid: " + amountPaid;
    }
}