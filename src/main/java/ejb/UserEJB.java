/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Addresstb;
import entity.Roletb;
import entity.Servicetb;
import entity.Usertb;
import entity.Warehousetb;
import entity.Warehousetb_;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author DELL
 */
@Stateless
public class UserEJB implements UserEJBLocal {
    
    @PersistenceContext(unitName="WarehousePU")
    EntityManager em;
    
    
    //Role operations
    @Override
    public void addRole(String roleType) {
            Roletb role = new Roletb();
            role.setRoleType(roleType);
            em.persist(role);
    }

    @Override
    public void updateRole(int roleID, String roleType) {
           Roletb role = (Roletb) em.find(Roletb.class, roleID);
           role.setRoleType(roleType);
           
           em.merge(role);
    }

    @Override
    public void removeRole(int roleID) {
        Roletb role = (Roletb) em.find(Roletb.class, roleID);
        em.remove(role);
    }

    @Override
    public Collection<Roletb> getAllRoles() {
        return em.createNamedQuery("Roletb.findAll").getResultList();
    }
    
    
    //User operations
    @Override
    public void addUser(String fname, String lname, String email, String phone, String Password, int roleID) {
    
        Roletb r = (Roletb) em.find(Roletb.class, roleID);
        Collection<Usertb> users =  r.getUsertbCollection();
        Timestamp regDate = new Timestamp(System.currentTimeMillis());
        
        Usertb user = new Usertb();
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setEmail(email);
        user.setPhoneNo(phone);
        user.setPassword(Password);
        user.setRoleID(r);
        user.setRegDate(regDate);
        users.add(user);
        r.setUsertbCollection(users);
        
        em.persist(user);
        em.merge(r); 
    }

    @Override
    public void updateUser(int userID, String fname, String lname, String email, String phone, String Password, int roleID) {

        Roletb r = (Roletb) em.find(Roletb.class,roleID);
        Collection<Usertb> users = r.getUsertbCollection();
        Date rdate = null;
        
        for(Usertb u: users)
        {
            if(u.getUserID() == userID)
            {
                rdate = u.getRegDate();
            }
        }
        Usertb u = (Usertb) em.find(Usertb.class, userID);
        users.remove(u);
        
        Usertb newUser = new Usertb();
        newUser.setFirstName(fname);
        newUser.setLastName(lname);
        newUser.setEmail(email);
        newUser.setPhoneNo(phone);
        newUser.setPassword(Password);
        newUser.setRegDate(rdate);
        newUser.setRoleID(r);
        
        users.add(newUser);
        r.setUsertbCollection(users);
        em.merge(newUser);
    }

    @Override
    public void removeUser(int userID,int RoleID) {
    
        Roletb r = (Roletb) em.find(Roletb.class, RoleID);
        
        Collection<Usertb> users = r.getUsertbCollection();
        Usertb u = (Usertb) em.find(Usertb.class, userID);
        users.remove(u);
        
        em.remove(u);
    }

    @Override
    public Collection<Usertb> getAllUser(int roleID) {
        
        Roletb r = (Roletb) em.find(Roletb.class, roleID);
        return r.getUsertbCollection();
    }

    @Override
    public void addService(String type, Float charge, String unit) {
        Servicetb s = new Servicetb();
        s.setServiceType(type);
        s.setCharge(charge);
        s.setChargePer(unit);
        em.persist(s);
    }

    @Override
    public void updateService(int serviceID, String type, Float charge, String unit) {
        Servicetb s = em.find(Servicetb.class, serviceID);
        
        s.setServiceType(type);
        s.setCharge(charge);
        s.setChargePer(unit);
        em.merge(s);
    }

    @Override
    public void removeService(int serviceID) {
        Servicetb s = em.find(Servicetb.class, serviceID);
        em.remove(s);
    }

    @Override
    public Collection<Servicetb> getAllServices() {
        return em.createNamedQuery("Servicetb.findAll").getResultList();
    }

