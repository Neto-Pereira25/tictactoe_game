package br.edu.ifpe.discente.ppoo.tictactoe.state;

import br.edu.ifpe.discente.ppoo.tictactoe.model.TicTacToe;

public interface GameState {
  void handle(TicTacToe game);

  boolean canMakeMove();

  String getStatusMessage();
}
