package attendance;

import camp.nextstep.edu.missionutils.DateTimes;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

public class DateTimeTest {
    @Test
    void runTest() {
        LocalDateTime now = DateTimes.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        int value = dayOfWeek.getValue();
        System.out.println("value = " + value);
        System.out.println("dayOfWeek = " + dayOfWeek);
        int hour = now.getHour();
        System.out.println("hour = " + hour);
        int minute = now.getMinute();
        System.out.println("minute = " + minute);
        Month month = now.getMonth();
        System.out.println("month = " + month);
        int dayOfMonth = now.getDayOfMonth();
        System.out.println("dayOfMonth = " + dayOfMonth);
        int dayOfYear = now.getDayOfYear();
        System.out.println("dayOfYear = " + dayOfYear);
    }
}
