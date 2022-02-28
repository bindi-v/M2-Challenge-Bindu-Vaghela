package com.company.monthandmathservice.controller;

import com.company.monthandmathservice.model.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class MonthConverterController {

    private static int monthNumber;

    private static List<Month> monthList = new ArrayList<>(Arrays.asList(

            new Month(1, "January"),
            new Month(2, "February"),
            new Month(3, "March"),
            new Month(4, "April"),
            new Month(5, "May"),
            new Month(6, "June"),
            new Month(7, "July"),
            new Month(8, "August"),
            new Month(9, "September"),
            new Month(10, "October"),
            new Month(11, "November"),
            new Month(12, "December")

    ));

    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Month getMonth(@PathVariable int monthNumber) {
        if(monthNumber < 1 || monthNumber > 12) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid Month Number!! Enter Number from 1 to 12 for Month Name!!");

        }
        Month foundMonth = null;
        for(Month month: monthList) {
            if(month.getNumber() == monthNumber) {
                foundMonth = month;
                break;
            }
        }
        return foundMonth;

    }

    @RequestMapping(value = "/randomMonth", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Month getRandomMonth() {
        Random randomMonth = new Random();
        int index = monthList.size();
        int num = randomMonth.nextInt(index);
        return monthList.get(num);
    }

}
