package br.edu.ifpe.discente.ppoo.tictactoe;

import br.edu.ifpe.discente.ppoo.tictactoe.model.TicTacToe;
import br.edu.ifpe.discente.ppoo.tictactoe.view.TicTacToeUI;

public class Main {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        new TicTacToeUI(ticTacToe);
    }
}