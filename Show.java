package Commands;

import java.util.Arrays;

import Console.MyConsole;
import Exceptions.EmptyCollectionException;
import Managers.CollectionManager;


public class Show extends Command {
    public Show(String name, String descr) {
        super(name, descr);
    }

    @Override
    public void execute(String[] args){
        try {
            if (args.length != 1) throw new ArrayIndexOutOfBoundsException("Здесь не должно быть аргументов");
            boolean result = CollectionManager.show();
            if (result) {
                for (Object element : CollectionManager.getCollection()) {
                    MyConsole.println("--------------------------");
                    MyConsole.println(element.toString());
                }
            } else MyConsole.println("В коллекции пусто! Заполните ее чем-нибудь");
        } catch (NullPointerException e) {
            MyConsole.println(e.getMessage());
        }
    }
}