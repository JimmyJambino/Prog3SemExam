package com.example.prog3semexam.Controller;

import com.example.prog3semexam.Model.Kandidat;
import com.example.prog3semexam.Repository.KandidatRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kandidat")
public class KandidatController {

    private KandidatRepo kandidatRepo;

    public KandidatController(KandidatRepo kandidatRepo){
        this.kandidatRepo = kandidatRepo;
    }


    // DONE
    @GetMapping("/")
    public ResponseEntity<List<Kandidat>> getAll() {
        List<Kandidat> list = kandidatRepo.findAll();
        for(Kandidat kandidat : list) {
            kandidat.setPartyId();
        }
        return ResponseEntity.ok(list);
    }

    // DONE
    @GetMapping("/{id}")
    public ResponseEntity<Kandidat> getOne(@PathVariable int id) {
        if(kandidatRepo.findById(id).isPresent()) {
            Kandidat kandidat = kandidatRepo.findById(id).get();
            //kandidat.setPartyId();
            return ResponseEntity.ok(kandidat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DONE
    @PostMapping("/")
    public ResponseEntity<Kandidat> addKandidat(@RequestBody Kandidat kandidat) {
        kandidatRepo.save(kandidat);
        return ResponseEntity.ok(kandidat);
    }

    // DONE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Kandidat> updateKandidat(@RequestBody Kandidat kandidat, @PathVariable int id){
        if(kandidatRepo.findById(id).isPresent()) {
            kandidat.setId(id);
            return ResponseEntity.ok(kandidatRepo.save(kandidat));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DONE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Kandidat> deleteKandidat(@PathVariable("id") int id){
        if(kandidatRepo.findById(id).isPresent()) {
            kandidatRepo.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
