package Commands;

import Console.MyConsole;
import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.DumpManager;


public class Save extends Command {
    public Save(String name, String descr) {
        super(name, descr);
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) throw new ArrayIndexOutOfBoundsException("Здесь не должно быть аргументов");
        try {
            DumpManager.save();
            if (CommandManager.getFlagOfCorrectArgument()) MyConsole.println("Коллекция успешно сохранена в файл");
        } catch (UnsupportedOperationException e) {
            MyConsole.println(e.getMessage());
        }
    }
}