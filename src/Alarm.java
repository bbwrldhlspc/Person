import java.time.LocalTime;

public class Alarm extends Note implements Expirable {
    private LocalTime time;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Alarm" +
                "{id=" + getId() +
                ", text='" + getText() + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    @Override
    public void askUserData() {
        super.askUserData();
        LocalTime time = Main.askTime("Enter time: ");
        setTime(time);
    }

    @Override
    public boolean contains(String part) {
        String strTime = Main.TIME_FORMATTER.format(time);
        return super.contains(part)
                || strTime.contains(part);
    }

    @Override
    public boolean isExpired() {
        LocalTime now = LocalTime.now();
        return time.isBefore(now);
    }
}
