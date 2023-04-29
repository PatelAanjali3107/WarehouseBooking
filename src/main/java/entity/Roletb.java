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
@Table(name = "roletb")
@NamedQueries({
    @NamedQuery(name = "Roletb.findAll", query = "SELECT r FROM Roletb r"),
    @NamedQuery(name = "Roletb.findByRoleID", query = "SELECT r FROM Roletb r WHERE r.roleID = :roleID"),
    @NamedQuery(name = "Roletb.findByRoleType", query = "SELECT r FROM Roletb r WHERE r.roleType = :roleType")})
public class Roletb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RoleID")
    private Integer roleID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "RoleType")
    private String roleType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleID")
    private Collection<Usertb> usertbCollection;

    public Roletb() {
    }

    public Roletb(Integer roleID) {
        this.roleID = roleID;
    }

    public Roletb(Integer roleID, String roleType) {
        this.roleID = roleID;
        this.roleType = roleType;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @JsonbTransient
    public Collection<Usertb> getUsertbCollection() {
        return usertbCollection;
    }

    public void setUsertbCollection(Collection<Usertb> usertbCollection) {
        this.usertbCollection = usertbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleID != null ? roleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roletb)) {
            return false;
        }
        Roletb other = (Roletb) object;
        if ((this.roleID == null && other.roleID != null) || (this.roleID != null && !this.roleID.equals(other.roleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Roletb[ roleID=" + roleID + " ]";
    }
    
}
