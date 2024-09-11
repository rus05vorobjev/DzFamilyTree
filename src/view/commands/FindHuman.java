package view.commands;

import view.ConsoleUI;

public class FindHuman extends Command {

    public FindHuman(ConsoleUI consoleUI) {
        super("Найти человека", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().findHuman();
    }
}
