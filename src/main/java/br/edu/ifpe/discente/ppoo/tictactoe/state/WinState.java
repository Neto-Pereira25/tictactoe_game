package br.edu.ifpe.discente.ppoo.tictactoe.state;

import javax.swing.JOptionPane;

import br.edu.ifpe.discente.ppoo.tictactoe.model.TicTacToe;

public class WinState implements GameState {
    private final char winner;

    public WinState(char winner) {
        this.winner = winner;
    }

    @Override
    public void handle(TicTacToe game) {
        game.notifyListeners();

        // Mostrar mensagem de vitória
        JOptionPane.showMessageDialog(null,
                "Jogador " + winner + " venceu!",
                "Fim de Jogo",
                JOptionPane.INFORMATION_MESSAGE);

        // Resetar o tabuleiro para um novo jogo
        game.resetBoard();
    }

    @Override
    public boolean canMakeMove() {
        return false;
    }

    @Override
    public String getStatusMessage() {
        return "Jogador " + winner + " venceu!";
    }
}
