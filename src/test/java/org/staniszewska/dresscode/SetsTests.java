package org.staniszewska.dresscode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.staniszewska.dresscode.model.*;
import org.staniszewska.dresscode.repository.ElementRepository;
import org.staniszewska.dresscode.repository.SetRepository;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SetsTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ElementRepository elementRepository;
    @Autowired
    private SetRepository setRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @AfterEach
    void deleteSetsAndElements(){
        setRepository.deleteAll();
        elementRepository.deleteAll();
    }

    @Test
    void testAddingSet() throws Exception {
        ElementDTO elementDTO1 = new ElementDTO(null, "element1", "description", Set.of("white", "black"), Set.of(Season.SUMMER), "123", ElementCategory.BOTTOM);
        ElementDTO elementDTO2 = new ElementDTO(null, "element2", "description", Set.of("white", "black"), Set.of(Season.SUMMER), "123", ElementCategory.BOTTOM);
        SetDTO setDTO = new SetDTO("name", "description", "123", Creator.ME, SetCategory.CASUAL, Set.of(Season.SUMMER), Set.of(elementDTO1, elementDTO2));

        ResultActions result = mockMvc.perform(post("/sets/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(setDTO)));

        result.andExpect(status().isOk());
        assertNotEquals(null, setRepository.findSetEntityByName(setDTO.getName()));


    }

}
