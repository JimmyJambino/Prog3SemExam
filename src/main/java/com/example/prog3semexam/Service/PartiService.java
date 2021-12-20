package com.example.prog3semexam.Service;

import com.example.prog3semexam.Model.Kandidat;
import com.example.prog3semexam.Model.Parti;
import com.example.prog3semexam.Repository.PartiRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PartiService {

    private PartiRepo partiRepo;

    public PartiService(PartiRepo partiRepo) {
        this.partiRepo = partiRepo;
    }

    public ResponseEntity<List<Parti>> getAll() {
        List<Parti> list = partiRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    public ResponseEntity<Parti> getParti(int id) {
        if(partiRepo.findById(id).isPresent()) {
            return ResponseEntity.ok(partiRepo.findById(id).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Set<Kandidat>> getKandidatFromParti(int id) {
        if(partiRepo.findById(id).isPresent()) {
            return ResponseEntity.ok(partiRepo.findById(id).get().getKandidatSet());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
