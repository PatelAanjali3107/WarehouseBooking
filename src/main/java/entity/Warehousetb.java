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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "warehousetb")
@NamedQueries({
    @NamedQuery(name = "Warehousetb.findAll", query = "SELECT w FROM Warehousetb w"),
    @NamedQuery(name = "Warehousetb.findByWarehouseID", query = "SELECT w FROM Warehousetb w WHERE w.warehouseID = :warehouseID"),
    @NamedQuery(name = "Warehousetb.findByConstructionType", query = "SELECT w FROM Warehousetb w WHERE w.constructionType = :constructionType"),
    @NamedQuery(name = "Warehousetb.findByProductType", query = "SELECT w FROM Warehousetb w WHERE w.productType = :productType"),
    @NamedQuery(name = "Warehousetb.findByArea", query = "SELECT w FROM Warehousetb w WHERE w.area = :area"),
    @NamedQuery(name = "Warehousetb.findByAmenities", query = "SELECT w FROM Warehousetb w WHERE w.amenities = :amenities"),
    @NamedQuery(name = "Warehousetb.findByCompliances", query = "SELECT w FROM Warehousetb w WHERE w.compliances = :compliances")})
public class Warehousetb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "warehouseID")
    private Integer warehouseID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ConstructionType")
    private String constructionType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ProductType")
    private String productType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Area")
    private double area;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Amenities")
    private String amenities;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Compliances")
    private String compliances;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouseID")
    private Collection<Addresstb> addresstbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouseID")
    private Collection<Scheduletb> scheduletbCollection;
    @JoinColumn(name = "ServiceID", referencedColumnName = "ServiceID")
    @ManyToOne(optional = false)
    private Servicetb serviceID;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private Usertb userID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouseID")
    private Collection<Bookingtb> bookingtbCollection;

    public Warehousetb() {
    }

    public Warehousetb(Integer warehouseID) {
        this.warehouseID = warehouseID;
    }

    public Warehousetb(Integer warehouseID, String constructionType, String productType, double area, String amenities, String compliances) {
        this.warehouseID = warehouseID;
        this.constructionType = constructionType;
        this.productType = productType;
        this.area = area;
        this.amenities = amenities;
        this.compliances = compliances;
    }

    public Integer getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(Integer warehouseID) {
        this.warehouseID = warehouseID;
    }

    public String getConstructionType() {
        return constructionType;
    }

    public void setConstructionType(String constructionType) {
        this.constructionType = constructionType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getCompliances() {
        return compliances;
    }

    public void setCompliances(String compliances) {
        this.compliances = compliances;
    }

    public Collection<Addresstb> getAddresstbCollection() {
        return addresstbCollection;
    }

    public void setAddresstbCollection(Collection<Addresstb> addresstbCollection) {
        this.addresstbCollection = addresstbCollection;
    }

    public Collection<Scheduletb> getScheduletbCollection() {
        return scheduletbCollection;
    }

    public void setScheduletbCollection(Collection<Scheduletb> scheduletbCollection) {
        this.scheduletbCollection = scheduletbCollection;
    }

    public Servicetb getServiceID() {
        return serviceID;
    }

    public void setServiceID(Servicetb serviceID) {
        this.serviceID = serviceID;
    }

    public Usertb getUserID() {
        return userID;
    }

    public void setUserID(Usertb userID) {
        this.userID = userID;
    }

    @JsonbTransient
    public Collection<Bookingtb> getBookingtbCollection() {
        return bookingtbCollection;
    }

    public void setBookingtbCollection(Collection<Bookingtb> bookingtbCollection) {
        this.bookingtbCollection = bookingtbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (warehouseID != null ? warehouseID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warehousetb)) {
            return false;
        }
        Warehousetb other = (Warehousetb) object;
        if ((this.warehouseID == null && other.warehouseID != null) || (this.warehouseID != null && !this.warehouseID.equals(other.warehouseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Warehousetb[ warehouseID=" + warehouseID + " ]";
    }
    
}
