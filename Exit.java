package Commands;

import Console.MyConsole;

public class Exit extends Command {
    public Exit(String name, String descr) {
        super(name, descr);
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) throw new ArrayIndexOutOfBoundsException("У данной команды не должно быть параметров!");
        MyConsole.println("Спасибо за работу с нашей пограммой. До свидания и хорошего дня!");
        System.exit(0);
    }
}
