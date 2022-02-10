package Project;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account{
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$' ###, ##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
    public Object get;

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(997523, 976344);
                data.put(997524, 976345);     //(Customer Number , PIN Number)
                data.put(997525, 976346);

                System.out.println("Welcome To the ATM Project");
                System.out.print("Enter your Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your PIN Number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("Invailid Charactors. Only Number.");
                x = 2;
            }

            //After sucessfully match this numbes>>>>>>>>>
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else
                System.out.println("\n"+"Wrong Customer Number or PIN Number"+"\n");
        } while (x == 1);
    }

    public void getAccountType() {

        System.out.println("Select the Account you want to Access: ");
        System.out.println("Type 1 - Current Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");


        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getCurrent();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("\n"+"Thank You for using ATM, Visit again."+"\n");
                break;

            default:
                System.out.println("\n"+"Invailid Choice"+"\n");
                getAccountType();
        }
    }

    public void getCurrent() {

        System.out.println("Current Account: ");
        System.out.println(" Type 1 - View Balance");
        System.out.println(" Type 2 - Withdraw Money");
        System.out.println(" Type 3 - Deposit Money");
        System.out.println(" Type 4 - Exit");
        System.out.print("Choice : ");

        int selection = menuInput.nextInt();


        switch (selection) {
            case 1: {
                System.out.println("Current Account Balance :" + moneyFormat.format(getSavingBalance()));
                getAccountType();
            }
            case 2: {
                getCurrentWithdrawInput();
                getAccountType();
            }
            case 3: {
                getCurrentDepositInput();
                getAccountType();
            }
            case 4: System.out.println("\n"+"Thank YOu for using the ATM, Visit Again."+"\n");

            default: System.out.println("\n"+"Invailid Choice."+"\n");
        }
    }

    public void getSaving () {

        System.out.println("Saving Account: ");
        System.out.println(" Type 1 - View Balance");
        System.out.println(" Type 2 - Withdraw Money");
        System.out.println(" Type 3 - Deposit Money");
        System.out.println(" Type 4 - Exit");
        System.out.print("Choice : ");

        int selection = menuInput.nextInt();


        switch (selection) {
            case 1: {
                System.out.println("Saving Account Balance :" + moneyFormat.format(getSavingBalance()));
                getAccountType();
            }
            case 2: {
                getSavingWithdrawInput();
                getAccountType();
            }
            case 3: {
                getSavingDepositInput();
                getAccountType();
            }
            case 4: System.out.println("\n"+"Thank YOu for using the ATM, Visit Again."+"\n");
            default: System.out.println("Invailid Choice.");
        }
    }

}
