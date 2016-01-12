package se.omegapoint.models;

import java.util.Collection;
import se.omegapoint.models.db.AbstractEntity;

import java.util.Optional;

public class Response<T extends AbstractEntity> {
    private final boolean success;
    private final String errorMessage;
    private final Collection<T> entities;

    public Response(final boolean success, final String errorMessage, final Collection<T> entities) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.entities = entities;
    }

    public boolean isSuccess() {
        return success;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public Collection<T> getEntities() {
        return entities;
    }
}
