import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reminder extends Alarm {
    public static final String DATE_FORMAT="dd/MM/yyyy";
    public static final DateTimeFormatter DATE_FORMATTER
            = DateTimeFormatter.ofPattern(DATE_FORMAT);
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
        String strDate = Main.askString("What date should I remind you this? ("+ DATE_FORMAT +") :");
        LocalDate date = LocalDate.parse(strDate, DATE_FORMATTER);
        setDate(date);
    }

    @Override
    public String toString() {
        return "Reminder" +
                "{id=" + getId() +
                ", text='" + getText() + '\'' +
                ", time='" + getTime() + '\'' +
                ", date='" + DATE_FORMATTER.format(date) + '\'' +
                '}';
    }

    @Override
    public boolean contains(String part) {
        String strDate = DATE_FORMATTER.format(date);
        return super.contains(part)
                || strDate.contains(part);
    }
}
