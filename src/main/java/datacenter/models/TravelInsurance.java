package datacenter.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class TravelInsurance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public TravelInsurance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
