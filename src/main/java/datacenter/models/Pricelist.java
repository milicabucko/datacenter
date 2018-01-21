package datacenter.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table
public class Pricelist implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Boolean active;

    @Column
    private String startDate;

    @Column
    private String endDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "pricelist", fetch = FetchType.EAGER)
    private Collection<PricelistItem> items;

    public Pricelist() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<PricelistItem> getItems() {
        return items;
    }

    public void setItems(Collection<PricelistItem> items) {
        this.items = items;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
