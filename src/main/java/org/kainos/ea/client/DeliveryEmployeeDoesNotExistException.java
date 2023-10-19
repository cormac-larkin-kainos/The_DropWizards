package org.kainos.ea.client;

public class DeliveryEmployeeDoesNotExistException extends Throwable {

    @Override
    public String getMessage() {
        return "No Delivery Employee exists with the specified ID.";
    }
}
