
/**
 * Write a description of class TicketMachine here.
 *
 * @author Dafa Kumara 5025241112
 * @version 1
 */
public class TicketMachine
{
    private int price;
    private int balance;
    private int total;
    
    public TicketMachine(int ticketCost)
    {
        price = ticketCost;
        balance = 0;
        total = 0;
    }
    
    public int getPrice(){
        return price;
    }
    
    public int getBalance(){
        return balance;
    }
    
    public void insertMoney(int amount){
        /* naive --> balance = balance + amount;
        * better
        */
        if (amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount: " + amount);
        }
    }
    
    public void printTicket(){
        /* naive
        System.out.println("#################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# " + price + " cents. ");
        System.out.println("#################");
        System.out.println();
        
        total = total + balance;
        balance = 0;
        */
        
        if (balance>=price){
            System.out.println("#################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents. ");
            System.out.println("#################");
            System.out.println();
        
            total = total + balance;
            balance = 0;
        }
        else {
            System.out.println("You must insert at least: " + 
            (price - balance) + "more cents..");
        }
    }
}
