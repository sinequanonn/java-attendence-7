package attendance.view;

import attendance.utils.CustomDayOfWeek;
import camp.nextstep.edu.missionutils.Console;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

public class InputView {
    public static final String INPUT_SELECTION = "오늘은 %s월 %02d일 %s요일입니다. 기능을 선택해 주세요.\n" +
            "1. 출석 확인\n" +
            "2. 출석 수정\n" +
            "3. 크루별 출석 기록 확인\n" +
            "4. 제적 위험자 확인\n" +
            "Q. 종료\n";
    private static final String INPUT_CREW_NAME = "닉네임을 입력해 주세요.";

    public String input() {
        return Console.readLine();
    }

    public String inputSelection(LocalDateTime localDateTime) {
        System.out.printf(INPUT_SELECTION, localDateTime.getMonth().getValue(),
                localDateTime.getDayOfMonth(),
                CustomDayOfWeek.convert(localDateTime.getDayOfWeek()));
        return Console.readLine();
    }

    public String inputCrewName() {
        System.out.println(INPUT_CREW_NAME);
        return Console.readLine();
    }
}
