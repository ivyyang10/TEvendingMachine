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
        BigDecimal Balance = new BigDecimal("0");
        boolean keepLooping = true;


        while (keepLooping) {
            UserInput.getPurchaseScreenOption();

            String option = input.nextLine();
            if (option.equalsIgnoreCase("M")) {
                boolean enter = true;
                while (enter) {
                    System.out.println("Please input whole dollar amounts: $1 , $5, $10, $20, please enter (E) when you finish input.");
                    String inputAmount = input.nextLine();
                    if (!inputAmount.equalsIgnoreCase("E")) {
                        Balance = Balance.add(new BigDecimal(inputAmount));
                        System.out.println(" Current Money Provided: $" + Balance);
                    } else {
                        enter = false;
                    }
                }

            }


            if (option.equalsIgnoreCase("S")) {
                boolean isContinue=true;

                Display.run();
                while(isContinue) {
                    System.out.println("Please enter a slot identifier to select an item:");
                    String userInput = input.nextLine().toUpperCase();
                    if (!test2.getMapOfItemAmount().containsKey(userInput)) {
                        //if the item doesn't exist returns the user to purchase menu.
                        System.out.println("Item not sold here. Please choose other item.");


                    } else if (test2.getMapOfItemAmount().get(userInput) > 0) {
                        //adds item to cart
                        if (Balance.compareTo(test2.getMapOfItemPrice().get(userInput)) > 0) {
                            Balance = Balance.subtract(test2.getMapOfItemPrice().get(userInput));
                            System.out.println(test2.getMapOfItemNames().get(userInput) + ", " + test2.getMapOfItemPrice().get(userInput) + ", remaining balance $" + Balance);
                            System.out.println(quipGrab.getQuip(test2.getMapOfItemType().get(userInput)));
                            test2.reduceMapOfItemAmount(userInput);
                        } else {
                            System.out.println("Not enough money in the machine. Please input more money");
                        }

                    } else {
                        //tells the customer that the item is out of stock and returns to purchase menu
                        System.out.println("Stop trying to buy this item we are out of stock.");

                    }
                    System.out.println("Do you want select more item? (Y)es.");
                    String more = input.nextLine();
                    if (more.equalsIgnoreCase("Y")) {
                        System.out.println("Please enter item slot number.");
                        String userInput2 = input.nextLine().toUpperCase();
                        if (!test2.getMapOfItemAmount().containsKey(userInput2)) {
                            //if the item doesn't exist returns the user to purchase menu.
                            System.out.println("Item not sold here. Please choose other item.");

                        } else if (test2.getMapOfItemAmount().get(userInput2) > 0) {
                            //adds item to cart
                            if (Balance.compareTo(test2.getMapOfItemPrice().get(userInput2)) > 0) {
                                Balance = Balance.subtract((test2.getMapOfItemPrice().get(userInput2).subtract(new BigDecimal("1"))));
                                System.out.println(test2.getMapOfItemNames().get(userInput2) + ", " + test2.getMapOfItemPrice().get(userInput2) + ", remaining balance $" + Balance);
                                System.out.println(quipGrab.getQuip(test2.getMapOfItemType().get(userInput2)));
                                test2.reduceMapOfItemAmount(userInput2);

                            } else {
                                System.out.println("Not enough money in the machine. Please input more money");
                            }

                        } else {
                            //tells the customer that the item is out of stock and returns to purchase menu
                            System.out.println("Stop trying to buy this item we are out of stock.");

                        }
                        System.out.println("Do you want select more item? (Y)es.");
                        String again = input.nextLine();
                        if (!again.equalsIgnoreCase("Y")) {
                            isContinue = false;
                        }
                    }else{ isContinue = false;}
                }

            }



            if (option.equalsIgnoreCase("F")) {

                //Please edit this part. we only have this and audit file left.



            }

        }
    }
}

