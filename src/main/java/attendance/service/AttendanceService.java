package attendance.service;

import attendance.domain.Attendance;
import attendance.domain.AttendanceRepository;
import attendance.domain.Crew;
import attendance.exception.ErrorMessage;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Map;

public class AttendanceService {
    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public Map<Crew, List<Attendance>> findAllAttendances() {
        return attendanceRepository.getCrewAttendances();
    }

    public LocalDateTime initTodayDateTime() {
        return LocalDateTime.of(2024, 12, 18, 10, 3);
//        return DateTimes.now();
    }

    public void checkExistCrew(String crewName) {
        if (!attendanceRepository.checkExistCrew(crewName)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_CREW.getMessage());
        }
    }

    public void checkAlreadyExist(String crewName, LocalDateTime localDateTime) {
        List<Attendance> attendances = attendanceRepository.findAttendanceListByName(crewName);
        for (Attendance attendance : attendances) {
            if (attendance.isSameLocalDate(localDateTime)) {
                throw new IllegalArgumentException(ErrorMessage.EXIST_ATTENDANCE.getMessage());
            }
        }
    }

    public void saveAttendance(String crewName, LocalDateTime localDateTime, int hour, int minute) {
        int year = localDateTime.getYear();
        Month month = localDateTime.getMonth();
        int dayOfMonth = localDateTime.getDayOfMonth();
        LocalDateTime newLocalDateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
        Attendance attendance = new Attendance(newLocalDateTime);
        attendanceRepository.saveAttedance(new Crew(crewName), attendance);
    }
}
