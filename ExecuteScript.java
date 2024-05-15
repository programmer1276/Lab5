package Commands;

import Console.MyConsole;
import Managers.CommandManager;
import Managers.DumpManager;
import Managers.InputHandler;
import java.io.IOException;
import java.util.NoSuchElementException;

public class ExecuteScript extends Command {
    public ExecuteScript(String name, String descr) {
        super(name, descr);
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2)  throw new ArrayIndexOutOfBoundsException("Здесь должен быть один аргумент - путь до файла");
        try {
            boolean result = DumpManager.executeScript(args[1]);
            if (!result) {
                MyConsole.println("Файл пустой!");
            } else {
                MyConsole.println();
                MyConsole.println("--------------------------");
                MyConsole.println("Запускаем скрипт...");
            }
        } catch (IOException e) {
            CommandManager.setFlagOfCorrectArgument(false);
            MyConsole.println(e.getMessage());
        } catch (SecurityException e) {
            CommandManager.setFlagOfCorrectArgument(false);
            MyConsole.println("Доступ к файлу ограничен!");
        } catch (NoSuchElementException e) {
            CommandManager.setFlagOfCorrectArgument(false);
            MyConsole.println("EOF. Возвращение к user-mode");
            InputHandler inputHandler = InputHandler.getInstance();
            inputHandler.setflagOfUserMode(true);
        }
    }
}