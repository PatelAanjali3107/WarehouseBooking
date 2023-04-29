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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "usertb")
@NamedQueries({
    @NamedQuery(name = "Usertb.findAll", query = "SELECT u FROM Usertb u"),
    @NamedQuery(name = "Usertb.findByUserID", query = "SELECT u FROM Usertb u WHERE u.userID = :userID"),
    @NamedQuery(name = "Usertb.findByFirstName", query = "SELECT u FROM Usertb u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "Usertb.findByLastName", query = "SELECT u FROM Usertb u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Usertb.findByEmail", query = "SELECT u FROM Usertb u WHERE u.email = :email"),
    @NamedQuery(name = "Usertb.findByPhoneNo", query = "SELECT u FROM Usertb u WHERE u.phoneNo = :phoneNo"),
    @NamedQuery(name = "Usertb.findByPassword", query = "SELECT u FROM Usertb u WHERE u.password = :password"),
    @NamedQuery(name = "Usertb.findByRegDate", query = "SELECT u FROM Usertb u WHERE u.regDate = :regDate")})
public class Usertb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserID")
    private Integer userID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FirstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LastName")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PhoneNo")
    private String phoneNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RegDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
    @JoinTable(name = "userservicetb", joinColumns = {
        @JoinColumn(name = "UserID", referencedColumnName = "UserID")}, inverseJoinColumns = {
        @JoinColumn(name = "ServiceID", referencedColumnName = "ServiceID")})
    @ManyToMany
    private Collection<Servicetb> servicetbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private Collection<Addresstb> addresstbCollection;
    @JoinColumn(name = "RoleID", referencedColumnName = "RoleID")
    @ManyToOne(optional = false)
    private Roletb roleID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private Collection<Invoicetb> invoicetbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private Collection<Scheduletb> scheduletbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private Collection<Warehousetb> warehousetbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private Collection<Bookingtb> bookingtbCollection;

    public Usertb() {
    }

    public Usertb(Integer userID) {
        this.userID = userID;
    }

    public Usertb(Integer userID, String firstName, String lastName, String email, String phoneNo, String password, Date regDate) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
        this.regDate = regDate;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @JsonbTransient
    public Collection<Servicetb> getServicetbCollection() {
        return servicetbCollection;
    }

    public void setServicetbCollection(Collection<Servicetb> servicetbCollection) {
        this.servicetbCollection = servicetbCollection;
    }

    @JsonbTransient
    public Collection<Addresstb> getAddresstbCollection() {
        return addresstbCollection;
    }

    public void setAddresstbCollection(Collection<Addresstb> addresstbCollection) {
        this.addresstbCollection = addresstbCollection;
    }

    public Roletb getRoleID() {
        return roleID;
    }

    public void setRoleID(Roletb roleID) {
        this.roleID = roleID;
    }

    @JsonbTransient
    public Collection<Invoicetb> getInvoicetbCollection() {
        return invoicetbCollection;
    }

    public void setInvoicetbCollection(Collection<Invoicetb> invoicetbCollection) {
        this.invoicetbCollection = invoicetbCollection;
    }

    @JsonbTransient
    public Collection<Scheduletb> getScheduletbCollection() {
        return scheduletbCollection;
    }

    public void setScheduletbCollection(Collection<Scheduletb> scheduletbCollection) {
        this.scheduletbCollection = scheduletbCollection;
    }

    @JsonbTransient
    public Collection<Warehousetb> getWarehousetbCollection() {
        return warehousetbCollection;
    }

    public void setWarehousetbCollection(Collection<Warehousetb> warehousetbCollection) {
        this.warehousetbCollection = warehousetbCollection;
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
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usertb)) {
            return false;
        }
        Usertb other = (Usertb) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usertb[ userID=" + userID + " ]";
    }
    
}