    @Override
    public void addAddress(String country, String state, String city, String street, int zip, int wid, int uID) {

        Usertb u = em.find(Usertb.class, uID);
        Warehousetb w = em.find(Warehousetb.class, wid);
        
        Collection<Addresstb> uAddress = u.getAddresstbCollection();
        Collection<Addresstb> wAddress = w.getAddresstbCollection();
        
        Addresstb addr = new Addresstb();
        addr.setCountry(country);
        addr.setState(state);
        addr.setCity(city);
        addr.setStreet(street);
        addr.setZip(zip);
        addr.setWarehouseID(w);
        addr.setUserID(u);
        
        if(wid == 0)
        {
            uAddress.add(addr);
            em.merge(u);
        }
        else
        {
            wAddress.add(addr);
            em.merge(w);
        }
        em.persist(addr);
    }

    @Override
    public void updateAddress(int aID,String country, String state, String city, String street, int zip, int wid, int uID) {
        
        Usertb u = em.find(Usertb.class, uID);
        Warehousetb w = em.find(Warehousetb.class, wid);
        
        Collection<Addresstb> uAddrs = u.getAddresstbCollection();
        Collection<Addresstb> wAddrs = w.getAddresstbCollection();
        
        Addresstb addr = em.find(Addresstb.class, aID);
        addr.setCountry(country);
        addr.setState(state);
        addr.setCity(city);
        addr.setStreet(street);
        addr.setZip(zip);
        addr.setWarehouseID(w);
        addr.setUserID(u);
        
        u.setAddresstbCollection(uAddrs);
        w.setAddresstbCollection(wAddrs);
        em.merge(addr);
    }

    @Override
    public void removAddress(int aID, int wID, int uID) {
        Usertb u = em.find(Usertb.class, uID);
        Warehousetb w = em.find(Warehousetb.class, wID);
        
        Collection<Addresstb> uAddrs = u.getAddresstbCollection();
        Collection<Addresstb> wAddrs = w.getAddresstbCollection();
        
        Addresstb addr = em.find(Addresstb.class, aID);
        
        uAddrs.remove(addr);
        wAddrs.remove(addr);
        
        em.remove(addr);
    }

    @Override
    public Collection<Addresstb> getUserAddress(int uID) {
           Usertb u  = em.find(Usertb.class, uID);
           return u.getAddresstbCollection();
    }

    @Override
    public Collection<Addresstb> getWarehouseAddress(int wID) {
        Warehousetb w = em.find(Warehousetb.class, wID);
        return w.getAddresstbCollection();
    }

    @Override
    public void addUserToService(int sId, Collection<Integer> userIds) {
        Servicetb s = em.find(Servicetb.class, sId);
        Collection<Usertb> users = s.getUsertbCollection();
        
        for(Integer uid: userIds)
        {
            Usertb u = em.find(Usertb.class, uid);
            
            if(!users.contains(u))
            {
                Collection<Servicetb> allUsers = u.getServicetbCollection();
                users.add(u);
                allUsers.add(s);
                
                s.setUsertbCollection(users);
                u.setServicetbCollection(allUsers);
                
                em.merge(s);
            }
        }
    }

//    @Override
//    public void updateUserToService(int sId, Collection<Usertb> user) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public void removeUserFromService(int sId,Collection<Integer> userIds) {
        Servicetb s = em.find(Servicetb.class, sId);
        Collection<Usertb> users = s.getUsertbCollection();
        
        for(Integer uid: userIds)
        {
            Usertb u = em.find(Usertb.class, uid);
            
            if(users.contains(u))
            {
                Collection<Servicetb> allUsers = u.getServicetbCollection();
                users.remove(u);
                allUsers.remove(s);
                
                s.setUsertbCollection(users);
                u.setServicetbCollection(allUsers);  
                em.merge(s);
            }
        }
        
    }

    @Override
    public Collection<Servicetb> getServiceOfUser(int uId) {
        Usertb u = em.find(Usertb.class, uId);
        return u.getServicetbCollection();
    }
}
