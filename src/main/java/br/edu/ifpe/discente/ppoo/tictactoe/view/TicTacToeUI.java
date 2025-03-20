package br.edu.ifpe.discente.ppoo.tictactoe.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.ifpe.discente.ppoo.tictactoe.factory.ButtonFactory;
import br.edu.ifpe.discente.ppoo.tictactoe.factory.TicTacToeButtonFactory;
import br.edu.ifpe.discente.ppoo.tictactoe.model.TicTacToe;
import br.edu.ifpe.discente.ppoo.tictactoe.model.TicTacToeListener;

public class TicTacToeUI extends JFrame implements TicTacToeListener {
    private TicTacToe game;
    private JButton[][] buttons = new JButton[3][3];
    private JLabel statusLabel = new JLabel("Vez do jogador X");
    private JLabel scoreLabel = new JLabel("X: 0 | O: 0");
    private ButtonFactory buttonFactory;

    public TicTacToeUI(TicTacToe game) {
        this.game = game;
        this.game.addListener(this); // Registra a UI como ouvinte do jogo
        this.buttonFactory = new TicTacToeButtonFactory();

        setTitle("Jogo da Velha");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Usar a fábrica para criar os botões
                buttons[i][j] = buttonFactory.createButton();
                int row = i, col = j;
                buttons[i][j].addActionListener(e -> makeMove(row, col));
                boardPanel.add(buttons[i][j]);
            }
        }

        JPanel controlPanel = new JPanel();
        JButton undoButton = new JButton("Desfazer");
        JButton resetButton = new JButton("Resetar");
        undoButton.addActionListener(e -> game.undoMove());
        resetButton.addActionListener(e -> game.resetBoard());
        controlPanel.add(undoButton);
        controlPanel.add(resetButton);

        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        infoPanel.add(statusLabel);
        infoPanel.add(scoreLabel);

        add(infoPanel, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
        setLocationRelativeTo(null); // Centralizar na tela
    }

    private void makeMove(int row, int col) {
        game.makeMove(row, col);
    }

    @Override
    public void onGameUpdated() {
        updateBoard();
        updateStatusMessage();
        updateScoreLabel();
    }

    private void updateBoard() {
        char[][] board = game.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText(board[i][j] == '\0' ? " " : String.valueOf(board[i][j]));
            }
        }
    }

    private void updateStatusMessage() {
        String baseMessage = game.getCurrentState().getStatusMessage();
        if (baseMessage.contains("venceu") || baseMessage.equals("Empate!")) {
            statusLabel.setText(baseMessage);
        } else {
            statusLabel.setText(baseMessage + game.getCurrentPlayer());
        }
    }

    private void updateScoreLabel() {
        scoreLabel.setText("X: " + game.getScoreX() + " | O: " + game.getScoreO());
    }
}