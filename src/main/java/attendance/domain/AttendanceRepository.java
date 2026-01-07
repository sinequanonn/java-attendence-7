package attendance.domain;

import java.util.HashMap;
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
            if (crew.equals(crewName)) {
                return true;
            }
        }
        return false;
    }
}
