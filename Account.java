package Project;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance=0;
    private double savingBalance=0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");


    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public double getCurrentBalance() {
        return checkingBalance;
    }


    public double getSavingBalance() {
        return savingBalance;
    }

    /* Calculate Withdraw Amount */
    public double calcCurrentWithdraw(double amount){
        checkingBalance = (checkingBalance-amount);
        return checkingBalance;
    }


    /* Calculate Saving Amount */
    public double calcSavingBalance(double amount){
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }


    /* Calculate Saving Withdarw Amount */
    public double calcSavingWithdraw(double amonut){
        savingBalance = (savingBalance - amonut);
        return savingBalance;
    }


    /* Calculate Deposite Amount */
    public double calcCurrentDeposit(double amount){
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }


    /* Calculate Saving Deposite Amount */
    public double calcSavingDeposit(double amount){
        savingBalance = (savingBalance+amount);
        return savingBalance;
    }



    public void getCurrentWithdrawInput(){
        System.out.println("Current Account Balance : " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from Current Account: ");
        double amount = input.nextDouble();

        if((checkingBalance-amount) >=0) {
            calcCurrentWithdraw(amount);
            System.out.println("New Current Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance Cannot be Negative.");
        }
    }


    public void getSavingWithdrawInput(){
        System.out.println("Saving. Account Balance: "+ moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from saving Account.");
        double amount = input.nextDouble();

        if((checkingBalance-amount)>=0){
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance Cannot be Negative");
        }
    }


    public void getCurrentDepositInput(){
        System.out.println("Current Account Balance : "+ moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to Deposit from Current Account:  ");
        double amount = input.nextDouble();

        if((checkingBalance + amount)>=0){
            calcCurrentDeposit(amount);
            System.out.println("New Current Account Balance: "+ moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance Cannot be Negative.");
        }
    }


    public void getSavingDepositInput(){
        System.out.println("Saving Account Balance: "+ moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from saving account:");
        double amount=input.nextDouble();

        if((checkingBalance-amount)>=0){
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: "+ moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance Cannot be Negative.");
        }
    }
}

