package com.isalnikov.offsidegaming.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author isalnikov
 */
@Entity
@Table(indexes = {
                 @Index(name = "client_id_indx", columnList ="client_id DESC")
})
public class DeviceData implements Comparable<DeviceData> , Serializable {

    private static final long serialVersionUID = 1L;
    
   private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_generator")
    @SequenceGenerator(name="data_generator", sequenceName = "data_seq", allocationSize=100)
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
    private Long coldWaterValue;
    
    @JsonProperty("hot")
    @PositiveOrZero(message = "You cannot have negative numbers of value.") 
    @Column(name = "hot_water_value", nullable = false)
    private Long hotWaterValue;

   
    public DeviceData() {
    }


    public DeviceData(Long gasValue, Long coldWatervalue, Long hotWatervalue) {
        this.gasValue = gasValue;
        this.coldWaterValue = coldWatervalue;
        this.hotWaterValue = hotWatervalue;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.gasValue);
        hash = 97 * hash + Objects.hashCode(this.coldWaterValue);
        hash = 97 * hash + Objects.hashCode(this.hotWaterValue);
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
        if (!Objects.equals(this.coldWaterValue, other.coldWaterValue)) {
            return false;
        }
        if (!Objects.equals(this.hotWaterValue, other.hotWaterValue)) {
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

    public Long getGasValue() {
        return gasValue;
    }

    public void setGasValue(Long gasValue) {
        this.gasValue = gasValue;
    }

    public Long getColdWaterValue() {
        return coldWaterValue;
    }

    public void setColdWaterValue(Long coldWaterValue) {
        this.coldWaterValue = coldWaterValue;
    }

    public Long getHotWaterValue() {
        return hotWaterValue;
    }

    public void setHotWaterValue(Long hotWaterValue) {
        this.hotWaterValue = hotWaterValue;
    }

    
    
    public String toValueString() {
        return  String.format("\nvalues:\n%08d gas\n%08d cold water\n%08d hot water", gasValue ,coldWaterValue , hotWaterValue);
    }

    private static  String str;
    
    @Override
    public String toString() {
        if(str == null){
            str = String.join(";",gasValue.toString(),coldWaterValue.toString(),hotWaterValue.toString());
        }
        
         
        return str;
    }

    @Override
    public int compareTo(DeviceData other) {
       return Comparator.comparingLong(DeviceData::getGasValue)
              .thenComparingLong(DeviceData::getColdWaterValue)
              .thenComparingLong(DeviceData::getHotWaterValue)
              .compare(this, other);
      
    }



}
