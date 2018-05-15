package datacenter.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class StavkaCenovnika implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;

    private String kategorija;

    private Double cena;

    @ManyToOne
    private Cenovnik cenovnik;

    public StavkaCenovnika() {
    }

    public StavkaCenovnika(Long id, String naziv, String kategorija, Double cena, Cenovnik cenovnik) {
        this.id = id;
        this.naziv = naziv;
        this.kategorija = kategorija;
        this.cena = cena;
        this.cenovnik = cenovnik;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    @JsonIgnore
    public Cenovnik getCenovnik() {
        return cenovnik;
    }

    public void setCenovnik(Cenovnik cenovnik) {
        this.cenovnik = cenovnik;
    }
}
