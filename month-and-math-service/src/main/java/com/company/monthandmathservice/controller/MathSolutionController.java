package com.company.monthandmathservice.controller;

import com.company.monthandmathservice.model.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
public class MathSolutionController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution getSumOfTwoNum(@RequestBody @Valid MathSolution mathSolution) {

        mathSolution.getOperand1().intValue();
        mathSolution.getOperand2().intValue();
        if(mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {

            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid input!! ");

        }
//        if(mathSolution.getOperand1().intValue() != int  mathSolution.getOperand2().intValue()){
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
    public MathSolution getSubtractionOfTwoNum(@RequestBody @Valid MathSolution mathSolution) {

        if(mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {

            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid Number!! Enter An Integer Number!!");

        }
        mathSolution.setAnswer(mathSolution.getOperand1() - mathSolution.getOperand2());
        mathSolution.setOperation("Subtract");
        return mathSolution;

        // return "This is Subtract End Point.";

    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution getMultiplicationOfTwoNum(@RequestBody @Valid MathSolution mathSolution) {
        if(mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {

            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid Number!! Enter An Integer Number!!");

        }

        mathSolution.setAnswer(mathSolution.getOperand1() * mathSolution.getOperand2());
        mathSolution.setOperation("Multiply");
        return mathSolution;

        // return "This is Multiply End Point.";

    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution getDivisionOfTwoNum(@RequestBody @Valid MathSolution mathSolution) {

        if(mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {

            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid Number!! Enter An Integer Number!!");

        }
        mathSolution.setAnswer(mathSolution.getOperand1() / mathSolution.getOperand2());
        mathSolution.setOperation("Divide");
        return mathSolution;

        // return "This is Divide End Point.";

    }

}
