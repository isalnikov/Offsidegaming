package com.isalnikov.offsidegaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author isalnikov
 */
@Entity
@Table
public class DeviceData extends AbstractAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Client client;

    /**
     * meter reader
     */
    @PositiveOrZero(message = "You cannot have negative numbers of value.") 
    @Column(name = "gas_value" , nullable = false)
    private Long gasValue;
    
    @PositiveOrZero(message = "You cannot have negative numbers of value.") 
    @Column(name = "cold_water_value", nullable = false)
    private Long coldWatervalue;
    
    @PositiveOrZero(message = "You cannot have negative numbers of value.") 
    @Column(name = "hot_water_value", nullable = false)
    private Long hotWatervalue;


    public DeviceData(Long gasValue, Long coldWatervalue, Long hotWatervalue) {
        this.gasValue = gasValue;
        this.coldWatervalue = coldWatervalue;
        this.hotWatervalue = hotWatervalue;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.gasValue);
        hash = 97 * hash + Objects.hashCode(this.coldWatervalue);
        hash = 97 * hash + Objects.hashCode(this.hotWatervalue);
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
        final DeviceData other = (DeviceData) obj;
        if (!Objects.equals(this.gasValue, other.gasValue)) {
            return false;
        }
        if (!Objects.equals(this.coldWatervalue, other.coldWatervalue)) {
            return false;
        }
        if (!Objects.equals(this.hotWatervalue, other.hotWatervalue)) {
            return false;
        }
        return true;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  String.format("\nvalues:\n%08d gas\n%08d cold water\n%08d hot water", gasValue ,coldWatervalue , hotWatervalue);
    }



}
