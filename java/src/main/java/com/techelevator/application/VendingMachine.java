package com.techelevator.application;

import com.techelevator.models.Munchies;
import com.techelevator.models.Products;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine 
{
    public void run()
    {
        //Map<Character, Runnable> methodMap = new HashMap<Character, Runnable>();
        Map<String, Integer> displayMap = new HashMap<>();
        Map<String, String> locationAndName = new HashMap<>();
        Map<String, BigDecimal> locationAndPrice = new HashMap<>();
        Map<String, String> locationAndType = new HashMap<>();
        BigDecimal totalCost = new BigDecimal(0.00);
        BigDecimal balance = new BigDecimal(0.00);
        Scanner scan = new Scanner(System.in);

        int quarter = 0;
        int dime = 0;
        int nickel = 0;
        int penny = 0;
        File path = new File("catering.csv");
//        if (!path.exists()) {
//            System.out.println("file not found");
//            System.exit(0);
//        }
        try{
            Scanner FileInput = new Scanner(path);
            while(FileInput.hasNextLine()){
                String[] items = FileInput.nextLine().split(",");
                locationAndName.put(items[0], items[1]);
                locationAndPrice.put(items[0], new BigDecimal(items[2]));
                locationAndType.put(items[0], items[3]);
                displayMap.put(items[0], 6);
//                for (int i = 0; i < items.length; i++) {
//                    displayMap.put(items[1],6);
//                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("File is not exist");
        }


        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                // display the vending machine slots
                for (String key: locationAndName.keySet()) {
                    System.out.println(key + " " + locationAndName.get(key) + " " + locationAndPrice.get(key) + " " + locationAndType.get(key) + " " + displayMap.get(key));
                }
            }
            else if(choice.equals("purchase"))
            {
                while(true) {
                    // make a purchase
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Feed Money: M");
                    System.out.println("Select item: S");
                    System.out.println("Finish transaction: F");
                    String selection = scanner.nextLine();

                    if (selection.equalsIgnoreCase("m")) {
                        System.out.println("Please input whole dollar amounts: 1 , 5, 10, 20");
                        BigDecimal inputtedAmount = new BigDecimal(scanner.nextLine());
                        balance = balance.add(inputtedAmount);
                        System.out.println("Your balance is " + balance);

                    } else if (selection.equalsIgnoreCase("s")) {

                        System.out.println("What do you want?");
                        String demand = scanner.nextLine().toUpperCase();
                        // make contingency for false input
                        if (displayMap.get(demand) > 0) {
                            totalCost = totalCost.add(locationAndPrice.get(demand));
                            displayMap.put(demand, displayMap.get(demand)-1);
                            System.out.println(totalCost);

                        } else {
                            System.out.println("That item is out of stock.");
                        }

                    } else if (selection.equalsIgnoreCase("f") && balance.compareTo(totalCost) >= 0) {
                        System.out.println("Have a grate day!!");
                        balance = balance.subtract(totalCost);
                        balance = balance.multiply(new BigDecimal(100));
                        System.out.println(balance);


                        BigDecimal bigQuarter = new BigDecimal(25);
                        BigDecimal bigDime = new BigDecimal(10);
                        BigDecimal bigNickel = new BigDecimal(5);
                        BigDecimal bigPenny = new BigDecimal(1);



                        while (balance.compareTo(bigQuarter) >= 0) {
                            quarter++;
                            balance = balance.subtract(bigQuarter);
                        }
                        while (balance.compareTo(bigDime) >= 0) {
                            dime++;
                            balance = balance.subtract(bigDime);
                        }
                        while (balance.compareTo(bigNickel) >= 0) {
                            nickel++;
                            balance = balance.subtract(bigNickel);
                        }
                        while (balance.compareTo(bigPenny) >= 0) {
                            penny++;
                            balance = balance.subtract(bigPenny);
                        }
                        totalCost = new BigDecimal(0.00);
                        balance = new BigDecimal(0.00);

                        System.out.println("Here's your change: " + quarter + " quarters, " + dime + " dimes, " + nickel + " nickels, " + penny + " pennys");
                    }
                }
            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }
    
}
