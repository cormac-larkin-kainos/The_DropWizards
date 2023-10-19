package org.kainos.ea.client;

public class FailedToDeleteDeliveryEmployeeException extends Throwable {
    @Override
    public String getMessage() {
        return "An error occurred, unable to delete the specified Delivery Employee";
    }
}
