package org.kainos.ea.client;

public class InvalidEmployeeException extends Throwable {
    @Override
    public String getMessage() {
        return "Invalid employee must contain appropriate fields";
    }
}
