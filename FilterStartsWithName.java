package Commands;

import Console.MyConsole;
import Managers.CollectionManager;

public class FilterStartsWithName extends Command {
    public FilterStartsWithName(String name, String descr) {
        super(name, descr);
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) throw new ArrayIndexOutOfBoundsException("Здесь должен быть 1 элемент - имя элемента вхождение которого вы хотите проверить!");
        boolean result = CollectionManager.filterStartsWithName(args[1]);
        if (result) {
            for (int i = 0; i < CollectionManager.getElementToFind().size(); i++) {
                MyConsole.println("Элемент с ID " + CollectionManager.getElementToFind().get(i).getID() + ": " + CollectionManager.getElementToFind().get(i).getName());
            }
            CollectionManager.getElementToFind().clear();
        }
        else MyConsole.println("Элементы с именем, начинающимся на заданную подстроку не найдено");
    }
}
