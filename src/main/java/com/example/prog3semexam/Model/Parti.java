package com.example.prog3semexam.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="partier")
public class Parti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "parti")
    private Set<Kandidat> kandidatSet;

    public Parti() {

    }

    public Parti(int id, String name, Set<Kandidat> kandidatSet) {
        this.id = id;
        this.name = name;
        this.kandidatSet = kandidatSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Kandidat> getKandidatSet() {
        return kandidatSet;
    }

    public void setKandidatSet(Set<Kandidat> kandidatSet) {
        this.kandidatSet = kandidatSet;
    }
}
