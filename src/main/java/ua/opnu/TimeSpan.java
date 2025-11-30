package ua.opnu;

public class TimeSpan {

    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException("Час не може бути від'ємним");
        }
        this.hours = hours + (minutes / 60);
        this.minutes = minutes % 60;
    }

    int getHours() {
        return this.hours;
    }

    int getMinutes() {
        return this.minutes;
    }

    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException("Аргументи не можуть бути від'ємними");
        }

        int totalCurrentMinutes = this.getTotalMinutes();
        int totalNewMinutes = (hours * 60) + minutes;

        int sumMinutes = totalCurrentMinutes + totalNewMinutes;

        this.hours = sumMinutes / 60;
        this.minutes = sumMinutes % 60;
    }

    void addTimeSpan(TimeSpan timespan) {
        if (timespan != null) {
            add(timespan.getHours(), timespan.getMinutes());
        }
    }

    double getTotalHours() {
        return this.hours + (this.minutes / 60.0);
    }

    int getTotalMinutes() {
        return (this.hours * 60) + this.minutes;
    }

    void subtract(TimeSpan span) {
        if (span == null) return;

        int currentTotal = this.getTotalMinutes();
        int otherTotal = span.getTotalMinutes();

        if (currentTotal >= otherTotal) {
            int diff = currentTotal - otherTotal;
            this.hours = diff / 60;
            this.minutes = diff % 60;
        }
    }

    void scale(int factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Фактор має бути більше 0");
        }

        int totalMinutes = this.getTotalMinutes();
        int scaledTotal = totalMinutes * factor;

        this.hours = scaledTotal / 60;
        this.minutes = scaledTotal % 60;
    }

    @Override
    public String toString() {
        return hours + "h " + minutes + "m";
    }
}