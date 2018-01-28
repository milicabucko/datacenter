package datacenter.models;

import com.fasterxml.jackson.core.SerializableString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Employee extends User implements Serializable{

    public Employee() {

    }
}
