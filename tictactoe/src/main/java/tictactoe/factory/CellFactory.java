package tictactoe.factory;

public class CellFactory {
	public static Cell createCell(String player) {
        if (player.equals("X")) {
            return new XCell();
        } else if (player.equals("O")) {
            return new OCell();
        }
        return null;
    }
}
