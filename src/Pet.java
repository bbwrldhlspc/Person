public class Pet extends RecordWithBirthday {
    private String name;
    private String species;

    @Override
    public void askUserData() {
        name = Main.askString("Name: ");
        species = Main.askString("Specie: ");
        super.askUserData();
    }

    @Override
    public boolean contains(String part) {
        return super.contains(part)
                || name.contains(part)
                || species.contains(part);
    }

    @Override
    public String toString() {
        String strBirthday = Main.DATE_FORMATTER.format(getBirthday());
        return "Reminder" +
                "{id=" + getId() +
                ", Name='" + name + '\'' +
                ", Specie='" + species + '\'' +
                ", Birthday='" + strBirthday + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
