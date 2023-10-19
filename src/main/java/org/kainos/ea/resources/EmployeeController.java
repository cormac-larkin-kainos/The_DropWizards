package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.EmployeeService;
import org.kainos.ea.cli.EmployeeRequest;
import org.kainos.ea.client.DeliveryEmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToCreateEmployeeException;
import org.kainos.ea.client.FailedToGetEmployeeException;
import org.kainos.ea.client.InvalidEmployeeException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
}
