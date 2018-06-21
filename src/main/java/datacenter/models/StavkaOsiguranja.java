package datacenter.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class StavkaOsiguranja implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;

    private String kategorija;

    public StavkaOsiguranja() {
    }

    public StavkaOsiguranja(Long id, String naziv, String kategorija) {
        this.id = id;
        this.naziv = naziv;
        this.kategorija = kategorija;
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
}
