package attendance.service;

import attendance.domain.Attendance;
import attendance.domain.AttendanceRepository;
import attendance.domain.Crew;
import attendance.exception.ErrorMessage;
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
}
