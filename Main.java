import Console.MyConsole;
import Exceptions.EmptyLineException;
import Managers.CommandManager;
import Managers.DumpManager;
import Managers.InputHandler;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if (!args[0].endsWith(".json")) args[0] = args[0] + ".json";
        MyConsole.println(Arrays.toString(args));
        if (args.length != 1) throw new ArrayIndexOutOfBoundsException("Здесь должен быть только один параметр - имя файла, с которым будет происходить дальнейшая работа программы");
        DumpManager.setFile(args[0]);
        DumpManager.parseCollectionFromJson(args[0]);

        MyConsole.println("Привет! Это программа для работы с коллекцией MusicBand. \n" +
                "Введите команду 'help' для более подробной информации");
        CommandManager.buildCommands();
        InputHandler inputHandler = InputHandler.getInstance();

        /**
         * Method for redirecting the stream to code block
         */
        Runtime.getRuntime().addShutdownHook(new Thread(DumpManager::save));
        while (true) {
            try {
                inputHandler.setInputFromConsole();
                CommandManager.executeCommand(inputHandler.getInput());
            } catch (EmptyLineException e) {
                MyConsole.println(e.getMessage());
            }
        }
    }
}