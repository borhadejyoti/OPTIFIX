import java.util.Scanner;

public class BankingApplication {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BankAccount bank1 = new BankAccount("xyz", "67");

        bank1.showMenu();
    }

}

class BankAccount {
    int Balance;
    int PreviousTransaction;

    String customerName;
    String CustomerId;

    BankAccount(String cname, String cid) {
        customerName = cname;
        CustomerId = cid;
    }

    void deposit(int amount) {
        if (amount != 0) {
            Balance = Balance + amount;
            PreviousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            Balance = Balance - amount;
            PreviousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (PreviousTransaction > 0) {
            System.out.println("Deposited:" + PreviousTransaction);
        } else if (PreviousTransaction < 0) {
            System.out.println("Withdraw:" + Math.abs(PreviousTransaction));
        } else {
            System.out.println("No Transaction is occured");
        }
    }

    void showMenu(){
            char Option ='\0';
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Welcome "+customerName);
        System.out.println("your Id is:"+CustomerId);

        System.out.println();
        System.out.println("A .Check Balance");
        System.out.println("B. Deposit");
        System.out.println("c.withdraw");
        System.out.println("D.Previous Transaction");
        System.out.println("E.Exit");



        do{
            System.out.println("==========");
            System.out.println("Enter an OPtion");
            System.out.println("====================");
            Option =sc.next().charAt(0);
            Character.toUpperCase(Option);
    
            switch (Option)
            {
                case 'A':
                    System.out.println("============");
                    System.out.println("Balance is:"+Balance);
                    System.out.println("========");
                    System.out.println();
                    break;
        
             case 'B':
                     System.out.println("====") ;
                     System.out.println("Enter The amount to deposit");
                     System.out.println("=========") ;
                     int amount =sc.nextInt();
                     deposit(amount);
                     System.out.println();
                     break;
        
              case 'C':
              System.out.println("====") ;
              System.out.println("Enter The amount to withdraw");
              System.out.println("=========") ;
              int amount2 =sc.nextInt();
              withdraw(amount2);
              System.out.println();
              break;
        
        
              case 'D':
                      System.out.println("=====");
                      getPreviousTransaction();
                      System.out.println("==========");
                      System.out.println();
                      break;
        
        
              case 'E':
                       System.out.println("===================")  ;
                       break;
                       default:
                       System.out.println("Invalid  Option please try Again Later");
                       break;
            }
        

        }
    }

}