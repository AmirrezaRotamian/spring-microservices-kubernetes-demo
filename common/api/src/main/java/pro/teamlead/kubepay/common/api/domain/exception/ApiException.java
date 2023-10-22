package pro.teamlead.kubepay.common.api.domain.exception;

public abstract class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public abstract String getType();
}
