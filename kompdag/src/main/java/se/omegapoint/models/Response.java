package se.omegapoint.models;

public class Response {
    private final boolean success;
    private final String errorMessage;
    private final BaseEntity baseEntity;

    public Response(final boolean success, final String errorMessage, final BaseEntity baseEntity) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.baseEntity = baseEntity;
    }

    public boolean isSuccess() {
        return success;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public BaseEntity getBaseEntity() {
        return baseEntity;
    }
}
