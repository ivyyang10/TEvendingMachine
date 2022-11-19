package com.techelevator.application;

import com.techelevator.models.Products;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Display {
    public static void run() {

        Products test = new Products();


        File menu = new File("catering.csv");
        Scanner fileInput;

        {
            try {
                fileInput = new Scanner(menu);
                while (fileInput.hasNextLine()) {
                    String line = fileInput.nextLine();
                    System.out.println(line +","+ test.getQuantity());
                }

            } catch (FileNotFoundException e) {
                System.out.println("file is not exist");
            }
        }





    }

}
