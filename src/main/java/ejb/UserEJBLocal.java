package ejb;

import entity.Addresstb;
import entity.Roletb;
import entity.Servicetb;
import entity.Usertb;
import entity.Warehousetb;
import java.sql.Timestamp;
import java.util.Collection;
import javax.ejb.Local;

@Local
public interface UserEJBLocal {
    
    //Role CRUD 
    public void addRole(String roleType);
    public void updateRole(int roleID,String roleType);
    public void removeRole(int roleID);
    public Collection<Roletb> getAllRoles();
    
    //User CRUD
    public void addUser(String fname,String lname,String email,String phone,String Password,int roleID);
    public void updateUser(int userID,String fname,String lname,String email,String phone,String Password,int roleID);
    public void removeUser(int userID,int RoleID);
    public Collection<Usertb> getAllUser(int roleID);
    
    //Service CRUD
    public void addService(String type,Float charge,String unit);
    public void updateService(int serviceID,String type,Float charge,String unit);
    public void removeService(int serviceID);
    public Collection<Servicetb> getAllServices();
    
    //Address CRUD
    public void addAddress(String country,String state,String city,String street,int zip,int wid,int uID);
    public void updateAddress(int aID,String country, String state, String city, String street, int zip, int wid, int uID);
    public void removAddress(int aID,int wID,int uID);
    public Collection<Addresstb> getUserAddress(int uID);
    public Collection<Addresstb> getWarehouseAddress(int wID);
    
    //UserToService CRUD
    public void addUserToService(int sId, Collection<Integer> userIds);
//    public void updateUserToService(int sId, Collection<Integer> userIds);
    public void removeUserFromService(int sId, Collection<Integer> userIds);
    public Collection<Servicetb> getServiceOfUser(int uId);
    
}   
