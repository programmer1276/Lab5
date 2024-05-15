package Classes;


public enum Country {
    GERMANY("GERMANY"),
    SPAIN("SPAIN"),
    INDIA("INDIA"),
    ITALY("ITALY"),
    THAILAND("THAILAND");

    final String name;
    Country(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}