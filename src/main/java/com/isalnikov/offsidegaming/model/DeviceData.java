package com.isalnikov.offsidegaming.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.PositiveOrZero;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.annotation.CreatedDate;

/**
 *
 * @author isalnikov
 */
@Entity
@Table(indexes = {
                 @Index(name = "client_id_indx", columnList ="client_id DESC")
})
public class DeviceData implements Serializable {

    private static final long serialVersionUID = 1L;
    
   private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Id
    @GeneratedValue
    private Long id;
    
   
    /**
     * meter reader
     */
    @JsonProperty("gas")
    @PositiveOrZero(message = "You cannot have negative numbers of value.") 
    @Column(name = "gas_value" , nullable = false)
    private Long gasValue;
    
    @JsonProperty("cold")
    @PositiveOrZero(message = "You cannot have negative numbers of value.") 
    @Column(name = "cold_water_value", nullable = false)
    private Long coldWatervalue;
    
    @JsonProperty("hot")
    @PositiveOrZero(message = "You cannot have negative numbers of value.") 
    @Column(name = "hot_water_value", nullable = false)
    private Long hotWatervalue;

    public DeviceData() {
    }


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String toValueString() {
        return  String.format("\nvalues:\n%08d gas\n%08d cold water\n%08d hot water", gasValue ,coldWatervalue , hotWatervalue);
    }

    private static  String str;
    
    @Override
    public String toString() {
        if(str == null){
            str = String.join(";",gasValue.toString(),coldWatervalue.toString(),hotWatervalue.toString());
        }
        
         
        return str;
    }



}
