package com.ninjaone.dundie_awards.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninjaone.dundie_awards.service.BaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BaseService<Object> baseService;

    @InjectMocks
    private BaseController<Object> baseController;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(baseController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testCreate() throws Exception {
        Object newObject = new Object();
        when(baseService.create(any(Object.class))).thenReturn(newObject);

        mockMvc.perform(post("/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newObject)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(newObject)));

        verify(baseService, times(1)).create(any(Object.class));
    }

    @Test
    public void testGetById_Found() throws Exception {
        Long id = 1L;
        Object expectedObject = new Object();
        when(baseService.get(id)).thenReturn(Optional.of(expectedObject));

        mockMvc.perform(get("/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedObject)));

        verify(baseService, times(1)).get(id);
    }

    @Test
    public void testGetById_NotFound() throws Exception {
        Long id = 1L;
        when(baseService.get(id)).thenReturn(Optional.empty());

        mockMvc.perform(get("/{id}", id))
                .andExpect(status().isNotFound());

        verify(baseService, times(1)).get(id);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Object> expectedList = Arrays.asList(new Object(), new Object());
        when(baseService.getAll()).thenReturn(expectedList);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedList)));

        verify(baseService, times(1)).getAll();
    }

    @Test
    public void testUpdate() throws Exception {
        Long id = 1L;
        Object updatedObject = new Object();
        when(baseService.update(eq(id), any(Object.class))).thenReturn(updatedObject);

        mockMvc.perform(put("/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedObject)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(updatedObject)));

        verify(baseService, times(1)).update(eq(id), any(Object.class));
    }

    @Test
    public void testDeleteById() throws Exception {
        Long id = 1L;

        mockMvc.perform(delete("/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.deleted").value(true));

        verify(baseService, times(1)).deleteById(id);
    }
}
