package se.omegapoint.models;

import java.util.Optional;

public class Response<T extends AbstractEntity> {
    private final boolean success;
    private final String errorMessage;
    private final Optional<T> entity;

    public Response(final boolean success, final String errorMessage, final Optional<T> entity) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.entity = entity;
    }

    public boolean isSuccess() {
        return success;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public Optional<T> getEntity() {
        return entity;
    }
}
