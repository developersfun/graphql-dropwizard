package com.tdf;

import com.tdf.graphql.MyGraphQLSchema;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Resource Class
 * @version 1.0
 * @since 2020
 * @author thedevelopersfun
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class MyController {

    private MyGraphQLSchema myGraphQLSchema;

    private DeviceDAO  deviceDAO;
    public MyController(DeviceDAO  deviceDAO, MyGraphQLSchema myGraphQLSchema) {
        this.myGraphQLSchema=myGraphQLSchema;
        this.deviceDAO = deviceDAO;
    }

    /**
     * Test API
     * @param nm
     * @return
     */
    @GET
    @Path("/hello/{name}")
    public Device greet(@QueryParam(value = "name") String nm){
    return new Device("MOB20200002","S7","Samsung","BIDB997F","M001");
    }

    /**
     * Get all Devices
     * @return
     */
    @GET
    @UnitOfWork
    @Path("/devices")
    public List<Device> showDevices(){
        return deviceDAO.findAll();
    }

    /**
     * Add a device to DB
     * @param device
     * @return
     */
    @POST
    @UnitOfWork
    @Path("/addDevice")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addDevice(Device device){
        return deviceDAO.create(device);
    }

    /**
     * Edit a device
     * @param device
     * @return
     */
    @PUT
    @UnitOfWork
    @Path("/editDevice")
    @Consumes(MediaType.APPLICATION_JSON)
    public String editDevice(Device device){
        return deviceDAO.edit(device);
    }

    /**
     * Get Device by ID
     * @param deviceId
     * @return
     */
    @GET
    @UnitOfWork
    @Path("/getDeviceById")
    @Consumes(MediaType.APPLICATION_JSON)
    public Object getDeviceById(@QueryParam(value = "deviceId") String deviceId){
        Object d = deviceDAO.findDeviceById(deviceId);
        if(null==d){
            return "Cannot Find the value...!!";
        }
        return d;
    }

    /**
     * Get Device By Name
     * @param name
     * @return
     */
    @GET
    @UnitOfWork
    @Path("/getDeviceByName")
    @Consumes(MediaType.APPLICATION_JSON)
    public Object getDeviceByName(@QueryParam(value = "deviceName") String name){
        Object d = deviceDAO.findDeviceByName(name);
        if(null==d){
            return "Cannot Find the device with name : " + name + "...!!";
        }
        return d;
    }


    /**
     * Resource to get devices using GraphQL.
     * @param query
     * @return
     * @throws IOException
     */
    @POST
    @UnitOfWork
    @Path("/graphQl-devices")
    @Consumes(MediaType.TEXT_PLAIN)
    public Object getDevics(@Valid String query) throws IOException {
        Logger.getLogger("MyLogger").log(Level.INFO,"Query is : " + query);
        GraphQL graphQL = myGraphQLSchema.getGraphQL();

        ExecutionResult result = graphQL.execute(query);
        return result;
    }
}
