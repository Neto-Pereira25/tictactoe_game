package br.edu.ifpe.discente.ppoo.tictactoe.factory;

import javax.swing.JButton;
import java.awt.Font;

public class TicTacToeButtonFactory extends ButtonFactory {
    @Override
    public JButton createButton() {
        JButton button = new JButton(" ");
        button.setFont(new Font("Arial", Font.BOLD, 40));
        return button;
    }
}
