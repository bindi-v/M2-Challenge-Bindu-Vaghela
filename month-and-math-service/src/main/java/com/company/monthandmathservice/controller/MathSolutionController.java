package com.company.monthandmathservice.controller;

import com.company.monthandmathservice.model.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
public class MathSolutionController {

    // This is Add End Point

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution getSumOfTwoNum(@RequestBody @Valid MathSolution mathSolution) {

        if(mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {

            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid input!! ");

        }

            mathSolution.setAnswer(mathSolution.getOperand1() + mathSolution.getOperand2());

            mathSolution.setOperation("Add");

        return mathSolution;

    }

    // This is Subtract End Point

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution getSubtractionOfTwoNum(@RequestBody @Valid MathSolution mathSolution) {

        if(mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {

            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid Number!! Enter An Integer Number!!");

        }
        mathSolution.setAnswer(mathSolution.getOperand1() - mathSolution.getOperand2());
        mathSolution.setOperation("Subtract");
        return mathSolution;

    }

    // This is Multiply End Point

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution getMultiplicationOfTwoNum(@RequestBody @Valid MathSolution mathSolution) {
        if(mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {

            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid Number!! Enter An Integer Number!!");

        }

        mathSolution.setAnswer(mathSolution.getOperand1() * mathSolution.getOperand2());
        mathSolution.setOperation("Multiply");
        return mathSolution;

    }

    // This is Divide End Point

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution getDivisionOfTwoNum(@RequestBody @Valid MathSolution mathSolution) {

        if(mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {

            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid Number!! Enter An Integer Number!!");

        }
        mathSolution.setAnswer(mathSolution.getOperand1() / mathSolution.getOperand2());
        mathSolution.setOperation("Divide");
        return mathSolution;

    }

}
