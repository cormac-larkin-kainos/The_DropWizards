package org.kainos.ea.client;

public class FailedToFetchException extends Throwable {
    @Override
    public String getMessage() {
        return "Was not able to fetch any data";
    }
}
