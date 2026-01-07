package attendance.utils;

import java.time.DayOfWeek;

public class CustomDayOfWeek {
    public static String convert(DayOfWeek dayOfWeek) {
        if (dayOfWeek.equals(DayOfWeek.MONDAY)) {
            return "월";
        }
        if (dayOfWeek.equals(DayOfWeek.TUESDAY)) {
            return "화";
        }
        if (dayOfWeek.equals(DayOfWeek.WEDNESDAY)) {
            return "수";
        }
        if (dayOfWeek.equals(DayOfWeek.THURSDAY)) {
            return "목";
        }
        if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
            return "금";
        }
        if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
            return "토";
        }
        return "일";
    }
}
