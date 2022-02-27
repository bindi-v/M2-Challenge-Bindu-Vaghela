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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.Assert.*;

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

    // Integer outputJson = mapper.writeValue();
        inputAdd.setOperand1(8);
        inputAdd.setOperand2(9);
        //inputAdd.setAnswer(17);
       // inputAdd.setOperation("Add");
        String inputJson = mapper.writeValueAsString(inputAdd);

        MathSolution outputAdd = new MathSolution();
 //when(service.save(inputAdd)).thenReturn(inputAdd);
        // Integer outputJson = mapper.writeValue();
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
//               .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(8))
//               .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(9))
//               .andExpect(MockMvcResultMatchers.jsonPath("$.answer").value(17))
//               .andExpect(MockMvcResultMatchers.jsonPath("$.operation").value("Add"));

      // assertEquals(17, inputAdd.getAnswer());
    }

    @Test
    public void shouldReturnSubtractionOfTwoOperands() throws Exception {
        MathSolution inputSubtract = new MathSolution();

        inputSubtract.setOperand1(8);
        inputSubtract.setOperand2(9);
       // inputSubtract.setAnswer(-1);
       // inputSubtract.setOperation("Subtract");
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
       // inputMultiply.setAnswer(72);
       // inputMultiply.setOperation("Multiply");
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
        //inputDivide.setAnswer(2);
        //inputDivide.setOperation("Divide");
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
}