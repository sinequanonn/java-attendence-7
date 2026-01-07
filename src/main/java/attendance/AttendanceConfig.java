package attendance;

import attendance.controller.AttendanceController;
import attendance.service.AttendanceService;
import attendance.view.InputView;
import attendance.view.OutputView;

public class AttendanceConfig {
    private InputView inputView;
    private OutputView outputView;
    private AttendanceService attendanceService;
    private AttendanceController attendanceController;

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public AttendanceService attendanceService() {
        if (attendanceService == null) {
            attendanceService = new AttendanceService();
        }
        return attendanceService;
    }

    public AttendanceController attendanceController() {
        if (attendanceController == null) {
            attendanceController = new AttendanceController(inputView(), outputView(), attendanceService());
        }
        return attendanceController;
    }
}
