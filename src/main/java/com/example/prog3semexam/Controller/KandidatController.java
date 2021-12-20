package com.example.prog3semexam.Controller;

import com.example.prog3semexam.Model.Kandidat;
import com.example.prog3semexam.Repository.KandidatRepo;
import com.example.prog3semexam.Service.KandidatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kandidat")
@CrossOrigin(origins = "*")
public class KandidatController {

    private KandidatService kandidatService;

    public KandidatController(KandidatService kandidatService) {
        this.kandidatService = kandidatService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Kandidat>> getAll() {
        return kandidatService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kandidat> getOne(@PathVariable int id) {
        return kandidatService.getOne(id);
    }

    @PostMapping("/")
    public ResponseEntity<Kandidat> addKandidat(@RequestBody Kandidat kandidat) {
        return kandidatService.addKandidat(kandidat);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Kandidat> updateKandidat(@RequestBody Kandidat kandidat, @PathVariable int id){
        return kandidatService.updateKandidat(kandidat, id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Kandidat> deleteKandidat(@PathVariable("id") int id){
        return kandidatService.deleteKandidat(id);
    }
}
