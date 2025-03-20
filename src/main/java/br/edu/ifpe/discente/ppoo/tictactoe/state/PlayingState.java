package br.edu.ifpe.discente.ppoo.tictactoe.state;

import br.edu.ifpe.discente.ppoo.tictactoe.model.TicTacToe;

public class PlayingState implements GameState {
    @Override
    public void handle(TicTacToe game) {
        // Verificar se alguém ganhou
        String winner = game.checkWinner();
        if (winner != null) {
            game.updateScore(winner.charAt(0));
            game.setState(new WinState(winner.charAt(0)));
            return;
        }

        // Verificar se houve empate
        if (game.isBoardFull()) {
            game.setState(new DrawState());
            return;
        }

        game.notifyListeners();
    }

    @Override
    public boolean canMakeMove() {
        return true;
    }

    @Override
    public String getStatusMessage() {
        return "Vez do jogador ";
    }
}
