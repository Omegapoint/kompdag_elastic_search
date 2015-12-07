package se.omegapoint.models;

public class Response {
    private final boolean success;
    private final String errorMessage;
    private final Entity entity;

    public Response(final boolean success, final String errorMessage, final Entity entity) {
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
    public Entity getEntity() {
        return entity;
    }
}
