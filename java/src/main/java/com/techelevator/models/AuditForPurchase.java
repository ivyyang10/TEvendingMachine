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


    public class AuditForPurchase {
        public void addingToTheAuditFilePurchase(BigDecimal input1, BigDecimal input2 , String itemId, String itemName){
            Format today = new SimpleDateFormat("MM/dd/yyyy");
            LocalTime localTime = LocalTime.now();

            File writingFile = new File("audit.txt");

            try (PrintWriter outputFile = new PrintWriter(new FileOutputStream(writingFile, true))){

                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
                BigDecimal output1 = input1.setScale(2, RoundingMode.HALF_UP);
                BigDecimal output2 = input2.setScale(2, RoundingMode.HALF_UP);


                int positionAdjustmentForBalanceInout1 = output1.signum() == 0 ? 1 : output1.precision() - output1.scale();
                int positionAdjustmentForBalanceInout2 = output2.signum() == 0 ? 1 : output2.precision() - output2.scale();


                String strDate = today.format(new Date());
                String spacing = "                ".substring(itemName.length());

                String moneySpacing1 = "   ".substring(positionAdjustmentForBalanceInout1-1);
                String moneySpacing2 = "   ".substring(positionAdjustmentForBalanceInout2-1);


                outputFile.println(strDate + " " + localTime.format(dateTimeFormatter) + " " + itemName + spacing+ itemId + moneySpacing1 + "$" +  output1  + moneySpacing2 + "$" + output2);
                //01/01/2022 12:00:20 PM 7Down           B4 $10.00   $6.75
                //11/19/2022 02:38:04 PM Caramel Bar C1      $94.55   $93.20



            } catch (FileNotFoundException e) {
                System.out.println("File is not found.");
            }

        }

    }

