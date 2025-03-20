# Jogo da Velha - Projeto de Padrões de Projeto Orientado a Objetos

## Descrição do Projeto

Este projeto implementa um Jogo da Velha em Java, utilizando quatro importantes padrões de projeto:

1. **Padrão Command** - Para gerenciar jogadas e possibilitar a funcionalidade de desfazer
2. **Padrão State** - Para controlar os diferentes estados do jogo (jogando, vitória, empate)
3. **Padrão Observer** - Para notificar a interface quando o modelo é alterado
4. **Padrão Factory Method** - Para criar os botões da interface gráfica

## Estrutura do Projeto

O projeto segue uma arquitetura MVC (Model-View-Controller) modificada:

```
src/
├── br/
│   └── edu/
│       └── ifpe/
│           └── discente/
│               └── ppoo/
│                   └── tictactoe/
│                       ├── command/
│                       │   ├── Command.java
│                       │   ├── CommandManager.java
│                       │   └── MoveCommand.java
│                       ├── factory/
│                       │   ├── ButtonFactory.java
│                       │   └── TicTacToeButtonFactory.java
│                       ├── model/
│                       │   ├── TicTacToe.java
│                       │   └── TicTacToeListener.java
│                       ├── state/
│                       │   ├── DrawState.java
│                       │   ├── GameState.java
│                       │   ├── PlayingState.java
│                       │   └── WinState.java
│                       └── view/
│                           └── TicTacToeUI.java
```

## Padrões de Projeto Implementados

### Padrão Command

O padrão Command encapsula uma solicitação como um objeto, permitindo parametrizar clientes com diferentes solicitações e suportar operações que podem ser desfeitas.

- **Command**: Interface que define os métodos `execute()` e `undo()`
- **MoveCommand**: Implementação concreta que representa uma jogada
- **CommandManager**: Gerencia o histórico de comandos executados

### Padrão State

O padrão State permite que um objeto altere seu comportamento quando seu estado interno muda, parecendo mudar de classe.

- **GameState**: Interface que define o comportamento comum a todos os estados
- **PlayingState**: Estado durante o jogo normal
- **WinState**: Estado quando um jogador vence
- **DrawState**: Estado quando o jogo termina em empate

### Padrão Observer

O padrão Observer define uma dependência um-para-muitos entre objetos, de modo que quando um objeto muda de estado, todos os seus dependentes são notificados e atualizados automaticamente.

- **Subject (TicTacToe)**: O modelo que mantém uma lista de observadores e os notifica quando seu estado muda
- **Observer (TicTacToeListener)**: Interface implementada pelos observadores que desejam ser notificados
- **ConcreteObserver (TicTacToeUI)**: Implementação concreta que reage às notificações

### Padrão Factory Method

O padrão Factory Method define uma interface para criar um objeto, mas permite que as subclasses decidam qual classe instanciar.

- **Creator (ButtonFactory)**: Interface abstrata que define o método `createButton()`
- **ConcreteCreator (TicTacToeButtonFactory)**: Implementação concreta que cria botões

## Funcionalidades

- Tabuleiro de jogo 3x3
- Alternância automática entre jogadores X e O
- Detecção de vitória (linhas, colunas e diagonais)
- Detecção de empate
- Contador de pontuação para cada jogador
- Função para desfazer a última jogada
- Função para resetar o tabuleiro

## Como Executar o Projeto

1. Certifique-se de ter o JDK instalado (versão 8 ou superior)
2. Clone este repositório
3. Compile o projeto:
   ```
   javac src/br/edu/ifpe/discente/ppoo/tictactoe/**/*.java
   ```
4. Execute o jogo:
   ```
   java -cp src br.edu.ifpe.discente.ppoo.tictactoe.Main
   ```

## Diagrama de Classes

```
+----------------+      +----------------+      +----------------+
|   TicTacToe    |<--->| TicTacToeListener |<-|  TicTacToeUI   |
+----------------+      +----------------+      +----------------+
        |                                              |
        v                                              v
+----------------+      +----------------+      +----------------+
|   GameState    |<--->|  CommandManager |      | ButtonFactory  |
+----------------+      +----------------+      +----------------+
   ^    ^    ^                 |                       |
   |    |    |                 v                       v
   |    |    |          +----------------+      +----------------+
+-----+ |  +-----+      |  MoveCommand   |      |TicTacToeButton |
|Win  | |  |Draw |      +----------------+      |    Factory     |
|State| |  |State|                               +----------------+
+-----+ |  +-----+
        |
     +--------+
     |Playing |
     | State  |
     +--------+
```

## Considerações Finais
* Este projeto foi desenvolvido por [José Neto](https://github.com/Neto-Pereira25) e [Lucas Gabriel](https://github.com/luke-rocha3) como requisito para a conclusão da disciplina de Padrões de Projeto Orientado à Objetos.
