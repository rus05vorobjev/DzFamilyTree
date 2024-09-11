package view.commands;

import view.ConsoleUI;

public class GetInfoHumans extends Command {


    public GetInfoHumans(ConsoleUI consoleUI) {
        super("Получить список людей", consoleUI);
    }

    @Override
    public void execute() {
      getConsoleUI().getInfoHumans();
    }
}
