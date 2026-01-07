package attendance.utils;

import attendance.exception.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class InputConverter {
    public static final String DELIMITER_COLON = ":";

    public static List<Integer> convertTime(String input) {
        List<Integer> time = Arrays.stream(input.split(DELIMITER_COLON))
                .map(String::trim)
                .map(InputConverter::parseInt)
                .toList();

        if (time.size() != 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        return time;
    }

    public static Integer parseInt(String input) {
        try {
            int time = Integer.parseInt(input);
            validate(time);
            return time;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }

    private static void validate(int time) {
        if (time < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
