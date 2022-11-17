package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;


import java.io.File;
import java.io.FileNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine 
{
    public void run()
    {
        Map<String, Integer> displayMap = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        File path = new File("catering.csv");
        if (!path.exists()) {
            System.out.println("file not found");
            System.exit(0);
        }
        try{
            Scanner FileInput = new Scanner(path);
            while(FileInput.hasNextLine()){
                String[] items = FileInput.nextLine().split(",");
                for (int i = 0; i < items.length; i++) {
                    displayMap.put(items[1],6);
                }


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
            }
            else if(choice.equals("purchase"))
            {
                // make a purchase
            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }
    
}
