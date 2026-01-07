package attendance.service;

import attendance.domain.Attendance;
import attendance.domain.AttendanceRepository;
import attendance.domain.Crew;
import camp.nextstep.edu.missionutils.DateTimes;

import java.time.LocalDateTime;
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
        return DateTimes.now();
    }
}
