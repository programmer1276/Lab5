package Commands;

import Console.MyConsole;
import Managers.CollectionManager;

public class Clear extends Command {
    public Clear(String name, String descr) {
        super(name, descr);
    }

    @Override
    public void execute(String[] args){
        if (args.length != 1) throw new ArrayIndexOutOfBoundsException("Здесь не должно быть аргументов!");
        boolean result = CollectionManager.clear();
        if (result) {
            MyConsole.println();
            MyConsole.println("--------------------------");
            MyConsole.println("Коллекция была очищена");
        } else MyConsole.println("Воспользуйтесь командой \\\"add\\\" чтобы добавить элемент в коллекцию");
    }
}
