import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reminder extends Alarm implements Expirable{
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public void askUserData() {
        super.askUserData();
        LocalDate date = Main.askDate("Enter date: ");
        setDate(date);
    }

    @Override
    public String toString() {
        return "Reminder" +
                "{id=" + getId() +
                ", text='" + getText() + '\'' +
                ", time='" + getTime() + '\'' +
                ", date='" + Main.DATE_FORMATTER.format(date) + '\'' +
                '}';
    }

    @Override
    public boolean contains(String part) {
        String strDate = Main.DATE_FORMATTER.format(date);
        return super.contains(part)
                || strDate.contains(part);
    }

    @Override
    public boolean isExpired() {
        LocalDateTime nowDT = LocalDateTime.now();
        LocalDateTime dt = getDate().atTime(getTime());
        return dt.isBefore(nowDT);
    }
}