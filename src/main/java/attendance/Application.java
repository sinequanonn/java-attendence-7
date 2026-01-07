package attendance;

import attendance.controller.AttendanceController;
import attendance.io.DataInitializer;

public class Application {
    public static void main(String[] args) {
        AttendanceConfig attendanceConfig = new AttendanceConfig();
        AttendanceController attendanceController = attendanceConfig.attendanceController();

        attendanceController.run();
    }
}
