package com.isalnikov.offsidegaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/**
 *
 * @author isalnikov
 */
@Entity
@Table
public class DeviceData implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created;

    @LastModifiedDate
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date modified;

    /**
     *  meter reader
     */
    private Long value;

    @ManyToOne(fetch = FetchType.LAZY)
    private Device device;

    public DeviceData() {
    }

    public DeviceData(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DeviceData{" + "created=" + created + ", modified=" + modified + ", device=" + device + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.created);
        hash = 59 * hash + Objects.hashCode(this.modified);
        hash = 59 * hash + Objects.hashCode(this.value);
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
        if (!Objects.equals(this.created, other.created)) {
            return false;
        }
        if (!Objects.equals(this.modified, other.modified)) {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) {
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
    
    
    

}
