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
@Table(name = "invoicetb")
@NamedQueries({
    @NamedQuery(name = "Invoicetb.findAll", query = "SELECT i FROM Invoicetb i"),
    @NamedQuery(name = "Invoicetb.findByInvoiceID", query = "SELECT i FROM Invoicetb i WHERE i.invoiceID = :invoiceID"),
    @NamedQuery(name = "Invoicetb.findByAmount", query = "SELECT i FROM Invoicetb i WHERE i.amount = :amount"),
    @NamedQuery(name = "Invoicetb.findByDate", query = "SELECT i FROM Invoicetb i WHERE i.date = :date"),
    @NamedQuery(name = "Invoicetb.findByTransactionID", query = "SELECT i FROM Invoicetb i WHERE i.transactionID = :transactionID")})
public class Invoicetb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "InvoiceID")
    private Integer invoiceID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount")
    private double amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TransactionID")
    private int transactionID;
    @JoinColumn(name = "BookingID", referencedColumnName = "BookingID")
    @ManyToOne(optional = false)
    private Bookingtb bookingID;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private Usertb userID;

    public Invoicetb() {
    }

    public Invoicetb(Integer invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Invoicetb(Integer invoiceID, double amount, Date date, int transactionID) {
        this.invoiceID = invoiceID;
        this.amount = amount;
        this.date = date;
        this.transactionID = transactionID;
    }

    public Integer getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(Integer invoiceID) {
        this.invoiceID = invoiceID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public Bookingtb getBookingID() {
        return bookingID;
    }

    public void setBookingID(Bookingtb bookingID) {
        this.bookingID = bookingID;
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
        hash += (invoiceID != null ? invoiceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoicetb)) {
            return false;
        }
        Invoicetb other = (Invoicetb) object;
        if ((this.invoiceID == null && other.invoiceID != null) || (this.invoiceID != null && !this.invoiceID.equals(other.invoiceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Invoicetb[ invoiceID=" + invoiceID + " ]";
    }
    
}
