package attendance.controller;

import attendance.domain.Attendance;
import attendance.domain.Crew;
import attendance.service.AttendanceService;
import attendance.view.InputView;
import attendance.view.OutputView;

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
        Map<Crew, List<Attendance>> allAttendances = attendanceService.findAllAttendances();
        for (Crew crew : allAttendances.keySet()) {
            List<Attendance> attendances = allAttendances.get(crew);
            System.out.println("Crew : " + crew.getName());
            for (Attendance attendance : attendances) {
                System.out.println("attendance = " + attendance.getLocalDateTime());
            }
        }
    }
}
