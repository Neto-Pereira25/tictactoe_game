# Jogo da Velha - Java com Swing

Este é um projeto simples de **Jogo da Velha** implementado em Java, utilizando a biblioteca Swing para criar a interface gráfica. O jogo permite que dois jogadores joguem alternadamente, com a possibilidade de desfazer movimentos e reiniciar o jogo a qualquer momento.

## Funcionalidades

- **Jogar Alternadamente**: Dois jogadores, "X" e "O", alternam entre as jogadas.
- **Desfazer Movimentos**: O jogador pode desfazer a última jogada.
- **Resetar o Jogo**: Reinicia a partida, limpando o tabuleiro e começando uma nova rodada.
- **Condições de Vitória**: O jogo verifica automaticamente se algum jogador venceu ou se ocorreu um empate.

## Como Executar

Para rodar o projeto, siga as instruções abaixo:

### Requisitos

- JDK 8 ou superior instalado.
- IDE como IntelliJ IDEA, Eclipse, ou NetBeans (ou pode ser executado via terminal).

### Passos para Executar

1. **Clone o Repositório**:
   ```bash
   git clone https://github.com/seu-usuario/jogo-da-velha.git
   cd jogo-da-velha
   ```
2. Compilar e Executar: Se você estiver utilizando a linha de comando, execute os seguintes comandos para compilar e rodar o projeto:
   ```bash
   javac Program.java
   java Program
   ```

### Funcionalidades dos Botões
* Botões do Tabuleiro: Cada célula do tabuleiro é representada por um botão que exibe "X" ou "O" quando um jogador faz sua jogada.
* Botão "Resetar Jogo": Reinicia a partida, limpando o tabuleiro e iniciando um novo jogo com o jogador "X".
* Botão "Desfazer": Permite que o jogador desfaça o último movimento feito.

### Padrões de Projeto Utilizados
* Command: Utilizado para encapsular as ações de fazer um movimento no jogo, o que facilita a implementação de desfazer a jogada.
* Observer: Usado para atualizar a interface gráfica sempre que o estado do tabuleiro muda, notificando os observadores (botões) sobre o novo estado.
* Factory Method: Potencialmente utilizado para criar objetos de movimentos ou outros elementos de forma dinâmica, caso a implementação seja expandida no futuro.

### Considerações Finais
* Este projeto foi desenvolvido por José Neto e Lucas Gabriel como requisito para a conclusão da disciplina de Padrões de Projeto Orientado à Objetos.
