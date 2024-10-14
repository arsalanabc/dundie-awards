package com.ninjaone.dundie_awards.service;

import com.ninjaone.dundie_awards.repository.BaseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BaseServiceTest {

    @Mock
    private BaseRepository<Object> baseRepository;

    @InjectMocks
    private BaseService<Object> baseService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGet_ExistingId() {
        Long id = 1L;
        Object expectedObject = new Object();
        when(baseRepository.findById(id)).thenReturn(Optional.of(expectedObject));

        Optional<Object> result = baseService.get(id);

        assertTrue(result.isPresent(), "Result should be present");
        assertEquals(expectedObject, result.get(), "The returned object should match the expected object");
        verify(baseRepository, times(1)).findById(id);
    }

    @Test
    public void testGet_NonExistingId() {
        Long id = 1L;
        when(baseRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Object> result = baseService.get(id);

        assertFalse(result.isPresent(), "Result should not be present for a non-existing ID");
        verify(baseRepository, times(1)).findById(id);
    }

    @Test
    public void testGetAll() {
        List<Object> expectedList = Arrays.asList(new Object(), new Object());
        when(baseRepository.findAll()).thenReturn(expectedList);

        List<Object> result = baseService.getAll();

        assertEquals(expectedList, result, "The returned list should match the expected list");
        verify(baseRepository, times(1)).findAll();
    }

    @Test
    public void testCreate() {
        Object newObject = new Object();
        when(baseRepository.save(newObject)).thenReturn(newObject);

        Object result = baseService.create(newObject);

        assertEquals(newObject, result, "The created object should match the input object");
        verify(baseRepository, times(1)).save(newObject);
    }

    @Test
    public void testUpdate() {
        Long id = 1L;
        Object updatedObject = new Object();
        when(baseRepository.save(updatedObject)).thenReturn(updatedObject);

        Object result = baseService.update(id, updatedObject);

        assertEquals(updatedObject, result, "The updated object should match the input object");
        verify(baseRepository, times(1)).save(updatedObject);
    }

    @Test
    public void testDelete() {
        Object objectToDelete = new Object();

        baseService.delete(objectToDelete);

        verify(baseRepository, times(1)).delete(objectToDelete);
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;

        baseService.deleteById(id);

        verify(baseRepository, times(1)).deleteById(id);
    }
}
