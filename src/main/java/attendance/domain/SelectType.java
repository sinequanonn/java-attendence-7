package attendance.domain;

import java.util.Arrays;

public enum SelectType {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    QUIT("Q");

    private final String selection;

    SelectType(String selection) {
        this.selection = selection;
    }

    public String getSelection() {
        return selection;
    }

    public static boolean contains(String input) {
        return Arrays.stream(SelectType.values())
                .anyMatch(type -> type.selection.equals(input));
    }
}
