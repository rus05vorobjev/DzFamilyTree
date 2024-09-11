package view.commands;

import view.ConsoleUI;

public class ReadingBytes extends Command{
    public ReadingBytes(ConsoleUI consoleUI) {
        super("Чтение файла", consoleUI);
    }

    @Override
    public void execute() {
       getConsoleUI().readingBytes();
    }
}
