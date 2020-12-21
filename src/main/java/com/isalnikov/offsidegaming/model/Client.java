package com.isalnikov.offsidegaming.model;

/**
 *
 * @author isalnikov
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Client implements Serializable {

     private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "сlient_generator")
    @SequenceGenerator(name="сlient_generator", sequenceName = "сlient_seq", allocationSize=100)
     private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "client_id", referencedColumnName="id",foreignKey =@ForeignKey(name = "fk_client_id"))
    private List<DeviceData> values = new ArrayList<>();

    public Client() {
    }

    public Client(Long id) {
        this.id = id;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DeviceData> getValues() {
        return Collections.unmodifiableList(values);
    }

    public void setValues(List<DeviceData> values) {
        this.values = values;
    }

    
      public void addValue(final DeviceData deviceData) {
        this.values.add(deviceData);
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + '}';
    }
    
    public String historyString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[id : ").append(id);
        values.forEach((value) -> {
            sb.append(value.toString());
         });
        return sb.toString();
    }
    

}
