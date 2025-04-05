package com.example.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.example.TestData.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PaymentControllerTest {

    public static final String TEST_URL = "/calculate";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void calculateByDays() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(TEST_URL)
                        .param("salary", String.valueOf(SALARY))
                        .param("days", String.valueOf(DAYS)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(String.valueOf(PAYMENT)));
    }

    @Test
    void calculateByDates() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(TEST_URL)
                        .param("salary", String.valueOf(SALARY))
                        .param("startDate", String.valueOf(START_DATE))
                        .param("endDate", String.valueOf(END_DATE)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(String.valueOf(PAYMENT)));
    }

    @Test
    void calculateWithNoParameters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(TEST_URL))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void handleCalculateWithNoDaysAndNoDates() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(TEST_URL)
                        .param("salary", String.valueOf(SALARY)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void handleCalculateWithDaysAndDates() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(TEST_URL)
                        .param("salary", String.valueOf(SALARY))
                        .param("days", String.valueOf(DAYS))
                        .param("startDate", String.valueOf(START_DATE))
                        .param("startDate", String.valueOf(END_DATE)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void handleCalculateWithNotAllDates() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(TEST_URL)
                        .param("salary", String.valueOf(SALARY))
                        .param("startDate", String.valueOf(START_DATE)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}