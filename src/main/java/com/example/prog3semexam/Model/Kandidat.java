package com.example.prog3semexam.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="kandidater")
public class Kandidat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private int id;

    @Column(name = "fornavn", nullable = false)
    private String fornavn;

    @Column(name = "efternavn", nullable = false)
    private String efternavn;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="partiId", nullable = false)
    private Parti parti;

    @Column(name = "antalStemmer", nullable = false, columnDefinition = "int default 0")
    private int antalStemmer;

    @Transient
    private int partiId;

    @Transient
    private String partiNavn;
    public Kandidat() {
    }

    public Kandidat(String fornavn, String efternavn, Parti parti, int antalStemmer) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.parti = parti;
        this.antalStemmer = antalStemmer;
    }

    public String getPartiNavn() {
        return partiNavn;
    }

    public void setPartiNavn() {
        this.partiNavn = parti.getName();
    }

    public int getPartiId() {
        return partiId;
    }

    public void setPartyId() {
        this.partiId = parti.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public Parti getParti() {
        return parti;
    }

    public void setParti(Parti parti) {
        this.parti = parti;
    }

    public int getAntalStemmer() {
        return antalStemmer;
    }

    public void setAntalStemmer(int antalStemmer) {
        this.antalStemmer = antalStemmer;
    }
}
