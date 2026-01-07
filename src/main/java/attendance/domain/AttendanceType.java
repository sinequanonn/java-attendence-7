package attendance.domain;

public enum AttendanceType {
    ATTENDANCE("출석"),
    LATE("지각"),
    ABSENCE("결석"),;

    private final String type;

    AttendanceType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
