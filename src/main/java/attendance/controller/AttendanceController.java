package attendance.controller;

import attendance.domain.Attendance;
import attendance.domain.Crew;
import attendance.domain.OpenTime;
import attendance.domain.SelectType;
import attendance.exception.ErrorMessage;
import attendance.service.AttendanceService;
import attendance.utils.Validator;
import attendance.view.InputView;
import attendance.view.OutputView;

import java.time.LocalDateTime;

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
            if (selection.equals(SelectType.ONE.getSelection())) {
                processRegisterAttendance(localDateTime);
            }
            if (selection.equals(SelectType.TWO.getSelection())) {
                //TODO
            }
            if (selection.equals(SelectType.THREE.getSelection())) {
                //TODO
            }
            if (selection.equals(SelectType.FOUR.getSelection())) {
                //TODO
            }
        } while (!selection.equals(SelectType.QUIT.getSelection()));
    }

    private void processRegisterAttendance(LocalDateTime localDateTime) {
        OpenTime.checkOpenTime(localDateTime);
        String crewName = inputView.inputCrewName();
        attendanceService.checkExistCrew(crewName);
        attendanceService.checkAlreadyExist(crewName, localDateTime);
    }

    private String InputSelection(LocalDateTime localDateTime) {
        String input = inputView.inputSelection(localDateTime);
        if (!SelectType.contains(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        return input;
    }
}
