package attendance.domain;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Arrays;

public enum Late {
    MON_LATE(DayOfWeek.MONDAY, new Time(13, 6), new Time(13, 30)),
    TUE_LATE(DayOfWeek.TUESDAY, new Time(10, 6), new Time(10, 30)),
    WED_LATE(DayOfWeek.WEDNESDAY, new Time(10, 6), new Time(10, 30)),
    TUR_LATE(DayOfWeek.THURSDAY, new Time(10, 6), new Time(10, 30)),
    FRI_LATE(DayOfWeek.FRIDAY, new Time(10, 6), new Time(10, 30)),
    ;

    private final DayOfWeek dayOfWeek;
    private final Time startTime;
    private final Time endTime;

    Late(DayOfWeek dayOfWeek, Time startTime, Time endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static AttendanceType calculateAttendanceType(LocalDateTime localDateTime) {
        Time time = new Time(localDateTime.getHour(), localDateTime.getMinute());
        if (isAbsence(localDateTime, time)) {
            return AttendanceType.ABSENCE;
        }
        if (isLate(localDateTime, time)) {
            return AttendanceType.LATE;
        }
        return AttendanceType.ATTENDANCE;
    }

    private static boolean isAbsence(LocalDateTime localDateTime, Time time) {
        return Arrays.stream(Late.values())
                .anyMatch(late -> late.dayOfWeek == localDateTime.getDayOfWeek() && time.isAfter(late.endTime));
    }

    private static boolean isLate(LocalDateTime localDateTime, Time time) {
        return Arrays.stream(Late.values())
                .anyMatch(late -> late.dayOfWeek == localDateTime.getDayOfWeek() && time.isAfter(late.startTime));
    }
}
