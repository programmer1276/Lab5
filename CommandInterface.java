package Commands;

public interface CommandInterface {
    void execute(String[] args);
    String getDescr();
    String getName();
}
