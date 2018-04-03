/**
 * Created by bbwrldhlspc on 4/3/2018.
 */
public class Alarm extends Note {

    public String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Alarm" +
                "{id=" + getId() +
                ", time='" + time + '\'' +
                '}';
    }

    @Override
    public void askTime() {
        String time = Main.askString("What time should alarm go off? ");
        setTime(time);
    }
}
