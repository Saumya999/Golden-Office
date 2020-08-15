package com.octopus.GoldenOffice.businessLogic.implementations;

import com.octopus.GoldenOffice.businessLogic.interfaces.UtilityLogicInterface;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UtilityLogic implements UtilityLogicInterface {


    /** Id Generator for Customer
     * Catches the Current time and Split and join into a String to make Customised Id
     * for Every customer
     */

    public String IdGenerator() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(date);
        System.out.println("Date Format with dd-M-yyyy hh:mm:ss : "+strDate);

        String splitter[] = strDate.split("-");
        String dater = String.join("", splitter);
        String spliter[] = dater.split(":");
        dater = String.join("", spliter);
        spliter = dater.split(" ");
        dater = String.join("", spliter);
        System.out.println(dater.trim());

        return dater;
    }
}
