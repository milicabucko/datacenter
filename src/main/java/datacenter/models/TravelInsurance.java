package datacenter.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class TravelInsurance implements Serializable{

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column
        private Date startDate;

        @Column
        private Date endDate;

        @Column
        private String travelRegion;

        @Column
        private Long numberOfPersons;

        @Column
        private Long agesOfPersons;

        @Column
        private String sports;

        @Column
        private String amount;

        public TravelInsurance(){

        }
}
