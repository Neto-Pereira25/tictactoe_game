package br.edu.ifpe.discente.ppoo.tictactoe.state;

import javax.swing.JOptionPane;

import br.edu.ifpe.discente.ppoo.tictactoe.model.TicTacToe;

public class DrawState implements GameState {
    @Override
    public void handle(TicTacToe game) {
        game.notifyListeners();

        // Mostrar mensagem de empate
        JOptionPane.showMessageDialog(null,
                "Empate!",
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
        return "Empate!";
    }
}
