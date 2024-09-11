package view.commands;

import view.ConsoleUI;

public class AddSpouse extends Command{
    public AddSpouse(ConsoleUI consoleUI) {
        super("Добавить супруга(у)", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addSpouse();
    }
}
