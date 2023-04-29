/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "servicetb")
@NamedQueries({
    @NamedQuery(name = "Servicetb.findAll", query = "SELECT s FROM Servicetb s"),
    @NamedQuery(name = "Servicetb.findByServiceID", query = "SELECT s FROM Servicetb s WHERE s.serviceID = :serviceID"),
    @NamedQuery(name = "Servicetb.findByServiceType", query = "SELECT s FROM Servicetb s WHERE s.serviceType = :serviceType"),
    @NamedQuery(name = "Servicetb.findByCharge", query = "SELECT s FROM Servicetb s WHERE s.charge = :charge"),
    @NamedQuery(name = "Servicetb.findByChargePer", query = "SELECT s FROM Servicetb s WHERE s.chargePer = :chargePer")})
public class Servicetb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ServiceID")
    private Integer serviceID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ServiceType")
    private String serviceType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Charge")
    private float charge;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ChargePer")
    private String chargePer;
    @ManyToMany(mappedBy = "servicetbCollection")
    private Collection<Usertb> usertbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceID")
    private Collection<Warehousetb> warehousetbCollection;

    public Servicetb() {
    }

    public Servicetb(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public Servicetb(Integer serviceID, String serviceType, float charge, String chargePer) {
        this.serviceID = serviceID;
        this.serviceType = serviceType;
        this.charge = charge;
        this.chargePer = chargePer;
    }

    public Integer getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public float getCharge() {
        return charge;
    }

    public void setCharge(float charge) {
        this.charge = charge;
    }

    public String getChargePer() {
        return chargePer;
    }

    public void setChargePer(String chargePer) {
        this.chargePer = chargePer;
    }

    @JsonbTransient
    public Collection<Usertb> getUsertbCollection() {
        return usertbCollection;
    }

    public void setUsertbCollection(Collection<Usertb> usertbCollection) {
        this.usertbCollection = usertbCollection;
    }

    @JsonbTransient
    public Collection<Warehousetb> getWarehousetbCollection() {
        return warehousetbCollection;
    }

    public void setWarehousetbCollection(Collection<Warehousetb> warehousetbCollection) {
        this.warehousetbCollection = warehousetbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceID != null ? serviceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicetb)) {
            return false;
        }
        Servicetb other = (Servicetb) object;
        if ((this.serviceID == null && other.serviceID != null) || (this.serviceID != null && !this.serviceID.equals(other.serviceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Servicetb[ serviceID=" + serviceID + " ]";
    }
    
}
