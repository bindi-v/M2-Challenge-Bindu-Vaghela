package com.company.monthandmathservice.controller;

import com.company.monthandmathservice.model.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MonthConverterController.class)
public class MonthConverterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldReturnMonthByMonthNumber() throws Exception {

        Month month = new Month(1, "January");
        String outputJson = mapper.writeValueAsString(month);

        mockMvc.perform(get("/month/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
               // .andExpect(MockMvcResultMatchers.jsonPath("$.number").value(1))
               // .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("January"));
    }

    @Test
    public void shouldReturnRandomMonth() throws Exception {

        mockMvc.perform(get("/randomMonth"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void shouldReturn422WhenGiveOutOfRangeMonthNumber() throws Exception {

        mockMvc.perform(get("/month/16"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());

    }

    @Test
    public void shouldReturn404WhenNoMonthNumberProvided() throws Exception {

        mockMvc.perform(get("/month/"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}