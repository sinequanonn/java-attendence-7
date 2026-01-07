package attendance.domain;

import java.time.LocalDateTime;

public class Attendance {
    private LocalDateTime localDateTime;
//    private AttendanceType attendanceType;

    public Attendance(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public boolean isSameLocalDate(LocalDateTime localDateTime) {
        return this.localDateTime.getMonth().equals(localDateTime.getMonth())
                && this.localDateTime.getDayOfMonth() == localDateTime.getDayOfMonth();
    }
}
