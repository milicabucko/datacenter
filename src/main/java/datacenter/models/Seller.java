package datacenter.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table
public class Seller extends User implements Serializable {

    @JsonManagedReference
    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
    private Collection<Policy> policies;

    public Seller() {
    }

    public Seller(Collection<Policy> policies) {
        this.policies = policies;
    }

    public Collection<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(Collection<Policy> policies) {
        this.policies = policies;
    }
}
