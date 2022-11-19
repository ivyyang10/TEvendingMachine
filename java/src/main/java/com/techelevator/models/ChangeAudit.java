package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class ChangeAudit {
    public void addingToAuditFileChange(BigDecimal input1){
        Format today = new SimpleDateFormat("MM/dd/yyyy");
        LocalTime localTime = LocalTime.now();

        File writingFile = new File("audit.txt");

        try (PrintWriter outputFile = new PrintWriter(new FileOutputStream(writingFile, true))){

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            BigDecimal output1 = input1.setScale(2, RoundingMode.HALF_UP);



            int positionAdjustmentForBalanceInout1 = output1.signum() == 0 ? 1 : output1.precision() - output1.scale();


            String strDate = today.format(new Date());


            String moneySpacing1 = "        ".substring(positionAdjustmentForBalanceInout1-1);

            outputFile.println(strDate + " " + localTime.format(dateTimeFormatter) + " CHANGE GIVEN:" +moneySpacing1 + "$" +  output1  + "   $0.00");



        } catch (FileNotFoundException e) {
            System.out.println("File is not found.");
        }

    }

}

