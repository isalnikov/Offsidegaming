package com.isalnikov.offsidegaming.model;

import com.isalnikov.offsidegaming.util.MeasuringDeviceType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author isalnikov
 */
@Entity
@Table
public class Device extends AbstractAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long serialNumber;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private MeasuringDeviceType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @JoinTable
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "device",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "device_id")
    private List<DeviceData> values = new ArrayList<>();

    public Device() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Device)) {
            return false;
        }
        return id != null && id.equals(((Device) o).getId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.serialNumber);
        hash = 71 * hash + Objects.hashCode(this.type);
        return hash;
    }

    public Device(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public MeasuringDeviceType getType() {
        return type;
    }

    public void setType(MeasuringDeviceType type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Device{" + "serialNumber=" + serialNumber + ", type=" + type + '}';
    }

}
