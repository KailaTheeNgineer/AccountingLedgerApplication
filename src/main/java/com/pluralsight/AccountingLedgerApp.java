package com.pluralsight;

//importing the scanner for user input
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
                            // Allowing for system to write to a file and append is saving the info instaed of overwrite
                            FileWriter depoWrite = new FileWriter("src/main/resources/transactions.csv", true);
                            BufferedWriter depoWriter = new BufferedWriter(depoWrite);
                            // Allowing for the date and time of the entry to be entered
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
                            String timestamp = LocalDateTime.now().format(formatter);



                            // New entry for deposits if a valid entry with | is used
                            depoWriter.write(timestamp + " | Deposit | " + input4Deposit);
                            depoWriter.newLine();
                            depoWriter.close();

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
                    } else if (input4Debit.contains("|")) {
                        try {
                            // Allowing for system to write to a file and append is saving the info instaed of overwrite
                            FileWriter debitWrite = new FileWriter("src/main/resources/transactions.csv", true);
                            BufferedWriter debitWriter = new BufferedWriter(debitWrite);
                            // Allowing for the date and time of the entry to be entered
                            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String timestamp2 = LocalDateTime.now().format(formatter2);


                            // New entry for deposits if a valid entry with | is used
                            debitWriter.write(timestamp2 + " | Deposit | " + input4Debit);
                            debitWriter.newLine();
                            debitWriter.close();

                            System.out.println("\n\n\nSuccessfully Recorded Debit Information!");
                            System.out.println("(R) Return Home\n(P) Enter another Debit entry");
                            Scanner mouse = new Scanner(System.in);
                            String afterDebit = mouse.nextLine();

                            if (afterDebit.equalsIgnoreCase("R")) {

                                // Breaks out of loop to home screen
                                break;

                            } else if (afterDebit.equalsIgnoreCase("P")) {

                                // Allows user to input another debit entry
                                paymentScreen = true;
                            }

                        } catch (IOException e) {

                            e.printStackTrace();
                        }

                    }
                    // Statement to try again if invalid input is entered
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

                            FileInputStream readAll = null;

                            try {

                                // Reads transactions.csv and displays all entries to user
                                readAll = new FileInputStream("src/main/resources/transactions.csv");
                                Scanner readTransactions = new Scanner(readAll);
                                String allTransactions;

                                while (readTransactions.hasNextLine()) {
                                    allTransactions = readTransactions.nextLine();
                                    System.out.println(allTransactions);

                                    readTransactions.close();

                                    System.out.println("Press any key to return to ledger screen");
                                    Scanner newScanner = new Scanner(System.in);
                                    String input = newScanner.nextLine();
                                    if (input.equalsIgnoreCase("R")) {
                                    break;
                                        // Interesting piece of code
                                        // Because it makes sure that any key can return back instead of
                                        // (R) or (X)
                                    } else {
                                        break;

                                    }

                                }

                            } catch (FileNotFoundException e) {
                                throw new RuntimeException(e);

                            }  break; // goes back to ledger screen if user enters (R)
                        }
                    } else if (ledger.equalsIgnoreCase("D")) {



                    } else if (ledger.equalsIgnoreCase("P")) {



                    } else if (ledger.equalsIgnoreCase("R")) {



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

