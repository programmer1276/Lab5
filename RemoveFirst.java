package Commands;

import Classes.MusicBand;
import Console.MyConsole;
import Exceptions.EmptyCollectionException;
import Managers.CollectionManager;

import java.util.NoSuchElementException;

public class RemoveFirst extends Command{

    public RemoveFirst(String name, String descr) {
        super(name, descr);
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) throw new ArrayIndexOutOfBoundsException("Здесь не должно быть аргументов!");
        try {
            boolean result = CollectionManager.removeFirst();
            if (result) {
                MyConsole.println("--------------------------");
                MyConsole.println("Первый элемент коллекции был удален!");
            } else MyConsole.println("Коллекция пуста, нельзя удалить первый элемент");
        } catch (NoSuchElementException e){
            MyConsole.println(e.getMessage());
        }
    }
}