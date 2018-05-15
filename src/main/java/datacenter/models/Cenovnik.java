package datacenter.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Cenovnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String datumPocetka;


    @OneToMany(mappedBy = "cenovnik", fetch = FetchType.EAGER)
    private Collection<StavkaCenovnika> stavkeCenovnika;

    public Cenovnik() {
    }

    public Cenovnik(Long id, String datumPocetka, Collection<StavkaCenovnika> stavkeCenovnika) {
        this.id = id;
        this.datumPocetka = datumPocetka;
        this.stavkeCenovnika = stavkeCenovnika;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(String datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Collection<StavkaCenovnika> getStavkeCenovnika() {
        return stavkeCenovnika;
    }

    public void setStavkeCenovnika(Collection<StavkaCenovnika> stavkeCenovnika) {
        this.stavkeCenovnika = stavkeCenovnika;
    }
}
