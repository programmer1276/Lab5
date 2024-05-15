package Commands;

import Classes.MusicBand;
import Console.MyConsole;
import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.MusicBandRequester;

public class Update extends Command {

    public Update(String name, String descr) {
        super(name, descr);
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) throw new ArrayIndexOutOfBoundsException("Здесь должен быть ровно 1 аргумент - id элемента коллкции который вы хотите поменять");
        try {
            MusicBandRequester musicBandRequester = new MusicBandRequester();
            int id = Integer.parseInt(args[1]);
            if (CollectionManager.getPreviousIDs().contains(id)) {
                CollectionManager.removeById(id);
                MusicBand updatedBand = musicBandRequester.requestUserBand();
                updatedBand.setId(id);
                CollectionManager.update(updatedBand);
            } else {
                CommandManager.setFlagOfCorrectArgument(false);
                MyConsole.println("Элемент коллекции с данным id не существует в коллекции");
            }
        } catch (NumberFormatException e) {
            CommandManager.setFlagOfCorrectArgument(false);
            MyConsole.println("Неверный формат ввода id. Введите пожалуйста число(тип int)");
        }
    }
}