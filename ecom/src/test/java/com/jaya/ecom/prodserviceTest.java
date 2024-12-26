package com.jaya.ecom;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class prodserviceTest {

    @Mock
    private prodrepo repo;

    @InjectMocks
    private prodservice prodService;

    @Test
    public void getProdByIdShouldGiveProductSuccessfully() {
        // Arrange
        int id = 1;
        product prod = new product();
        when(repo.findById(id)).thenReturn(Optional.of(prod));

        // Act
        product result = prodService.getprodbyid(id);

        // Assert
        assertNotNull(result);
        assertEquals(prod, result);
        verify(repo, times(1)).findById(id);
    }
}
