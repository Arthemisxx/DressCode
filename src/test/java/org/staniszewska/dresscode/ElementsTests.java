package org.staniszewska.dresscode;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.staniszewska.dresscode.entity.ElementEntity;
import org.staniszewska.dresscode.mapper.ElementMapper;
import org.staniszewska.dresscode.model.ElementCategory;
import org.staniszewska.dresscode.model.ElementDTO;
import org.staniszewska.dresscode.model.Season;
import org.staniszewska.dresscode.repository.ElementRepository;
import org.staniszewska.dresscode.service.ElementService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ElementsTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ElementRepository elementRepository;
    @Autowired
    private ElementService elementService;

    @AfterEach
    void deleteAllElements() {
        elementRepository.deleteAll();
    }

    @Test
    void testAddingElement() throws Exception {
        ElementDTO elementDTO = new ElementDTO(null, "name", "description", Set.of("white", "black"), Set.of(Season.SUMMER), "123", ElementCategory.BOTTOM);

        ResultActions result = mockMvc.perform(post("/elements/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(elementDTO)));

        result.andExpect(status().isOk());
        assertNotEquals(null, elementRepository.findElementEntityByName(elementDTO.getName()));
    }

    @Test
    void testDeletingElement() throws Exception {
        elementService.addElement(new ElementDTO(null, "name1", "description1", Set.of("white", "black"), Set.of(Season.SUMMER), "123", ElementCategory.BOTTOM));
        long id = elementRepository.findElementEntityByName("name1").getId();

        ResultActions result = mockMvc.perform(delete("/elements/delete/{id}", id));

        result.andExpect(status().isOk());
        assertNull(elementRepository.findElementEntityById(id));
    }

    @Test
    void testGettingAllElements() throws Exception {
        elementService.addElement(new ElementDTO(null, "name1", "description1", Set.of("white", "black"), Set.of(Season.SUMMER), "123", ElementCategory.BOTTOM));
        elementService.addElement(new ElementDTO(null, "name2", "description2", Set.of("blue"), Set.of(Season.WINTER), "456", ElementCategory.TOP));

        MvcResult result = mockMvc.perform(get("/elements"))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);

        ElementDTO[] elements = objectMapper.readValue(content, ElementDTO[].class);
        assertEquals(2, elements.length);
    }

    @Test
    void testGettingElementById() throws Exception {
        elementService.addElement(new ElementDTO(null, "name1", "description1", Set.of("white", "black"), Set.of(Season.SUMMER), "123", ElementCategory.BOTTOM));
        long id = elementRepository.findElementEntityByName("name1").getId();

        ResultActions result = mockMvc.perform(get("/elements/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value("name1"))
                .andExpect(jsonPath("$.description").value("description1"));
    }

    @Test
    void testWhenElementToGetDoesNotExist() throws Exception {
        long id = 1;
        ResultActions result = mockMvc.perform(get("/elements/{id}", id))
                .andExpect(status().isNotFound());
    }

    @Test
    void testUpdatingElement() throws Exception {
        elementService.addElement(new ElementDTO(null, "name1", "description1", Set.of("white", "black"), Set.of(Season.SUMMER), "123", ElementCategory.BOTTOM));
        long id = elementRepository.findElementEntityByName("name1").getId();

        ElementDTO elementDTO = new ElementDTO(null, "updatedName", "updatedDescription", Set.of("white"), Set.of(Season.WINTER), "123", ElementCategory.TOP);

        ResultActions result = mockMvc.perform(put("/elements/update/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(elementDTO)));

        result.andExpect(status().isOk());
        ElementEntity elementFoundById = elementRepository.findElementEntityById(id);

        assertEquals(elementFoundById.getName(), "updatedName");
    }


}
