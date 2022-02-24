package com.company.monthandmathservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MonthConverterController {

    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String getMonth(@PathVariable String monthNumber) {

        switch (monthNumber) {
            case "1":
                return "January";
                //break;
            case "2":
                return "February";
            //break;
            case "3":
                return "March";
            //break;
            case "4":
                return "April";
           // break;
            case "5":
                return "May";
           // break;
            case "6":
                return "June";
            //break;
            case "7":
                return "July";
            //break;
            case "8":
                return "August";
            //break;
            case "9":
                return "September";
           // break;
            case "10":
                return "October";
           // break;
            case "11":
                return "November";
           // break;
            case "12":
                return "December";
            //break;
            default:
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid Month Number!!");

        }
    }
}
