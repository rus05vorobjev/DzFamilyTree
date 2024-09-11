package view.commands;

import view.ConsoleUI;

public class SortBirthData extends Command{
    public SortBirthData(ConsoleUI consoleUI) {
        super("Отсортировать по возрасту", consoleUI);
    }

    @Override
    public void execute() {
      getConsoleUI().sortBirthData();
    }
}
