/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import videos.VideoDAO;

/**
 * REST Web Service
 *
 * @author silvia
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Sample of GET method
     * @param info
     * @param fecha
     * @return 
     */
    @Path("getInfo")
    @GET    
    @Produces("text/html")
    public String freeSeats(@QueryParam("info") String info, 
                            @QueryParam("fecha") String fecha) {
        
        return "<html><head></head> <body> Info" + info + " en fecha " + fecha + " </body></html>";
    }

    /**
     * Sample of POST method
     * 
     * @param info
     * @param fecha
     * @return 
     */
    @Path("postInfo")   
    @POST    
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/html")
    public String postInfo (  @FormParam("info") String info, 
                              @FormParam("fecha") String fecha) 
    {                
        return "<html><head></head> <body> Información recibida " + info + "en fecha" + fecha + " </body></html>";
    }    
    
    /**
     *
     * @param id
     * @return 
     */
    @Path("incrementarReproducciones/{id}")   
    @POST    
    public Response incrementarReproducciones (  @PathParam("id") Integer id)
    {                
        try{
            VideoDAO.incrementarNumeroReproducciones(id);
            return Response.ok().build();
        } catch(Exception e){
            return Response.status(Response.Status.EXPECTATION_FAILED).entity(e).build();
        }      
    }  
}
