/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "bookingtb")
@NamedQueries({
    @NamedQuery(name = "Bookingtb.findAll", query = "SELECT b FROM Bookingtb b"),
    @NamedQuery(name = "Bookingtb.findByBookingID", query = "SELECT b FROM Bookingtb b WHERE b.bookingID = :bookingID"),
    @NamedQuery(name = "Bookingtb.findByBookingStartDate", query = "SELECT b FROM Bookingtb b WHERE b.bookingStartDate = :bookingStartDate"),
    @NamedQuery(name = "Bookingtb.findByBookingEndDate", query = "SELECT b FROM Bookingtb b WHERE b.bookingEndDate = :bookingEndDate")})
public class Bookingtb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BookingID")
    private Integer bookingID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BookingStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingStartDate;
    @Column(name = "BookingEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingEndDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingID")
    private Collection<Invoicetb> invoicetbCollection;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private Usertb userID;
    @JoinColumn(name = "warehouseID", referencedColumnName = "warehouseID")
    @ManyToOne(optional = false)
    private Warehousetb warehouseID;

    public Bookingtb() {
    }

    public Bookingtb(Integer bookingID) {
        this.bookingID = bookingID;
    }

    public Bookingtb(Integer bookingID, Date bookingStartDate) {
        this.bookingID = bookingID;
        this.bookingStartDate = bookingStartDate;
    }

    public Integer getBookingID() {
        return bookingID;
    }

    public void setBookingID(Integer bookingID) {
        this.bookingID = bookingID;
    }

    public Date getBookingStartDate() {
        return bookingStartDate;
    }

    public void setBookingStartDate(Date bookingStartDate) {
        this.bookingStartDate = bookingStartDate;
    }

    public Date getBookingEndDate() {
        return bookingEndDate;
    }

    public void setBookingEndDate(Date bookingEndDate) {
        this.bookingEndDate = bookingEndDate;
    }

    @JsonbTransient
    public Collection<Invoicetb> getInvoicetbCollection() {
        return invoicetbCollection;
    }

    public void setInvoicetbCollection(Collection<Invoicetb> invoicetbCollection) {
        this.invoicetbCollection = invoicetbCollection;
    }

    public Usertb getUserID() {
        return userID;
    }

    public void setUserID(Usertb userID) {
        this.userID = userID;
    }

    public Warehousetb getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(Warehousetb warehouseID) {
        this.warehouseID = warehouseID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingID != null ? bookingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookingtb)) {
            return false;
        }
        Bookingtb other = (Bookingtb) object;
        if ((this.bookingID == null && other.bookingID != null) || (this.bookingID != null && !this.bookingID.equals(other.bookingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bookingtb[ bookingID=" + bookingID + " ]";
    }
    
}
