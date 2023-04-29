/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package resource;

import ejb.UserEJBLocal;
import entity.Addresstb;
import entity.Roletb;
import entity.Servicetb;
import entity.Usertb;
import java.sql.Timestamp;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author DELL
 */
@Path("user")
@RequestScoped
public class UserResource {

    @EJB UserEJBLocal ur;
    
    @Context
    private UriInfo context;

    public UserResource() {
    }
    
    
    @POST
    @Path("addRole/{type}")
    public void addRole(@PathParam("type") String roleType)
    {
        ur.addRole(roleType);
    }
    
    @PUT
    @Path("updateRole/{id}/{type}")
    public void updateRole(@PathParam("id")int roleID,@PathParam("type")String roleType)
    {
        ur.updateRole(roleID, roleType);
    }
    
    @DELETE
    @Path("removeRole/{id}")
    public void removeRole(@PathParam("id")int roleID)
    {
        ur.removeRole(roleID);
    }
    
    @GET
    @Path("getRoles")
    @Produces("application/json")
    public Collection<Roletb> getAllRoles(){
        return ur.getAllRoles();
    }
    
    @POST
        @Path("addUser/{fname}/{lname}/{email}/{phone}/{Password}/{rid}")    
    public void addUser(@PathParam("fname")String fname,@PathParam("lname")String lname,@PathParam("email")String email,@PathParam("phone")String phone,@PathParam("Password")String Password,@PathParam("rid")int roleID){
        ur.addUser(fname, lname, email, phone, Password, roleID);
    }
    
    @PUT
    @Path("updateUser/{uid}/{fname}/{lname}/{email}/{phone}/{Password}/{rid}")
    public void updateUser(@PathParam("uid")int userID,@PathParam("fname")String fname,@PathParam("lname")String lname,@PathParam("email")String email,@PathParam("phone")String phone,@PathParam("Password")String Password,@PathParam("rid")int roleID){
        ur.updateUser(userID, fname, lname, email, phone, Password, roleID);
    }
    
    @DELETE()
    @Path("removeUser/{uid}/{rid}")
    public void removeUser(@PathParam("uid")int userID,@PathParam("rid")int RoleID){
        ur.removeUser(userID, RoleID);
    }
    
    @GET
    @Path("getAllUsers/{rid}")
    @Produces("application/json")
    public Collection<Usertb> getAllUser(@PathParam("rid")int roleID){
        return ur.getAllUser(roleID);
    }
    
    @POST
    @Path("addService/{type}/{charge}/{unit}")
    public void addService(@PathParam("type")String type,@PathParam("charge")Float charge,@PathParam("unit")String unit)
    {
        ur.addService(type, charge, unit);
    }
    
    @PUT
    @Path("updateService/{id}/{type}/{charge}/{unit}")
    public void updateService(@PathParam("id")int serviceID,@PathParam("type")String type,@PathParam("charge")Float charge,@PathParam("unit")String unit)
    {
        ur.updateService(serviceID, type, charge, unit);
    }
    
    @DELETE
    @Path("removeService/{id}")
    public void removeService(@PathParam("id")int serviceID)
    {
        ur.removeService(serviceID);
    }
    
    @GET
    @Path("getServices")
    @Produces("application/json")
    public Collection<Servicetb> getAllServices()
    {
        return ur.getAllServices();
    }
    
    @POST
    @Path("addAddress/{country}/{state}/{city}/{street}/{zip}/{wid}/{uid}")
    public void addAddress(@PathParam("country")String country,@PathParam("state")String state,@PathParam("city")String city,@PathParam("street")String street,@PathParam("zip")int zip,@PathParam("wid")int wid,@PathParam("uid")int uID)
    {
        ur.addAddress(country, state, city, street, zip, wid, uID);
    }
    
    @PUT
    @Path("updateAddress/{aid}/{country}/{state}/{city}/{street}/{zip}/{wid}/{uid}")
    public void updateAddress(@PathParam("aid")int aID,@PathParam("country")String country,@PathParam("state")String state,@PathParam("city")String city,@PathParam("street")String street,@PathParam("zip")int zip,@PathParam("wid")int wid,@PathParam("uid")int uID)
    {
        ur.updateAddress(aID, country, state, city, street, zip, wid, uID);
    }
    
    @DELETE
    @Path("removeAddress/{aid}/{wid}/{uid}")
    public void removAddress(@PathParam("aid")int aID,@PathParam("wid")int wID,@PathParam("uid")int uID)
    {
        ur.removAddress(aID, wID, uID);
    }
    
    @GET
    @Path("getUserAddress/{uid}")
    @Produces("application/json")
    public Collection<Addresstb> getUserAddress(@PathParam("uid")int uID)
    {
        return ur.getUserAddress(uID);
    }
    
    @GET
    @Path("getWarehouseAddress/{wid}")
    @Produces("application/json")    
    public Collection<Addresstb> getWarehouseAddress(@PathParam("wid")int wID)
    {
        return ur.getWarehouseAddress(wID);
    }
}
