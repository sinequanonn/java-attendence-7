package attendance.domain;

import attendance.exception.ErrorMessage;

import java.util.List;
import java.util.Map;

public class AttendanceRepository {
    private Map<Crew, List<Attendance>> crewAttendances;

    private AttendanceRepository(Map<Crew, List<Attendance>> crewAttendances) {
        this.crewAttendances = crewAttendances;
    }

    public static AttendanceRepository init(Map<Crew, List<Attendance>> crewAttendances) {
        return new AttendanceRepository(crewAttendances);
    }

    public Map<Crew, List<Attendance>> getCrewAttendances() {
        return crewAttendances;
    }

    public boolean checkExistCrew(String crewName) {
        for (Crew crew : crewAttendances.keySet()) {
            if (crew.getName().equals(crewName)) {
                return true;
            }
        }
        return false;
    }

    public List<Attendance> findAttendanceListByName(String crewName) {
        return crewAttendances.keySet().stream()
                .filter(crew -> crew.getName().equals(crewName))
                .map(crew -> crewAttendances.get(crew))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_CREW.getMessage()));
    }

    public void saveAttedance(Crew crew, Attendance attendance) {
        List<Attendance> attendances = crewAttendances.get(crew);
        attendances.add(attendance);
    }
}
