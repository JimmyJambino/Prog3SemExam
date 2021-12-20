package com.example.prog3semexam.Controller;

import com.example.prog3semexam.Model.Kandidat;
import com.example.prog3semexam.Model.Parti;
import com.example.prog3semexam.Service.PartiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/parti")
@CrossOrigin(origins = "*")
public class PartiController {

    private PartiService partiService;

    public PartiController(PartiService partiService){
        this.partiService = partiService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Parti>> getAll() {
        return partiService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parti> getParti(@PathVariable int id) {
        return partiService.getParti(id);
    }

    @GetMapping("/{id}/kandidater")
    public ResponseEntity<Set<Kandidat>> getKandidatFromParti(@PathVariable int id) {
        return getKandidatFromParti(id);
    }
}
