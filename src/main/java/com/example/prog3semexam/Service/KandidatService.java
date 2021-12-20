package com.example.prog3semexam.Service;

import com.example.prog3semexam.Model.Kandidat;
import com.example.prog3semexam.Repository.KandidatRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class KandidatService {

    private KandidatRepo kandidatRepo;

    public KandidatService(KandidatRepo kandidatRepo) {
        this.kandidatRepo = kandidatRepo;
    }

    public ResponseEntity<List<Kandidat>> getAll() {
        List<Kandidat> list = kandidatRepo.findAll();
        for(Kandidat kandidat : list) {
            kandidat.setPartyId();
            kandidat.setPartiNavn();
        }
        return ResponseEntity.ok(list);
    }

    public ResponseEntity<Kandidat> getOne(int id) {
        if(kandidatRepo.findById(id).isPresent()) {
            Kandidat kandidat = kandidatRepo.findById(id).get();
            kandidat.setPartyId();
            kandidat.setPartiNavn();
            return ResponseEntity.ok(kandidat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Kandidat> addKandidat(Kandidat kandidat) {
        kandidatRepo.save(kandidat);
        return ResponseEntity.ok(kandidat);
    }

    public ResponseEntity<Kandidat> updateKandidat(Kandidat kandidat, int id){
        if(kandidatRepo.findById(id).isPresent()) {
            kandidat.setId(id);
            return ResponseEntity.ok(kandidatRepo.save(kandidat));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Kandidat> deleteKandidat(int id){
        if(kandidatRepo.findById(id).isPresent()) {
            kandidatRepo.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
