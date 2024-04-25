package com.pluralsight;

//importing the scanner for user input
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String timestamp = LocalDateTime.now().format(formatter);



                            // New entry for deposits if a valid entry with | is used
                            depoWriter.write(timestamp + " | Deposit | " + input4Deposit);
                            depoWriter.newLine();
                            depoWriter.close();

                            System.out.println("\n\n\nSuccessfully Added Deposit Information!");
                            System.out.println("Returning Home...\n\n");
                            // Breaks out of loop to home screen
                            break;

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
            else if (homeInput.equalsIgnoreCase("P")){



            }
            else if (homeInput.equalsIgnoreCase("L")){



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

