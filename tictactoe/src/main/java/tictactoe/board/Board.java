package tictactoe.board;

public class Board {
	private String[][] board;
	private int size = 3;

	public Board() {
		board = new String[size][size];
		// Inicializando o tabuleiro com espaços vazios
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = " ";
			}
		}
	}

	// Método para limpar uma célula (desfazer a jogada)
	public void clearCell(int row, int col) {
		board[row][col] = " "; // Deixa a célula vazia
	}

	public String getCell(int row, int col) {
		return board[row][col];
	}

	public boolean makeMove(int row, int col, String player) {
		if (board[row][col].equals(" ")) {
			board[row][col] = player;
			return true;
		}
		return false;
	}

	public boolean checkWin(String player) {
		// Verificar linhas, colunas e diagonais
		for (int i = 0; i < size; i++) {
			if ((board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player))
					|| (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player))) {
				return true;
			}
		}
		// Verificando diagonais
		if ((board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
				|| (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board[i][j].equals(" ")) {
					return false;
				}
			}
		}
		return true;
	}
}
