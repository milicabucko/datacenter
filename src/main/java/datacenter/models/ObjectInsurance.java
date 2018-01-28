package datacenter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class ObjectInsurance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long surface;

    @Column
    private Long age;

    @Column
    private Double estimatedValue;

    @JsonBackReference
    @ManyToOne
    private Buyer propertyOwner;

    public ObjectInsurance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSurface() {
        return surface;
    }

    public void setSurface(Long surface) {
        this.surface = surface;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Double getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(Double estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    public Buyer getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(Buyer propertyOwner) {
        this.propertyOwner = propertyOwner;
    }
}

