package datacenter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Policy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "contract_item", joinColumns = @JoinColumn(name = "policy_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "contract_item_id", referencedColumnName = "id"))
    protected Set<ContractItem> contractItemSet;

    @JsonBackReference
    @ManyToOne
    private Seller seller;

    @JsonManagedReference
    @OneToMany(mappedBy = "policy", fetch = FetchType.EAGER)
    private Collection<Buyer> insuredPersons;

    @JsonBackReference
    @ManyToOne
    private Buyer contractor;

    @Column
    private TravelInsurance travelInsurance;

    @Column
    private ObjectInsurance objectInsurance;

    @Column
    private VehicleInsurance vehicleInsurance;

    public Policy(Date startDate, Date endDate, Set<ContractItem> contractItemSet, Seller seller, Collection<Buyer> insuredPersons, Buyer contractor) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractItemSet = contractItemSet;
        this.seller = seller;
        this.insuredPersons = insuredPersons;
        this.contractor = contractor;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<ContractItem> getContractItemSet() {
        return contractItemSet;
    }

    public void setContractItemSet(Set<ContractItem> contractItemSet) {
        this.contractItemSet = contractItemSet;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Collection<Buyer> getInsuredPersons() {
        return insuredPersons;
    }

    public void setInsuredPersons(Collection<Buyer> insuredPersons) {
        this.insuredPersons = insuredPersons;
    }

    public Buyer getContractor() {
        return contractor;
    }

    public void setContractor(Buyer contractor) {
        this.contractor = contractor;
    }

    public TravelInsurance getTravelInsurance() {
        return travelInsurance;
    }

    public void setTravelInsurance(TravelInsurance travelInsurance) {
        this.travelInsurance = travelInsurance;
    }

    public ObjectInsurance getObjectInsurance() {
        return objectInsurance;
    }

    public void setObjectInsurance(ObjectInsurance objectInsurance) {
        this.objectInsurance = objectInsurance;
    }

    public VehicleInsurance getVehicleInsurance() {
        return vehicleInsurance;
    }

    public void setVehicleInsurance(VehicleInsurance vehicleInsurance) {
        this.vehicleInsurance = vehicleInsurance;
    }
}

