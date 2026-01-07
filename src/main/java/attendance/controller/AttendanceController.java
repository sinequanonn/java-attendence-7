package attendance.controller;

import attendance.domain.*;
import attendance.exception.ErrorMessage;
import attendance.service.AttendanceService;
import attendance.utils.InputConverter;
import attendance.view.InputView;
import attendance.view.OutputView;

import java.time.LocalDateTime;
import java.util.List;

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
        OpenTime.checkGoingSchoolTime(localDateTime);
        String crewName = inputView.inputCrewName();
        attendanceService.checkExistCrew(crewName);
        attendanceService.checkAlreadyExist(crewName, localDateTime);
        OpenTime.checkCampusOpen(new Time(localDateTime.getHour(), localDateTime.getMinute()));
        List<Integer> time = InputConverter.convertTime(inputView.inputAttendanceTime());
        int hour = time.get(0);
        int minute = time.get(1);
        OpenTime.validateAttendanceTime(new Time(hour, minute));
        attendanceService.saveAttendance(crewName, localDateTime, hour, minute);

    }

    private String InputSelection(LocalDateTime localDateTime) {
        String input = inputView.inputSelection(localDateTime);
        if (!SelectType.contains(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        return input;
    }
}
