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


public class AuditFileAddMoney {
    public static void addingToTheAuditFile(String input1, BigDecimal input2){
        Format today = new SimpleDateFormat("MM/dd/yyyy");
        LocalTime  localTime = LocalTime.now();

        File writingFile = new File("audit.txt");

        try (PrintWriter outputFile = new PrintWriter(new FileOutputStream(writingFile, true))){

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            BigDecimal output1 = new BigDecimal(input1).setScale(2, RoundingMode.HALF_UP);
            BigDecimal output2 = input2.setScale(2, RoundingMode.HALF_UP);


            int positionAdjustmentForBalanceInout1 = output1.signum() == 0 ? 1 : output1.precision() - output1.scale();
            int positionAdjustmentForBalanceInout2 = output2.signum() == 0 ? 1 : output2.precision() - output2.scale();

            String moneySpacing1 = "   ".substring(positionAdjustmentForBalanceInout1-1);
            String moneySpacing2 = "   ".substring(positionAdjustmentForBalanceInout2-1);

            String strDate = today.format(new Date());
            outputFile.println(strDate + " " + localTime.format(dateTimeFormatter) + " MONEY FED:       " + moneySpacing1 + " $" +  output1  + moneySpacing2 + "$" + output2);



        } catch (FileNotFoundException e) {
            System.out.println("File is not found.");
        }

    }

}
