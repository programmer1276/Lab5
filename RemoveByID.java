package Commands;

import Console.MyConsole;
import Managers.CollectionManager;
import Managers.CommandManager;

import java.util.NoSuchElementException;

public class RemoveByID extends Command {

    public RemoveByID(String name, String descr) {
        super(name, descr);
    }

    @Override
    public void execute(String[] args){
        if (args.length > 2) throw new ArrayIndexOutOfBoundsException("Здесь должен быть только 1 аргумент! (тип: int)");
        try {
            int id = Integer.parseInt(args[1]);
            boolean result = CollectionManager.removeById(id);
            if (result) {
                MyConsole.println("--------------------------");
                MyConsole.println("Музыкальная группа с id " + id + " успешно была удалена из коллекции");
            }
        } catch (NoSuchElementException e){
            CommandManager.setFlagOfCorrectArgument(false);
            MyConsole.println("В коллекции нет элемента с данным индексом");
        }
    }
}