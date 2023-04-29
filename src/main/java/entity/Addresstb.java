/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "addresstb")
@NamedQueries({
    @NamedQuery(name = "Addresstb.findAll", query = "SELECT a FROM Addresstb a"),
    @NamedQuery(name = "Addresstb.findByAddressID", query = "SELECT a FROM Addresstb a WHERE a.addressID = :addressID"),
    @NamedQuery(name = "Addresstb.findByCountry", query = "SELECT a FROM Addresstb a WHERE a.country = :country"),
    @NamedQuery(name = "Addresstb.findByState", query = "SELECT a FROM Addresstb a WHERE a.state = :state"),
    @NamedQuery(name = "Addresstb.findByCity", query = "SELECT a FROM Addresstb a WHERE a.city = :city"),
    @NamedQuery(name = "Addresstb.findByStreet", query = "SELECT a FROM Addresstb a WHERE a.street = :street"),
    @NamedQuery(name = "Addresstb.findByZip", query = "SELECT a FROM Addresstb a WHERE a.zip = :zip")})
public class Addresstb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AddressID")
    private Integer addressID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Country")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "State")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "City")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Street")
    private String street;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Zip")
    private int zip;
    @JoinColumn(name = "warehouseID", referencedColumnName = "warehouseID")
    @ManyToOne(optional = false)
    private Warehousetb warehouseID;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private Usertb userID;

    public Addresstb() {
    }

    public Addresstb(Integer addressID) {
        this.addressID = addressID;
    }

    public Addresstb(Integer addressID, String country, String state, String city, String street, int zip) {
        this.addressID = addressID;
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.zip = zip;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public Warehousetb getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(Warehousetb warehouseID) {
        this.warehouseID = warehouseID;
    }

    public Usertb getUserID() {
        return userID;
    }

    public void setUserID(Usertb userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressID != null ? addressID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Addresstb)) {
            return false;
        }
        Addresstb other = (Addresstb) object;
        if ((this.addressID == null && other.addressID != null) || (this.addressID != null && !this.addressID.equals(other.addressID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Addresstb[ addressID=" + addressID + " ]";
    }
    
}
