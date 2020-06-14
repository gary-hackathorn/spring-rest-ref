package org.hack.dnd.controlers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hack.dnd.model.Character;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class CharacterControlerTest {

    @Autowired
    MockMvc mockMvc;

    private ObjectMapper objectMapper;
    private List<Character> expected;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        expected = new ArrayList<>();
         expected.add(new Character("Viari", 17, 12, 16));
        expected.add(new Character("Binwin", 18, 10, 17));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void should_return_list() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/character"))
                .andExpect(status().isOk()).andReturn();
        String body = response.getResponse().getContentAsString();
        System.out.println("Results:"+body);
        List<Character> characters = objectMapper.readValue(body, new TypeReference<List<Character>>(){});
        assertEquals(expected, characters);
    }
}