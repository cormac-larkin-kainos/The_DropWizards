package org.kainos.ea.client;

public class FailedToCreateEmployeeException extends Throwable {

    @Override
    public String getMessage() {
        return "Failed to insert into Employee table";
    }
}
