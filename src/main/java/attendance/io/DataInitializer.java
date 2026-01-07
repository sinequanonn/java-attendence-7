package attendance.io;

import attendance.domain.Attendance;
import attendance.domain.AttendanceRepository;
import attendance.domain.Crew;
import attendance.exception.ErrorMessage;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataInitializer {
    public static final String PATH = "src/main/resources/attendances.csv";
    public static final String DELIMITER_COMMA = ",";
    public static final int SIZE = 2;
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


    public static AttendanceRepository init() {
        List<String> lines = FileReader.readAllLines(Path.of(PATH));
        Map<Crew, List<Attendance>> attendances = new LinkedHashMap<>();
        for (String line : lines) {
            String[] split = line.split(DELIMITER_COMMA);
            if (split.length != SIZE) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_FILE.getMessage());
            }
            String name = split[0];
            LocalDateTime localDateTime = LocalDateTime.parse(split[1].trim(), DATETIME_FORMATTER);

            Crew crew = new Crew(name.trim());
            Attendance attendance = new Attendance(localDateTime);
            List<Attendance> attendanceList = attendances.getOrDefault(crew, new ArrayList<>());
            attendanceList.add(attendance);
            attendances.put(crew, attendanceList);
        }
        return AttendanceRepository.init(attendances);
    }
}
