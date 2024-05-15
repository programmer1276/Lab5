package Commands;

import Managers.CommandManager;

public class History extends Command {
    public History(String name, String descr) {
        super(name, descr);
    }
    @Override
    public void execute(String[] args){
        if (args.length != 1) throw new ArrayIndexOutOfBoundsException("Здесь не должно быть аргументов");
        CommandManager.history();
    }
}

