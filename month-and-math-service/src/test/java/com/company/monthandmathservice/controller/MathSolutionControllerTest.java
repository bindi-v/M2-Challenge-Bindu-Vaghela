package com.company.monthandmathservice.controller;

import com.company.monthandmathservice.model.MathSolution;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldReturnAdditionOfTwoOperands() throws Exception {
       MathSolution inputAdd = new MathSolution();

        inputAdd.setOperand1(8);
        inputAdd.setOperand2(9);

        String inputJson = mapper.writeValueAsString(inputAdd);

        MathSolution outputAdd = new MathSolution();

        outputAdd.setOperand1(8);
        outputAdd.setOperand2(9);
        outputAdd.setAnswer(17);
        outputAdd.setOperation("Add");
        String outputJson = mapper.writeValueAsString(outputAdd);

       mockMvc.perform(post("/add")
                       .content(inputJson)
                       .contentType(MediaType.APPLICATION_JSON))
               .andDo(print())
               .andExpect(status().isCreated())
               .andExpect(content().json(outputJson));

    }

    @Test
    public void shouldReturnSubtractionOfTwoOperands() throws Exception {
        MathSolution inputSubtract = new MathSolution();

        inputSubtract.setOperand1(8);
        inputSubtract.setOperand2(9);

        String inputJson = mapper.writeValueAsString(inputSubtract);

        MathSolution outputSubtract = new MathSolution();

        outputSubtract.setOperand1(8);
        outputSubtract.setOperand2(9);
        outputSubtract.setAnswer(-1);
        outputSubtract.setOperation("Subtract");
        String outputJson = mapper.writeValueAsString(outputSubtract);

        mockMvc.perform(post("/subtract")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturnMultiplicationOfTwoOperands() throws Exception {
        MathSolution inputMultiply = new MathSolution();

        inputMultiply.setOperand1(8);
        inputMultiply.setOperand2(9);

        String inputJson = mapper.writeValueAsString(inputMultiply);

        MathSolution outputMultiply = new MathSolution();

        outputMultiply.setOperand1(8);
        outputMultiply.setOperand2(9);
        outputMultiply.setAnswer(72);
        outputMultiply.setOperation("Multiply");
        String outputJson = mapper.writeValueAsString(outputMultiply);

        mockMvc.perform(post("/multiply")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void shouldReturnDivisionOfTwoOperands() throws Exception {

        MathSolution inputDivide = new MathSolution();

        inputDivide.setOperand1(18);
        inputDivide.setOperand2(9);

        String inputJson = mapper.writeValueAsString(inputDivide);

        MathSolution outputDivide = new MathSolution();

        outputDivide.setOperand1(18);
        outputDivide.setOperand2(9);
        outputDivide.setAnswer(2);
        outputDivide.setOperation("Divide");
        String outputJson = mapper.writeValueAsString(outputDivide);

        mockMvc.perform(post("/divide")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldReturn422StatusCodeWithInvalidRequestBody() throws Exception {

        // test for Add
        MathSolution inputAdd = new MathSolution();

        inputAdd.setOperand1(9);

        String inputAddJson = mapper.writeValueAsString(inputAdd);

        mockMvc.perform(post("/add")
                .content(inputAddJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

        // Test for Subtract
        MathSolution inputSubtract = new MathSolution();

        inputSubtract.setOperand2(9);
        inputSubtract.setOperand2(1);

        String inputSubtractJson = mapper.writeValueAsString(inputSubtract);

        mockMvc.perform(post("/subtract")
                        .content(inputSubtractJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

        // Test for Multiply
        MathSolution inputMultiply = new MathSolution();

        inputMultiply.setOperand1(-7);
        //inputMultiply.setOperand2();

        String inputMultiplyJson = mapper.writeValueAsString(inputMultiply);

        mockMvc.perform(post("/multiply")
                        .content(inputMultiplyJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

        // Test for Divide
        MathSolution inputDivide= new MathSolution();

        inputDivide.setOperand2(9);
        //inputDivide.setOperand2("");
        String inputDivideJson = mapper.writeValueAsString(inputDivide);

        mockMvc.perform(post("/divide")
                        .content(inputDivideJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturn422StatusCodeForDivideByZero() throws Exception {
        MathSolution input = new MathSolution();

        input.setOperand1(9);
        input.setOperand2(0);
        String inputJson = mapper.writeValueAsString(input);

        mockMvc.perform(post("/divide")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturn405StatusCodeIfMethodNotSupported() throws Exception {
        mockMvc.perform(get("/add"))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void shouldReturn404StatusCodeIfMethodNotFound() throws Exception {
           mockMvc.perform(post("/"))
                   .andDo(print())
                   .andExpect(status().isNotFound());
    }
}