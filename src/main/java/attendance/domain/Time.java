package attendance.domain;

public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public boolean isBefore(int hour, int minute) {
        if (this.hour > hour) {
            return true;
        }
        if (this.hour == hour && this.minute > minute) {
            return true;
        }
        return false;
    }

    public boolean isAfter(int hour, int minute) {
        if (this.hour < hour) {
            return true;
        }
        if (this.hour == hour && this.minute < minute) {
            return true;
        }
        return false;
    }
}
