package LoicMangele.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue
    @Column(name = "persona_id", updatable = false, nullable = false)
    private UUID personId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "data_di_nascita")
    private LocalDate dataDiNascita;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sesso sesso;

    @OneToMany(mappedBy = "persona")
    private List<Partecipazioni> partecipazioni;


    public Persona() {}


    public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
    }


    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public List<Partecipazioni> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazioni> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }
}
