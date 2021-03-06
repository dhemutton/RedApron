/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.restful;

import entity.Staff;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import stateless.StaffControllerLocal;
import ws.restful.datamodel.ErrorRsp;
import ws.restful.datamodel.RetrieveAllStaffsRsp;
import ws.restful.datamodel.RetrieveStaffRsp;

/**
 * REST Web Service
 *
 * @author MX
 */
@Path("Staff")
public class StaffResource {

    private StaffControllerLocal staffControllerLocal;

    @Context
    private UriInfo context;

    
    public StaffResource() {
        staffControllerLocal = lookupStaffControllerLocal();
    }
    
    @Path("retrieveAllStaffs")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveAllStaffs() {
        try{
            List <Staff> staffEntities = staffControllerLocal.retrieveAllStaffs();
            for(Staff c : staffEntities){
//                c.getAnswers().clear();
//                c.getEvents().clear();
            }
            RetrieveAllStaffsRsp retrieveAllCategoriesRsp = new RetrieveAllStaffsRsp(staffEntities);
            return Response.status(Status.OK).entity(retrieveAllCategoriesRsp).build();
        }
        catch(Exception ex){
            ex.printStackTrace();
            ErrorRsp errorRsp = new ErrorRsp(ex.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorRsp).build();
        }
    }
    
    @Path("retrieveStaffById/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retrieveStaffById(@PathParam("id") Long id) {
        try
        {
            Staff staff = staffControllerLocal.retrieveStaffById(id);
            
//            staff.getAnswers().clear();
//            staff.getEvents().clear();
            
            RetrieveStaffRsp retrieveStaffRsp = new RetrieveStaffRsp(staff);
            return Response.status(Status.OK).entity(retrieveStaffRsp).build();
        }
        catch (Exception ex){
            ErrorRsp errorRsp = new ErrorRsp(ex.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorRsp).build();
        }
    }

    private StaffControllerLocal lookupStaffControllerLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (StaffControllerLocal) c.lookup("java:global/RedApron/RedApron-ejb/StaffController!stateless.StaffControllerLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
}
