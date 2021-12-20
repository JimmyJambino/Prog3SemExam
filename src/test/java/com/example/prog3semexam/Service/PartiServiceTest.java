package com.example.prog3semexam.Service;

import com.example.prog3semexam.Model.Parti;
import com.example.prog3semexam.Repository.PartiRepo;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PartiServiceTest {

    PartiRepo partiRepo = mock(PartiRepo.class);
    PartiService partiService = new PartiService(partiRepo);

    @Test
    void getAll() {
        List<Parti> list = new ArrayList<>();
        Parti parti1 = new Parti();
        Parti parti2 = new Parti();
        list.add(parti1);
        list.add(parti2);
        ResponseEntity<List<Parti>> responseEntity = ResponseEntity.ok(list);

        when(partiRepo.findAll()).thenReturn(list);
        assertEquals(partiService.getAll(),responseEntity);
        verify(partiRepo).findAll();
    }
}