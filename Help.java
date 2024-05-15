package Commands;

import Console.MyConsole;
import Managers.CommandManager;
public class Help extends Command {
    public Help(String name, String descr) {
        super(name, descr);
    }

    @Override
    public void execute(String[] args) {
            if (args.length != 1) throw new ArrayIndexOutOfBoundsException("Здесь не должно быть аргументов");
            MyConsole.println("Список доступных команд: ");
            for (String key: CommandManager.getCommandsHashMap().keySet()){
                MyConsole.println("    -" + key + ": " + CommandManager.getCommandsHashMap().get(key).getDescr());
            }
    }
}
