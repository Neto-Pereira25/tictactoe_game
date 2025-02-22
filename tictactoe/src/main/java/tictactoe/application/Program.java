package tictactoe.application;

import tictactoe.gui.TicTacToeGUI;

public class Program {

	public static void main(String[] args) {
		// Criando a instância da interface gráfica do jogo
        TicTacToeGUI game = new TicTacToeGUI();
        
        // Adicionando o observer (pode ser o próprio jogo ou outro componente que desejar)
        game.addObserver(game); 

	}

}
