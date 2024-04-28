package com.pluralsight;

// importing packages for scanner, date, date formatters, and exceptions
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AccountingLedgerApp {
    public static void main(String[] args) {
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
                        break; }

                    else if (input4Deposit.contains("|")) {
                        try {
                            // Allowing for system to write to a file and append is saving the info instead of overwriting for transactions.csv
                            FileWriter depoWrite = new FileWriter("src/main/resources/transactions.csv", true);
                            BufferedWriter depoWriter = new BufferedWriter(depoWrite);

                            // Allowing for system to write to a file and append is saving the info instead of overwriting for deposits.csv
                            FileWriter depo2Write = new FileWriter("src/main/resources/deposits.csv", true);
                            BufferedWriter depo2Writer = new BufferedWriter(depo2Write);


                            // Allowing for the date and time of the entry to be entered
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                            DateTimeFormatter formatter33 = DateTimeFormatter.ofPattern("hh:mm:ss");
                            String datestamp22 = LocalDateTime.now().format(formatter);
                            String timestamp22 = LocalDateTime.now().format(formatter33);

                            // New entry for deposits if a valid entry with | is used for transactions.csv
                            depoWriter.write(datestamp22 + " | " + timestamp22 + " | " + input4Deposit);
                            depoWriter.newLine();
                            depoWriter.close();

                            // New entry for deposits if a valid entry with | is used for deposits.csv
                            depo2Writer.write(datestamp22 + " | " + timestamp22 + " | " + input4Deposit);
                            depo2Writer.newLine();
                            depo2Writer.close();


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



            }
            else if (homeInput.equalsIgnoreCase("P")) {
                boolean paymentScreen = true;

                while (paymentScreen) {
                    System.out.println("Enter (R) to return Home\n");
                    Scanner debitScanner = new Scanner(System.in);
                    System.out.println("Enter your Debit information in the following format:\n" +
                            "[Description] | Vendor | Amount");
                    String input4Debit = debitScanner.nextLine();

                    // if statement for user to go back home from debit screen
                    if (input4Debit.equalsIgnoreCase("R")) {
                        break;
                        // Note to self: Not the best way of collecting data, by detecting a "|" character
                        // Could find a better way to represent this value
                    } else if (input4Debit.contains("|")) {
                        try {
                            // Allowing for system to write to a file and append is saving the info instead of overwrite for transactions.csv
                            FileWriter debitWrite = new FileWriter("src/main/resources/transactions.csv", true);
                            BufferedWriter debitWriter = new BufferedWriter(debitWrite);

                            // Allowing for system to write to a file and append is saving the info instead of overwrite for debits.csv
                            FileWriter debit2Write = new FileWriter("src/main/resources/debits.csv", true);
                            BufferedWriter debit2Writer = new BufferedWriter(debit2Write);

                            // Allowing for the date and time of the entry to be entered
                            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                            DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("hh:mm:ss");
                            String datestamp2 = LocalDateTime.now().format(formatter2);
                            String timestamp2 = LocalDateTime.now().format(formatter3);


                            // New entry for deposits if a valid entry with | is used for transactions.csv
                            debitWriter.write(datestamp2 + " | " + timestamp2 + " | " + input4Debit);
                            debitWriter.newLine();
                            debitWriter.close();

                            // New entry for deposits if a valid entry with | is used for debits.csv
                            debit2Writer.write(datestamp2 + " | " + timestamp2 + " | " + input4Debit);
                            debit2Writer.newLine();
                            debit2Writer.close();

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

                            try {

                                // Reads transactions.csv and displays all entries to user
                                FileReader readAll = new FileReader("src/main/resources/transactions.csv");
                                BufferedReader buffReader = new BufferedReader(readAll);

                                String allTransactions;

                                while ((allTransactions = buffReader.readLine()) != null) {
                                    System.out.println(allTransactions);

                                } buffReader.close();

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

                            } catch (IOException e) {
                                e.printStackTrace();

                            }  break; // goes back to ledger screen if user enters (R)
                        }
                    } else if (ledger.equalsIgnoreCase("D")) {

                        // While statement to exit out of Deposit entry screen
                        boolean allDepositEntries = true;
                        while (allDepositEntries) {try {

                            // Reads deposits.csv and displays all entries to user
                            FileReader readAll = new FileReader("src/main/resources/deposits.csv");
                            BufferedReader buffReader = new BufferedReader(readAll);

                            String allTransactions;

                            while ((allTransactions = buffReader.readLine()) != null) {
                                System.out.println(allTransactions);

                            } buffReader.close();

                            System.out.println("Enter any key to return to ledger screen");
                            Scanner newScanner = new Scanner(System.in);
                            String input = newScanner.nextLine();
                            if (input.equalsIgnoreCase("R")) {
                                break;

                            } else {
                                break;

                            }

                        } catch (IOException e) {
                            e.printStackTrace();

                        } break; // exits out of deposit screen back to ledger screen



                        }



                    } else if (ledger.equalsIgnoreCase("P")) {
                        boolean debitScreen = true;
                        // While statement to exit out of debit screen
                        while (debitScreen) {

                            try {

                            // Reads debits.csv and displays all entries to user
                            FileReader read1All = new FileReader("src/main/resources/debits.csv");
                            BufferedReader buffReader = new BufferedReader(read1All);

                            String all1Transactions;

                            while ((all1Transactions = buffReader.readLine()) != null) {
                                System.out.println(all1Transactions);

                            } buffReader.close();

                            System.out.println("Enter any key to return to ledger screen");
                            Scanner newScanner = new Scanner(System.in);
                            String input = newScanner.nextLine();
                            if (input.equalsIgnoreCase("R")) {
                                break;

                            } else {
                                break;

                            }

                        } catch (IOException e) {
                            e.printStackTrace();

                        }


                        }



                    } else if (ledger.equalsIgnoreCase("R")) {


                    } else if (ledger.equalsIgnoreCase("H")) {
                        // Exit ledger screen and go back to home screen
                        break;



                    } else { System.out.println("Please Select A Valid Option");

                    }



                }
            }
            else if (homeInput.equalsIgnoreCase("X")){

                // Command to exit the application
                break;



            }
            else {
                // if a valid option isn't chosen, System alerts the user, then runs homescreen()
                // so they can try again
                System.out.println("Please Select A Valid Option");
                homescreen(true);

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
    private static void homescreen(boolean b) {
    }


}

