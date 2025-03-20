package br.edu.ifpe.discente.ppoo.tictactoe.command;

import br.edu.ifpe.discente.ppoo.tictactoe.model.TicTacToe;

public class MoveCommand implements Command {
    private final TicTacToe game;
    private final int row, col;
    private final char player;

    public MoveCommand(TicTacToe game, int row, int col, char player) {
        this.game = game;
        this.row = row;
        this.col = col;
        this.player = player;
    }

    @Override
    public void execute() {
        game.placeMove(row, col, player);
    }

    @Override
    public void undo() {
        game.clearCell(row, col);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public char getPlayer() {
        return player;
    }
}
