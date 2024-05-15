package Commands;

import Classes.MusicBand;
import Console.MyConsole;
import Managers.CollectionManager;
import Managers.InputHandler;
import Managers.MusicBandRequester;

public class Add extends Command {
    public Add(String name, String descr) {
        super(name, descr);
    }
    @Override
    public void execute(String[] args) {
        if (args.length != 1) throw new ArrayIndexOutOfBoundsException("Здесь не должно быть аргументов!");
        MusicBandRequester musicBandRequester = new MusicBandRequester();
        MusicBand newMusicBand = null;
        InputHandler inputHandler = InputHandler.getInstance();
        if (inputHandler.getflagOfUserMode()) {
            newMusicBand = musicBandRequester.requestUserBand();
        } else {
            newMusicBand = musicBandRequester.requestNonUserBand();
        }
        boolean result = CollectionManager.add(newMusicBand);
        if (result) {
            MyConsole.println();
            MyConsole.println("--------------------------");
            MyConsole.println("Новая музыкальная группа добавлена в коллекцию.");
        } else MyConsole.println("Исправьте скрипт и проверьте, чтобы все передаваемые значения были валидны");
    }
}