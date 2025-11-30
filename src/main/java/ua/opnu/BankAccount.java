package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee = 0.0;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void setTransactionFee(double fee) {
        if (fee >= 0) {
            this.transactionFee = fee;
        }
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
    }

    double getBalance() {
        return this.balance;
    }

    boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }

        double totalAmountToWithdraw = amount + transactionFee;

        if (balance >= totalAmountToWithdraw) {
            balance = balance - totalAmountToWithdraw;
            return true;
        }

        return false;
    }

    boolean transfer(BankAccount receiver, double amount) {
        if (receiver == null || amount <= 0) {
            return false;
        }

        double totalAmountToWithdraw = amount + transactionFee;

        if (balance >= totalAmountToWithdraw) {
            this.balance -= totalAmountToWithdraw;
            receiver.deposit(amount);
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return name + ", баланс: " + balance;
    }
}