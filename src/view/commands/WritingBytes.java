package view.commands;

import view.ConsoleUI;

public class WritingBytes extends Command {
    public WritingBytes(ConsoleUI consoleUI) {
        super("Сохранить в файл", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().writingBytes();
    }
}
