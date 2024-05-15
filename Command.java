package Commands;

public abstract class Command implements CommandInterface {
    String name;
    String descr;

    public Command(String name, String descr) {
        this.name = name; this.descr = descr;
    }
    @Override
    public String getDescr() {
        return descr;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public abstract void execute(String[] args);
}
