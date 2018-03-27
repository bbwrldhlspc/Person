public class Note extends Record {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note" +
                "{id=" + getId() +
                ", note='" + text + '\'' +
                '}';
    }

    @Override
    public void askUserData() {
        String text = Main.askString("Enter your note in \"\": ");
        setText(text);
    }

    @Override
    public boolean contains(String part) {
        return text.contains(part);
    }
}
