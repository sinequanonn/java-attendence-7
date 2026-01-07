package attendance.domain;

import attendance.exception.ErrorMessage;
import attendance.utils.CustomDayOfWeek;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class OpenTime {

    public static void checkOpenTime(LocalDateTime localDateTime) {
        int month = localDateTime.getMonth().getValue();
        int day = localDateTime.getDayOfMonth();
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        String korDayOfWeek = CustomDayOfWeek.convert(dayOfWeek);
        String message = "[ERROR] " + month + "월 " + String.format("%02d", day) + "일 " + korDayOfWeek + "요일은 등교일이 아닙니다.";
        if (korDayOfWeek.equals("토") || korDayOfWeek.equals("일")) {
            throw new IllegalArgumentException(message);
        }

        // 성탄절인 경우
        if (month == 12 && day == 25) {
            throw new IllegalArgumentException(message);
        }
    }
}
