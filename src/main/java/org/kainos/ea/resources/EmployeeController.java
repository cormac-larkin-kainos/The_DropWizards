package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.EmployeeService;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("The DropWizards Api Employee")
@Path("/api")
public class EmployeeController {

    private EmployeeService employeeService = new EmployeeService();
    @POST
    @Path("/employees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmployee(EmployeeRequest employee){

        try {
            return Response.ok(employeeService.createEmployee(employee)).build();
        } catch (InvalidEmployeeException e) {
           return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (FailedToCreateEmployeeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/employees/delivery")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDeliveryEmployees(){

        try {

            return Response.ok(employeeService.selectAllDeliveryEmployees()).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/employees/delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeByID(@PathParam("id") int id) {

        try {
            return Response.ok(employeeService.getDeliveryEmployeeByID(id)).build();
        } catch (FailedToGetEmployeeException e) {
            return Response.serverError().build();
        } catch (DeliveryEmployeeDoesNotExistException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/employees/delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDeliveryEmployeeByID(@PathParam("id") int id) {

        try {
            employeeService.deleteDeliveryEmployeeByID(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (FailedToDeleteDeliveryEmployeeException e) {
            return Response.serverError().build();
        } catch (DeliveryEmployeeDoesNotExistException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }
}
