package attendance.controller;

import attendance.domain.Attendance;
import attendance.domain.Crew;
import attendance.domain.SelectType;
import attendance.service.AttendanceService;
import attendance.view.InputView;
import attendance.view.OutputView;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class AttendanceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final AttendanceService attendanceService;

    public AttendanceController(InputView inputView, OutputView outputView, AttendanceService attendanceService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.attendanceService = attendanceService;
    }

    public void run() {
        LocalDateTime localDateTime = attendanceService.initTodayDateTime();
        String selection;
        do {
            selection = InputSelection(localDateTime);
            try {
                processAttendanceSystem(selection);
            } catch (IllegalArgumentException exception) {
                break;
            }
        } while (!selection.equals(SelectType.QUIT));
    }

    private static void processAttendanceSystem(String selection) {
        if (selection.equals(SelectType.ONE)) {
            //TODO
        }
        if (selection.equals(SelectType.TWO)) {
            //TODO
        }
        if (selection.equals(SelectType.THREE)) {
            //TODO
        }
    }

    private String InputSelection(LocalDateTime localDateTime) {
        return inputView.inputSelection(localDateTime);
    }
}
