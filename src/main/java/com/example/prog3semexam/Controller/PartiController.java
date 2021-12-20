package com.example.prog3semexam.Controller;

import com.example.prog3semexam.Model.Kandidat;
import com.example.prog3semexam.Model.Parti;
import com.example.prog3semexam.Repository.KandidatRepo;
import com.example.prog3semexam.Repository.PartiRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/parti")
public class PartiController {

    private PartiRepo partiRepo;

    public PartiController(PartiRepo partiRepo){
        this.partiRepo = partiRepo;
    }

    // DONE
    @GetMapping("/")
    public ResponseEntity<List<Parti>> getAll() {
        List<Parti> list = partiRepo.findAll(); //TODO: move down
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    // DONE
    @GetMapping("/{id}")
    public ResponseEntity<Parti> getParti(@PathVariable int id) {
        if(partiRepo.findById(id).isPresent()) {
            return ResponseEntity.ok(partiRepo.findById(id).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DONE
    @GetMapping("/{id}/kandidater")
    public ResponseEntity<Set<Kandidat>> getKandidatFromParti(@PathVariable int id) {
        if(partiRepo.findById(id).isPresent()) {
            return ResponseEntity.ok(partiRepo.findById(id).get().getKandidatSet());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
