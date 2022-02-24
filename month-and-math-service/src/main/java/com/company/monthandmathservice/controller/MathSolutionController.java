package com.company.monthandmathservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathSolutionController {

    @RequestMapping(value = "/add/{num1},{num2}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Integer getSumOfTwoNum(@PathVariable Integer num1, @PathVariable Integer num2) {

        int sum = num1 + num2;
        return sum ;
        //return getSumOfTwoNum(num1, num2);
       // return "This is Add End Point.";

    }

}
