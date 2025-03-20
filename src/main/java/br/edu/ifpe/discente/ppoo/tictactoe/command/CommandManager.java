package br.edu.ifpe.discente.ppoo.tictactoe.command;

import java.util.Stack;

public class CommandManager {
    private Stack<Command> history = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public boolean canUndo() {
        return !history.isEmpty();
    }

    public Command undoLastCommand() {
        if (!history.isEmpty()) {
            Command lastCommand = history.pop();
            lastCommand.undo();
            return lastCommand;
        }
        return null;
    }

    public void clearHistory() {
        history.clear();
    }
}