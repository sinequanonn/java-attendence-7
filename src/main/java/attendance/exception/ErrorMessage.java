package attendance.exception;

public enum ErrorMessage {
    INVALID_INPUT("잘못된 형식을 입력하였습니다."),
    INVALID_FILE("유효하지 않은 파일입니다."),
    INVALID_ATTENDANCE_DATE("%d월 %02d %s요일은 등교일이 아닙니다."),
    NOT_FOUND_CREW("등록되지 않은 닉네임입니다."),
    EXIST_ATTENDANCE("이미 출석을 확인하였습니다. 필요한 경우 수정 기능을 이용해주세요."),
    OUT_OF_CAMPUS_TIME("캠퍼스 운영 시간에만 출석이 가능합니다.");

    public static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
