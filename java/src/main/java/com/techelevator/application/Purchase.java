package com.techelevator.application;

import com.techelevator.models.Products;
import com.techelevator.models.QuipOutput;
import com.techelevator.ui.UserInput;

import java.math.BigDecimal;
import java.util.Scanner;

public class Purchase {
    public static void FeedMoney() {
        Products test2 = new Products();
        QuipOutput quipGrab = new QuipOutput();
        Scanner input = new Scanner(System.in);
        BigDecimal totalInput = new BigDecimal("0");
        BigDecimal remainingBalance = new BigDecimal("0");
        boolean keepLooping = true;

        UserInput.getPurchaseScreenOption();


        while (keepLooping) {
            String option = input.nextLine();
            if (option.equalsIgnoreCase("M")) {
                boolean enter = true;
                while (enter) {
                    System.out.println("Please input whole dollar amounts: $1 , $5, $10, $20, please enter (E) when you finish input.");
                    String inputAmount = input.nextLine();
                    if (!inputAmount.equalsIgnoreCase("E")) {
                        totalInput = totalInput.add(new BigDecimal(inputAmount));
                        System.out.println(" Current Money Provided: $" + totalInput);
                    } else {
                        enter = false;
                    }
                }
            }

            UserInput.getPurchaseScreenOption();
            System.out.println(" ");

            if(option.equalsIgnoreCase("S")) {
                System.out.println("Please enter a slot identifier to select an item:");
                Display.run();
                while(keepLooping) {
                    String userInput = input.nextLine().toUpperCase();
                    if (!test2.getMapOfItemAmount().containsKey(userInput)) {
                        //if the item doesn't exist returns the user to purchase menu.
                        System.out.println("Item not sold here. Please choose other item.");
                        keepLooping = false;
//                UserInput.getPurchaseScreenOption();

                    } else if (test2.getMapOfItemAmount().get(userInput) > 0) {
                        //adds item to cart
                        if (remainingBalance.compareTo(test2.getMapOfItemPrice().get(userInput)) < 0) {
                            remainingBalance = totalInput.subtract(test2.getMapOfItemPrice().get(userInput));
                            System.out.println(test2.getMapOfItemNames().get(userInput) + ", " + test2.getMapOfItemPrice().get(userInput) + ", remaining balance $" + remainingBalance);
                            System.out.println(quipGrab.getQuip(test2.getMapOfItemType().get(userInput)));
                            test2.reduceMapOfItemAmount(userInput);
                        } else {
                            System.out.println("Not enough money in the machine. Please input more money");
                        }

                    } else {
                        //tells the customer that the item is out of stock and returns to purchase menu
                        System.out.println("Stop trying to buy this item we are out of stock.");
                        keepLooping = false;

                    }
                    System.out.println("Do you want select more item? (Y)es. if Yes, please enter item slot number");
                    String more = input.nextLine();
                    String userInput2 = input.nextLine().toUpperCase();
                    if (more.equalsIgnoreCase("Y")) {
                        if (!test2.getMapOfItemAmount().containsKey(userInput2)) {
                            //if the item doesn't exist returns the user to purchase menu.
                            System.out.println("Item not sold here. Please choose other item.");
                            keepLooping = false;
//                UserInput.getPurchaseScreenOption();

                        } else if (test2.getMapOfItemAmount().get(userInput2) > 0) {
                            //adds item to cart
                            if (remainingBalance.compareTo(test2.getMapOfItemPrice().get(userInput2)) < 0) {
                                remainingBalance = remainingBalance.subtract((test2.getMapOfItemPrice().get(userInput2)).divide(new BigDecimal("2")));
                                System.out.println(test2.getMapOfItemNames().get(userInput2) + ", " + test2.getMapOfItemPrice().get(userInput2) + ", remaining balance $" + remainingBalance);
                                System.out.println(quipGrab.getQuip(test2.getMapOfItemType().get(userInput2)));
                                test2.reduceMapOfItemAmount(userInput2);
                            } else {
                                System.out.println("Not enough money in the machine. Please input more money");
                            }

                        } else {
                            //tells the customer that the item is out of stock and returns to purchase menu
                            System.out.println("Stop trying to buy this item we are out of stock.");
                            keepLooping = false;

                        }

                    } else{
                        keepLooping = false;

                    }
                }
            }


        }
    }
}


