package Commands;

import Console.MyConsole;
import Managers.CollectionManager;

import java.util.Collections;

public class Reorder extends Command {
    public Reorder(String name, String descr) {
        super(name, descr);
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) throw new ArrayIndexOutOfBoundsException("Здесь не должно быть аргументов!");
        boolean result = CollectionManager.reorder();
        if (result) {
            MyConsole.println("Коллекция перед сортировкой: " + CollectionManager.getCollection());
            MyConsole.println("Коллекция после сортировки: " + CollectionManager.getCollection());
        } else MyConsole.println("Коллекция null. Нельзя воспользоваться сортировкой");
    }
}