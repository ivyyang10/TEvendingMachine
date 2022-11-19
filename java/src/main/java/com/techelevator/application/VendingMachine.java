package com.techelevator.application;


import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;


public class VendingMachine 
{
    public void run()
    {

        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display")) {
                Display.run();
                // display the vending machine slots
            }
            else if(choice.equals("purchase"))
            {  Purchase.FeedMoney();

            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }
    
}
