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

    public boolean isBefore(Time time) {
        if (this.hour > time.hour) {
            return true;
        }
        if (this.hour == time.hour && this.minute > time.minute) {
            return true;
        }
        return false;
    }

    public boolean isAfter(Time time) {
        if (this.hour < time.hour) {
            return true;
        }
        if (this.hour == time.hour && this.minute < time.minute) {
            return true;
        }
        return false;
    }

    public boolean isEqualAndAfter(Time time) {
        if (this.hour < time.hour) {
            return true;
        }
        if (this.hour == time.hour && this.minute <= time.minute) {
            return true;
        }
        return false;
    }
}
