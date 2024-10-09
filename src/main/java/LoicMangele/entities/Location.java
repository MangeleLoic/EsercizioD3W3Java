package LoicMangele.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private UUID locationId;

    @Column(nullable = false)
    private String nome;
    private String città;

    @OneToMany(mappedBy = "persona")
    private List<Evento> eventi;


    public Location() {}

    public Location(String nome, String città) {
        this.nome = nome;
        this.città = città;
    }


    public UUID getLocationId() {
        return locationId;
    }

    public void setLocationId(UUID locationId) {
        this.locationId = locationId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", nome='" + nome + '\'' +
                ", città='" + città + '\'' +
                '}';
    }
}

