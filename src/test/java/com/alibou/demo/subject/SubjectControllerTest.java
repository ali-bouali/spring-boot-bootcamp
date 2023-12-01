package com.alibou.demo.subject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//@SpringBootTest(properties = {"spring.datasource.url=jdbc:postgresql://localhost:5432/demo_test"})
@SpringBootTest
@AutoConfigureMockMvc
class SubjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_save_subject_successfully() throws Exception {
        SubjectRequest request = new SubjectRequest();
        request.setName("Math");

        mockMvc.perform(
                MockMvcRequestBuilders.post("/subjects")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(new ObjectMapper().writeValueAsString(request))
        ).andExpect(MockMvcResultMatchers.status().isAccepted());
    }



}
