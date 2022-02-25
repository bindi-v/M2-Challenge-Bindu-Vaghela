package com.company.monthandmathservice.controller;

import com.company.monthandmathservice.model.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MathSolutionController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution getSumOfTwoNum(@RequestBody MathSolution mathSolution) {
        if(mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {
            // throw new IllegalArgumentException("Enter Number from 1 to 12 for Month Name!!");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid Number!! Enter An Integer Number!!");

        }
//        if(mathSolution.getOperand1().intValue() ? mathSolution.getOperand2().intValue()){
            mathSolution.setAnswer(mathSolution.getOperand1() + mathSolution.getOperand2());

            mathSolution.setOperation("Add");
//        } else {
//            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid Input!!")
//        }
        return mathSolution;

       // return "This is Add End Point.";

    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution getSubtractionOfTwoNum(@RequestBody MathSolution mathSolution) {

        mathSolution.setAnswer(mathSolution.getOperand1() - mathSolution.getOperand2());
        mathSolution.setOperation("Subtract");
        return mathSolution;

        // return "This is Subtract End Point.";

    }

}
