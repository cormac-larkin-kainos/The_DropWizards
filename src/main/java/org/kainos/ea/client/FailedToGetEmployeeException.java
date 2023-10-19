package org.kainos.ea.client;

public class FailedToGetEmployeeException extends Throwable {

    @Override
    public String getMessage() {
        return "An error occurred, unable to retrieve Employee.";
    }
}
