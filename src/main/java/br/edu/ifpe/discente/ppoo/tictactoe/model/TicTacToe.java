package br.edu.ifpe.discente.ppoo.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.discente.ppoo.tictactoe.command.CommandManager;
import br.edu.ifpe.discente.ppoo.tictactoe.command.MoveCommand;
import br.edu.ifpe.discente.ppoo.tictactoe.state.GameState;
import br.edu.ifpe.discente.ppoo.tictactoe.state.PlayingState;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private int scoreX, scoreO;
    private List<TicTacToeListener> listeners = new ArrayList<>();
    private CommandManager commandManager;
    private GameState currentState;

    public TicTacToe() {
        commandManager = new CommandManager();
        currentState = new PlayingState();
        resetBoard();
    }

    public void resetBoard() {
        board = new char[3][3];
        currentPlayer = 'X';
        commandManager.clearHistory();
        currentState = new PlayingState();
        notifyListeners();
    }

    public boolean makeMove(int row, int col) {
        if (!currentState.canMakeMove()) {
            return false;
        }

        if (board[row][col] == '\0') {
            // Criar e executar comando
            MoveCommand command = new MoveCommand(this, row, col, currentPlayer);
            commandManager.executeCommand(command);

            // Processar o resultado da jogada
            currentState.handle(this);

            return true;
        }
        return false;
    }

    public void placeMove(int row, int col, char player) {
        board[row][col] = player;
        switchPlayer();
    }

    public void clearCell(int row, int col) {
        board[row][col] = '\0';
    }

    public void undoMove() {
        if (commandManager.canUndo()) {
            MoveCommand lastCommand = (MoveCommand) commandManager.undoLastCommand();
            // Trocar de jogador de volta para quem fez a última jogada
            currentPlayer = lastCommand.getPlayer();
            notifyListeners();
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public String checkWinner() {
        // Verificar linhas
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '\0' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return String.valueOf(board[i][0]);
        }

        // Verificar colunas
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != '\0' && board[0][i] == board[1][i] && board[1][i] == board[2][i])
                return String.valueOf(board[0][i]);
        }

        // Verificar diagonais
        if (board[0][0] != '\0' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return String.valueOf(board[0][0]);

        if (board[0][2] != '\0' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return String.valueOf(board[0][2]);

        return null;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    public void updateScore(char winner) {
        if (winner == 'X')
            scoreX++;
        else if (winner == 'O')
            scoreO++;
    }

    public void setState(GameState state) {
        this.currentState = state;
        state.handle(this);
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public int getScoreX() {
        return scoreX;
    }

    public int getScoreO() {
        return scoreO;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }

    // Observer pattern (para atualizar a interface gráfica)
    public void addListener(TicTacToeListener listener) {
        listeners.add(listener);
    }

    public void notifyListeners() {
        for (TicTacToeListener listener : listeners) {
            listener.onGameUpdated();
        }
    }
}