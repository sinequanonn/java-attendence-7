package attendance.exception;

public enum ErrorMessage {
    INVALID_INPUT("잘못된 형식을 입력하였습니다."),;

    public static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
