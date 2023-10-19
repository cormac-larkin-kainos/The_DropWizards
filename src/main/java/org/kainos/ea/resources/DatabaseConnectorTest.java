package org.kainos.ea.resources;

import org.kainos.ea.db.DatabaseConnector;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.SQLException;

@Path("/api")
public class DatabaseConnectorTest {

    private DatabaseConnector databaseConnector = new DatabaseConnector();

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public void testConnection() {


       try {
           Connection conn =  DatabaseConnector.getConnection();
           if (conn != null) {
               System.out.println("Successfully connected to database");
           } else {
               System.out.println("Connection failed");
           }
       } catch (SQLException e) {
           System.err.println(e.getMessage());
       }
    }

}
