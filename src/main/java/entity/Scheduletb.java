/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "scheduletb")
@NamedQueries({
    @NamedQuery(name = "Scheduletb.findAll", query = "SELECT s FROM Scheduletb s"),
    @NamedQuery(name = "Scheduletb.findByScheduleID", query = "SELECT s FROM Scheduletb s WHERE s.scheduleID = :scheduleID"),
    @NamedQuery(name = "Scheduletb.findByDateTIme", query = "SELECT s FROM Scheduletb s WHERE s.dateTIme = :dateTIme")})
public class Scheduletb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ScheduleID")
    private Integer scheduleID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateTIme")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTIme;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private Usertb userID;
    @JoinColumn(name = "warehouseID", referencedColumnName = "warehouseID")
    @ManyToOne(optional = false)
    private Warehousetb warehouseID;

    public Scheduletb() {
    }

    public Scheduletb(Integer scheduleID) {
        this.scheduleID = scheduleID;
    }

    public Scheduletb(Integer scheduleID, Date dateTIme) {
        this.scheduleID = scheduleID;
        this.dateTIme = dateTIme;
    }

    public Integer getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(Integer scheduleID) {
        this.scheduleID = scheduleID;
    }

    public Date getDateTIme() {
        return dateTIme;
    }

    public void setDateTIme(Date dateTIme) {
        this.dateTIme = dateTIme;
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
        hash += (scheduleID != null ? scheduleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Scheduletb)) {
            return false;
        }
        Scheduletb other = (Scheduletb) object;
        if ((this.scheduleID == null && other.scheduleID != null) || (this.scheduleID != null && !this.scheduleID.equals(other.scheduleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Scheduletb[ scheduleID=" + scheduleID + " ]";
    }
    
}
