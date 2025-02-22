package tictactoe.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tictactoe.board.Board;
import tictactoe.command.Command;
import tictactoe.command.MoveCommand;
import tictactoe.observer.Observer;

public class TicTacToeGUI extends JFrame implements Observer {
    
	private static final long serialVersionUID = 1L;
	
	private Board board;
    private JButton[][] buttons;
    private String currentPlayer;
    private Stack<Command> commandHistory; // Pilha para armazenar comandos
    private ArrayList<Observer> observers;
    
    public TicTacToeGUI() {
        this.board = new Board();
        this.buttons = new JButton[3][3];
        this.currentPlayer = "X";
        this.commandHistory = new Stack<>();
        this.observers = new ArrayList<>();
        setTitle("Jogo da Velha");
        setLayout(new BorderLayout());

        // Painel do tabuleiro
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));
        
        // Inicializar os botões do tabuleiro
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                boardPanel.add(buttons[i][j]);
            }
        }

        // Botão de desfazer
        JButton undoButton = new JButton("Desfazer");
        undoButton.addActionListener(new UndoButtonClickListener());
        
     // Criar o botão de reset
        JButton resetButton = new JButton("Resetar Jogo");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();  // Chama o método para resetar o jogo
            }
        });

        // Adicionando o painel do tabuleiro e o botão de desfazer
        add(resetButton, BorderLayout.BEFORE_FIRST_LINE);
        add(boardPanel, BorderLayout.CENTER);
        add(undoButton, BorderLayout.SOUTH);

        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void resetGame() {
        // Limpar o tabuleiro
        board = new Board();  // Cria uma nova instância do tabuleiro, resetando ele

        // Limpar os botões da interface gráfica (colocando texto vazio)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");  // Remove qualquer texto dos botões
            }
        }

        // Resetar o jogador (começando com "X")
        currentPlayer = "X";

        // Reaplicar a atualização visual do tabuleiro
        notifyObservers();  // Atualizar a interface gráfica
    }

    // Listener do botão de jogada
    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (board.makeMove(row, col, currentPlayer)) {
                buttons[row][col].setText(currentPlayer);
                
                // Criando e armazenando o comando de movimento
                Command moveCommand = new MoveCommand(board, row, col, currentPlayer);
                moveCommand.execute();
                commandHistory.push(moveCommand); // Adicionando à pilha de comandos
                
                if (board.checkWin(currentPlayer)) {
                    JOptionPane.showMessageDialog(null, currentPlayer + " ganhou!");
                } else if (board.isFull()) {
                    JOptionPane.showMessageDialog(null, "Empate!");
                } else {
                    currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                }

                notifyObservers();
            }
        }
    }

    // Listener do botão de desfazer
    private class UndoButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!commandHistory.isEmpty()) {
                // Desfazendo o último movimento
                Command lastCommand = commandHistory.pop();
                lastCommand.undo();  // Desfazendo a última jogada
                
                currentPlayer = currentPlayer.equals("X") ? "O" : "X";  // Alterna o jogador após desfazer
                notifyObservers(); // Atualizando a interface gráfica
            } else {
                JOptionPane.showMessageDialog(null, "Não há movimentos para desfazer.");
            }
        }
    }

    @Override
    public void update() {
        // Atualiza a interface após uma jogada ou desfazer
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText(board.getCell(i, j));
            }
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}