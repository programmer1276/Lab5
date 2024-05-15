package Commands;


import Classes.MusicBand;
import Console.MyConsole;
import Exceptions.EmptyCollectionException;
import Managers.CollectionManager;

public class Info extends Command {
    public Info(String name, String descr) {
        super(name, descr);
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) throw new ArrayIndexOutOfBoundsException("В параметрах функции нет элементов!");
        if (CollectionManager.getCollection() == null) {
            MyConsole.println("    -Тип коллекции: " + null
                    + "\n   -Количество элементов: " + 0 + " т.к. null"
                    + "\n   -Дата создания: " + CollectionManager.getCollectionInitialisationDate());
        } else {
            MyConsole.println("    -Тип коллекции: " + CollectionManager.getCollection().getClass().toString()
                    + "\n   -Количество элементов: " + CollectionManager.getCollection().size()
                    + "\n   -Дата создания: " + CollectionManager.getCollectionInitialisationDate());
        }
    }
}