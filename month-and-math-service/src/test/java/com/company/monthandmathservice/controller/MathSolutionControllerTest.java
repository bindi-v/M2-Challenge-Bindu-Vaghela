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
    public void shouldReturnAdditionOfTwoOperand() throws Exception {
       MathSolution inputAdd = new MathSolution();

    // Integer outputJson = mapper.writeValue();
        inputAdd.setOperand1(8);
        inputAdd.setOperand2(9);
        inputAdd.setAnswer(17);
        inputAdd.setOperation("Add");
        String inputJson = mapper.writeValueAsString(inputAdd);

        MathSolution outputAdd = new MathSolution();
 //when(service.save(inputAdd)).thenReturn(inputAdd);
        // Integer outputJson = mapper.writeValue();
        outputAdd.setOperand1(8);
        outputAdd.setOperand2(9);
        outputAdd.setAnswer(17);
        outputAdd.setOperation("Add");
        String outputAddJson = mapper.writeValueAsString(outputAdd);

       mockMvc.perform(post("/add")
                       .content(inputJson)
                       .contentType(MediaType.APPLICATION_JSON))
               .andDo(print())
               .andExpect(status().isCreated())
               .andExpect(content().json(outputAddJson));
//               .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(8))
//               .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(9))
//               .andExpect(MockMvcResultMatchers.jsonPath("$.answer").value(17))
//               .andExpect(MockMvcResultMatchers.jsonPath("$.operation").value("Add"));

      // assertEquals(17, inputAdd.getAnswer());
    }
}