package datacenter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Buyer extends User implements Serializable {

    @JsonBackReference
    @ManyToOne
    private Policy policy;

    @Column
    private boolean contractor;




}
