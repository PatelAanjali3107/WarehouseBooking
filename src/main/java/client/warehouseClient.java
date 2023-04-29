/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:UserResource [user]<br>
 * USAGE:
 * <pre>
 *        warehouseClient client = new warehouseClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author DELL
 */
public class warehouseClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/WarehouseBookingSystem/resources";

    public warehouseClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("user");
    }

    public void removeRole(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeRole/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getAllServices(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getServices");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllRoles(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getRoles");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateRole(String id, String type) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateRole/{0}/{1}", new Object[]{id, type})).request().put(null);
    }

    public void addUser(String fname, String lname, String email, String phone, String Password, String rid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addUser/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{fname, lname, email, phone, Password, rid})).request().post(null);
    }

    public void updateAddress(String aid, String country, String state, String city, String street, String zip, String wid, String uid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateAddress/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{aid, country, state, city, street, zip, wid, uid})).request().put(null);
    }

    public void addAddress(String country, String state, String city, String street, String zip, String wid, String uid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addAddress/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{country, state, city, street, zip, wid, uid})).request().post(null);
    }

    public void updateUser(String uid, String fname, String lname, String email, String phone, String Password, String rid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateUser/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{uid, fname, lname, email, phone, Password, rid})).request().put(null);
    }

    public <T> T getWarehouseAddress(Class<T> responseType, String wid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getWarehouseAddress/{0}", new Object[]{wid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removAddress(String aid, String wid, String uid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeAddress/{0}/{1}/{2}", new Object[]{aid, wid, uid})).request().delete();
    }

    public void removeUser(String uid, String rid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeUser/{0}/{1}", new Object[]{uid, rid})).request().delete();
    }

    public void removeService(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeService/{0}", new Object[]{id})).request().delete();
    }

    public void addService(String type, String charge, String unit) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addService/{0}/{1}/{2}", new Object[]{type, charge, unit})).request().post(null);
    }

    public void updateService(String id, String type, String charge, String unit) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateService/{0}/{1}/{2}/{3}", new Object[]{id, type, charge, unit})).request().put(null);
    }

    public <T> T getAllUser(Class<T> responseType, String rid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllUsers/{0}", new Object[]{rid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getUserAddress(Class<T> responseType, String uid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserAddress/{0}", new Object[]{uid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addRole(String type) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addRole/{0}", new Object[]{type})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
