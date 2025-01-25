
//import java.util.Scanner;
import java.util.*;

class ATM {
    float Balance;
    int PIN = 6789;

    public void checkPin() {
        System.out.println("Enter your PIN:");
        Scanner sc = new Scanner(System.in);
        int enteredpin = sc.nextInt();

        if (enteredpin == PIN)

        {
            menu();

        } else {
            System.out.println("Enter a valid PIN");
        }

    }

    public void menu() {
        System.out.println("Enter your choice:");
        System.out.println("1. check A/C Balance");
        System.out.println("2.Withdraw Money");
        System.out.println("3.deposite Money");
        System.out.println("4.EXIT");

        Scanner sc = new Scanner(System.in);
        int otp = sc.nextInt();

        if (otp == 1) {
            checkBalance();
        } else if (otp == 2) {
            WithdrawMoney();

        } else if (otp == 3) {
            depositMoney();
        }

        else if (otp == 4) {
            return;
        } else {
            System.out.println("Enter a Valid Number");

        }
    }

    public void checkBalance() {
        System.out.println("Balance:=" + Balance);
        menu();
    }

    public void WithdrawMoney() {
        System.out.println("Enter Your Amount to  withdraw:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        if (amount > Balance) {
            System.out.println("Insufficient Balance:");
        } else {
            Balance = Balance - amount;
            System.out.println("Money Withdraw Successfully");

        }
        menu();

    }

    public void depositMoney() {
        System.out.println("Enter the Amount");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        Balance = Balance + amount;
        System.out.println("Money Deposit Successfully");
        menu();
    }

}

public class ATM_MACHINE {
    public static void main(String args[]) {

        ATM obj = new ATM();
    }
}
