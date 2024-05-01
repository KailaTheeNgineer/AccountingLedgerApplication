package com.pluralsight;

// importing packages for scanner, date, date formatters, and exceptions
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AccountingLedgerApp {
    public static void main(String[] args) {

        // Creating the array to access later in ledger for deposits only
        ArrayList<LedgerTransact> deposits = new ArrayList<>();
        // Creating pre-saved object info for deposits only
        LedgerTransact id1 = new LedgerTransact("2024/04/28", "04:34:54", "Youtube", "Adsense", 2500);
        LedgerTransact id2 = new LedgerTransact("2024/04/28", "04:35:35", "Gas money", "Cashapp", 150);
        LedgerTransact id6 = new LedgerTransact("2024/05/01", "06:35:35", "Youtube", "Adsense", 3000);
        LedgerTransact id8 = new LedgerTransact("2023/07/07", "22:03:11", "Payroll", "Sephora", 543.76);
        // Adding the objects to the deposits array
        deposits.add(id1);
        deposits.add(id2);
        deposits.add(id6);
        deposits.add(id8);

        // Creating the array to access later in ledger for debits only
        ArrayList<LedgerTransact> debits = new ArrayList<LedgerTransact>();
        LedgerTransact id3 = new LedgerTransact("2024/04/28", "04:35:54", "iPhone 15", "Apple", -876.98);
        LedgerTransact id4 = new LedgerTransact("2024/04/17", "04:36:18", "Food for Thought", "Amazon", -7.77);
        LedgerTransact id5 = new LedgerTransact("2024/03/21", "04:36:18", "Noble Crust", "Doordash", -69.72);
        LedgerTransact id7 = new LedgerTransact("2023/02/31", "16:34:12", "Classic Handbag", "Chanel", -567.89);
        LedgerTransact id9 = new LedgerTransact("2024/05/02", "07:02:33", "Lipgloss", "Fenty", -20.43);
        debits.add(id3);
        debits.add(id4);
        debits.add(id5);
        debits.add(id7);
        debits.add(id9);


        // Creating the array to access later in ledger for all transactions
        ArrayList<LedgerTransact> allTransactionsList = new ArrayList<>();
        LedgerTransact id11 = new LedgerTransact("2024/04/28", "04:34:54", "Youtube", "Adsense", 2500);
        LedgerTransact id22 = new LedgerTransact("2024/04/28", "04:35:35", "Gas money", "Cashapp", 150);
        LedgerTransact id33 = new LedgerTransact("2024/04/28", "04:35:54", "iPhone 15", "Apple", -876.98);
        LedgerTransact id44 = new LedgerTransact("2024/04/17", "04:36:18", "Food for Thought", "Amazon", -7.77);
        LedgerTransact id55 = new LedgerTransact("2024/03/21", "04:36:18", "Noble Crust", "Doordash", -69.72);
        LedgerTransact id66 = new LedgerTransact("2024/05/01", "06:35:35", "Youtube", "Adsense", 3000);
        LedgerTransact id77 = new LedgerTransact("2023/02/31", "16:34:12", "Classic Handbag", "Chanel", -567.89);
        LedgerTransact id88 = new LedgerTransact("2023/07/07", "22:03:11", "Payroll", "Sephora", 543.76);
        LedgerTransact id99 = new LedgerTransact("2024/05/02", "07:02:33", "Lipgloss", "Fenty", -20.43);
        // Adding the objects to the allTransactions array
        allTransactionsList.add(id11);
        allTransactionsList.add(id22);
        allTransactionsList.add(id33);
        allTransactionsList.add(id44);
        allTransactionsList.add(id55);
        allTransactionsList.add(id66);
        allTransactionsList.add(id77);
        allTransactionsList.add(id88);
        allTransactionsList.add(id99);



        // While loop that initiates the ability to close out of the entire app
        boolean homescreen = true;
        while (homescreen) {
            System.out.println("Account Ledger Home Screen\nTo begin, Select an option:\n");
            System.out.println("(D) Add Deposit\n(P) Make Debit Payment\n(L) Ledger\n(X) Exit");
            Scanner myScanner = new Scanner(System.in);


            String homeInput = myScanner.nextLine();
            if (homeInput.equalsIgnoreCase("D")) {


                boolean depositScreen = true;
                while (depositScreen) {

                    System.out.println("Enter (R) to return Home\n");
                    Scanner depositScanner = new Scanner(System.in);
                    System.out.println("Enter your deposit information in the following format:\n" +
                            "[Description] | Vendor | Amount");
                    String input4Deposit = depositScanner.nextLine();

                    // if statement for user to go back home
                    if (input4Deposit.equalsIgnoreCase("R")) {
                        break;
                    } else if (input4Deposit.contains("|")) {
                        try {
                            // Allowing for system to write to a file and append is saving the info instead of overwriting for transactions.csv
                            FileWriter depoWrite = new FileWriter("src/main/resources/transactions.csv", true);
                            BufferedWriter depoWriter = new BufferedWriter(depoWrite);


                            // Allowing for the date and time of the entry to be entered
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                            DateTimeFormatter formatter33 = DateTimeFormatter.ofPattern("HH:mm:ss");
                            String datestamp22 = LocalDateTime.now().format(formatter);
                            String timestamp22 = LocalDateTime.now().format(formatter33);


                            // New entry for deposits if a valid entry with | is used for transactions.csv
                            depoWriter.write(datestamp22 + " | " + timestamp22 + " | " + input4Deposit);
                            depoWriter.newLine();
                            depoWriter.close();

                            // Parsing information in input4deposit to add to object
                            String[] splitdeposit = input4Deposit.split("\\|");
                            String description = splitdeposit[0];
                            String vendor = splitdeposit[1];
                            double amount = Double.parseDouble(splitdeposit[2]);

                            // Creating an object out of the new information
                            LedgerTransact inputDeposit = new LedgerTransact(datestamp22, timestamp22, description, vendor, amount);

                            // Adding the object to the deposit array
                            deposits.add(inputDeposit);
                            // Adding it to allTransactions array
                            allTransactionsList.add(inputDeposit);


                            System.out.println("\n\n\nSuccessfully Added Deposit Information!");
                            System.out.println("(R) Return Home\n(D) Enter another Deposit");

                            Scanner mouse1 = new Scanner(System.in);
                            String afterDeposit = mouse1.nextLine();

                            if (afterDeposit.equalsIgnoreCase("R")) {

                                // Breaks out of loop to home screen
                                break;

                            } else if (afterDeposit.equalsIgnoreCase("D")) {

                                // Allows user to input another debit entry
                                depositScreen = true;
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }

                    }
                    // Statement to try again if invalid input is entered
                    else {

                        System.out.println("Please Select A Valid Option");
                        depositScreen = true;
                    }

                }


            } else if (homeInput.equalsIgnoreCase("P")) {
                boolean paymentScreen = true;

                while (paymentScreen) {
                    System.out.println("Enter (R) to return Home\n");
                    Scanner debitScanner = new Scanner(System.in);
                    System.out.println("Enter your Debit information in the following format:\n" +
                            "[Description] | Vendor | -Amount");
                    String input4Debit = debitScanner.nextLine();

                    // if statement for user to go back home from debit screen
                    if (input4Debit.equalsIgnoreCase("R")) {
                        break;

                    } else if (input4Debit.contains("|")) {
                        try {
                            // Allowing for system to write to a file and append is saving the info instead of overwrite for transactions.csv
                            FileWriter debitWrite = new FileWriter("src/main/resources/transactions.csv", true);
                            BufferedWriter debitWriter = new BufferedWriter(debitWrite);

                            // Allowing for the date and time of the entry to be entered
                            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                            DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("HH:mm:ss");
                            String datestamp2 = LocalDateTime.now().format(formatter2);
                            String timestamp2 = LocalDateTime.now().format(formatter3);


                            // New entry for deposits if a valid entry with | is used for transactions.csv
                            debitWriter.write(datestamp2 + " | " + timestamp2 + " | " + input4Debit);
                            debitWriter.newLine();
                            debitWriter.close();

                            // Parsing information in input4debit to add to object
                            String[] splitdebit = input4Debit.split("\\|");
                            String description = splitdebit[0];
                            String vendor = splitdebit[1];
                            double amount = Double.parseDouble(splitdebit[2]);

                            // Creating an object out of the new information
                            LedgerTransact inputDebit = new LedgerTransact(datestamp2, timestamp2, description, vendor, amount);

                            // Adding the object to the debit array
                            deposits.add(inputDebit);
                            // Adding it to allTransactions array
                            allTransactionsList.add(inputDebit);


                            System.out.println("\n\n\nSuccessfully Recorded Debit Information!");
                            System.out.println("(R) Return Home\n(P) Enter another Debit entry");
                            Scanner mouse = new Scanner(System.in);
                            String afterDebit = mouse.nextLine();

                            if (afterDebit.equalsIgnoreCase("R")) {

                                // Breaks out of successful debit entry back to home screen
                                break;

                            } else if (afterDebit.equalsIgnoreCase("P")) {

                                // Allows user to input another debit entry
                                paymentScreen = true;
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }

                    }
                    // Ending statement to try again when invalid input on debit info is entered
                    else {

                        System.out.println("Please Select A Valid Option");
                        paymentScreen = true;
                    }


                }
            } else if (homeInput.equalsIgnoreCase("L")) {

                boolean ledgerScreen = true;

                while (ledgerScreen) {


                    System.out.println("Welcome to the Ledger: \n");
                    System.out.println("(A) Display All Entries \n(D) Display Deposit Entries");
                    System.out.println("(P) Display Payments \n(R) Reports \n(H) Return Home");
                    Scanner scanner2 = new Scanner(System.in);
                    String ledger = scanner2.nextLine();

                    // if statements to begin the options for ledger screen
                    if (ledger.equalsIgnoreCase("A")) {
                        boolean runAllEntries = true;
                        while (runAllEntries) {

                            // Sorts it by desc order before displaying
                            Collections.sort(allTransactionsList, new Comparator<LedgerTransact>() {
                                public int compare(LedgerTransact o1, LedgerTransact o2) {

                                    return o2.getDate().compareTo(o1.getDate());
                                }
                            });
                            for (int i = 0; i < allTransactionsList.size(); i++) {

                                System.out.print(allTransactionsList.get(i).getDate() + " | " + allTransactionsList.get(i).getTime()
                                        + " | " + allTransactionsList.get(i).getDescription() + " | " + allTransactionsList.get(i).getVendor() + " | ");
                                System.out.printf("$%.2f\n", allTransactionsList.get(i).getAmount());
                            }

                            System.out.println("Enter any key to return to ledger screen");
                            Scanner newScanner = new Scanner(System.in);
                            String input = newScanner.nextLine();
                            if (input.equalsIgnoreCase("R")) {
                                break;
                                // Interesting piece of code
                                // Because the if and else statements are also identical
                            } else {
                                break;

                            }
                        }
                    } else if (ledger.equalsIgnoreCase("D")) {

                        // While statement to exit out of Deposit entry screen
                        boolean allDepositEntries = true;
                        while (allDepositEntries) {

                            // Sorts it by desc order before displaying
                            Collections.sort(deposits, new Comparator<LedgerTransact>() {
                                public int compare(LedgerTransact o1, LedgerTransact o2) {

                                    return o2.getDate().compareTo(o1.getDate());
                                }
                            });
                            for (int i = 0; i < deposits.size(); i++) {

                                System.out.print(deposits.get(i).getDate() + " | " + deposits.get(i).getTime()
                                        + " | " + deposits.get(i).getDescription() + " | " + deposits.get(i).getVendor() + " | ");
                                System.out.printf("$%.2f\n", deposits.get(i).getAmount());
                            }
                            System.out.println("Enter any key to return to ledger screen: ");
                            String newinput = myScanner.nextLine();
                            if (newinput.equalsIgnoreCase("R")) {
                                break;
                            } else {

                                break;

                            }


                        }


                    } else if (ledger.equalsIgnoreCase("P")) {
                        boolean debitScreen = true;
                        // While statement to exit out of debit screen
                        while (debitScreen) {
                            // Sorts it by desc order before displaying
                            Collections.sort(debits, new Comparator<LedgerTransact>() {
                                public int compare(LedgerTransact o1, LedgerTransact o2) {

                                    return o2.getDate().compareTo(o1.getDate());
                                }
                            });
                            for (int i = 0; i < debits.size(); i++) {
                                System.out.print(debits.get(i).getDate() + " | " + debits.get(i).getTime()
                                        + " | " + debits.get(i).getDescription() + " | " + debits.get(i).getVendor() + " | ");
                                System.out.printf("$%.2f\n", debits.get(i).getAmount());
                            }
                            System.out.println("Enter any key to return to ledger screen: ");
                            String newinput = myScanner.nextLine();
                            if (newinput.equalsIgnoreCase("R")) {
                                break;
                            } else {

                                break;

                            }
                        }


                    } else if (ledger.equalsIgnoreCase("R")) {

                        // Boolean to exit from report screen
                        boolean reportScreen = true;
                        while (reportScreen) {

                            System.out.println("Generate a Report: ");
                            System.out.println("   1) Month to Date\n   2) Previous Month\n   3) Year to Date\n   4) Previous Year   \n   5) Search vendor");
                            System.out.println("0) Back");
                            // Accepting user input for report screen
                            String reportInput = myScanner.nextLine();


                            if (reportInput.equals("1")) {
                                // For loop to access month-date entries
                                for (LedgerTransact monthTransact : allTransactionsList) {

                                    // Creating local date variables so that I can grab information from specific months

                                    LocalDate transactionDate = LocalDate.parse(monthTransact.getDate(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                                    LocalDate nowDate = LocalDate.now();

                                    // look through comparison to bring up current month's values
                                    if (transactionDate.getMonthValue() == nowDate.getMonthValue()) {

                                        // Sorts it by desc order before displaying
                                        Collections.sort(allTransactionsList, new Comparator<LedgerTransact>() {
                                            public int compare(LedgerTransact o1, LedgerTransact o2) {

                                                return o2.getDate().compareTo(o1.getDate());
                                            }
                                        });

                                        System.out.print(monthTransact.getDate() + " | " + monthTransact.getTime()
                                                + " | " + monthTransact.getDescription() + " | " + monthTransact.getVendor() + " | ");
                                        System.out.printf("$%.2f\n", monthTransact.getAmount());
                                        // Statement to exit loop back to report screen
                                        System.out.println("Enter any key to go back");
                                        Scanner mouse = new Scanner(System.in);
                                        String finishedInput = mouse.nextLine();
                                        if (finishedInput.equalsIgnoreCase("R")) {
                                            break;
                                        } else {
                                            break;
                                        }

                                    }

                            }




                            } else if (reportInput.equals("2")) {

                                for (LedgerTransact previousmnthTransact : allTransactionsList) {

                                    // Creating local date variables so that I can grab information from previous months

                                    LocalDate transactionMonth = LocalDate.parse(previousmnthTransact.getDate(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                                    LocalDate nowDate = LocalDate.now();


                                    // look through comparison to bring up current month's values, subtracting 1 to get previous month
                                    if (transactionMonth.getMonthValue() == (nowDate.getMonthValue() - 1)) {

                                        System.out.print(previousmnthTransact.getDate() + " | " + previousmnthTransact.getTime()
                                                + " | " + previousmnthTransact.getDescription() + " | " + previousmnthTransact.getVendor() + " | ");
                                        System.out.printf("$%.2f\n", previousmnthTransact.getAmount());

                                    }
                                }
                                    // Statement to exit loop back to report screen
                                    System.out.println("Enter any key to go back");
                                    Scanner mouse = new Scanner(System.in);
                                    String finishedInput = mouse.nextLine();
                                    if (finishedInput.equalsIgnoreCase("R")) {
                                        break;
                                    } else {
                                        break;
                                    }




                            } else if (reportInput.equals("3")) {


                            } else if (reportInput.equals("4")) {


                            } else if (reportInput.equals("5")) {


                            } else if (reportInput.equals("0")) {


                            } else {


                            }
                        }


                    } else if (ledger.equalsIgnoreCase("H")) {
                        // Exit ledger screen and go back to home screen
                        break;


                    } else {
                        System.out.println("Please Select A Valid Option");

                    }


                }
            } else if (homeInput.equalsIgnoreCase("X")) {

                // Command to exit the application
                break;


            } else {
                // if a valid option isn't chosen, System alerts the user, then runs homescreen()
                // so they can try again
                System.out.println("Please Select A Valid Option");
                homescreen();

            }
            // used to exit application if the homescreen loop is broken via homeInput
            // Interesting piece of code #2 because I made an exit method instead of using System.exit(0)
            exit();

        }


    }


    // This method allows for user to exit application
    private static void exit() {
    }

    // This method returns to the homescreen by making the homescreen variable true
    private static void homescreen() {
    }

}