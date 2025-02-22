package tictactoe.command;

import tictactoe.board.Board;

public class MoveCommand implements Command {
    private Board board;
    private int row, col;
    private String player;
    private String previousState;  // Estado anterior da célula

    public MoveCommand(Board board, int row, int col, String player) {
        this.board = board;
        this.row = row;
        this.col = col;
        this.player = player;
        this.previousState = board.getCell(row, col);  // Armazena o estado anterior da célula
    }

    @Override
    public void execute() {
        board.makeMove(row, col, player);  // Realiza a jogada
    }

    @Override
    public void undo() {
        // Limpa a célula ao desfazer a jogada, ou seja, devolve o estado anterior ("vazio")
        board.clearCell(row, col);  // Define a célula como "vazia" (espaco em branco)
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return previousState;
    }
}
