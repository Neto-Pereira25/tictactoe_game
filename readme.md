# Jogo de Damas - Projeto em Java

Este é um projeto de implementação do clássico **Jogo de Damas**, criado utilizando **Java** com a biblioteca **Swing** para a interface gráfica. O projeto implementa diversos padrões de projeto de software para organizar e modularizar a lógica do jogo.

## Sumário
- [Introdução](#introducao)
- [Tecnologias Utilizadas](#tecnologias)
- [Funcionalidades](#funcionalidades)
- [Padrões de Projeto](#padrões)
- [Instalação](#instalacao)
- [Executando o Projeto](#executando)

## Introdução
O **Jogo de Damas** é um jogo de tabuleiro para dois jogadores, onde o objetivo é capturar ou bloquear as peças do adversário. Este projeto simula a versão digital do jogo, utilizando Java para a lógica e Swing para a interface gráfica.

## Tecnologias Utilizadas
- **Java**: Linguagem de programação para implementar a lógica do jogo.
- **Swing**: Biblioteca para construção da interface gráfica.
- **Git**: Controle de versão para gerenciar o código-fonte.

## Funcionalidades
- **Tabuleiro de 8x8**: Representação gráfica de um tabuleiro de damas, com casas claras e escuras.
- **Movimento de peças**: Movimentos válidos e captura de peças do adversário.
- **Promoção de peças**: Quando uma peça chega à última linha, ela se transforma em dama, com movimentação especial.
- **Controle de turnos**: Alternância entre os jogadores e controle de vitória.
- **Interface gráfica**: Interface amigável e intuitiva utilizando o Swing.

## Padrões de Projeto
O projeto faz uso de diversos padrões de design para melhorar a estrutura e a manutenção do código. Alguns dos principais padrões utilizados são:

- **Composite**: Para tratar as peças de forma hierárquica, permitindo que as peças normais e as damas sejam manipuladas de maneira uniforme.
- **Iterator**: Para percorrer o tabuleiro e as peças de forma eficiente e modular.
- **Chain of Responsibility**: Para encadear as verificações e ações durante o movimento das peças, como capturas e promoções.
- **Observer**: Para notificar a interface gráfica sempre que o estado do jogo mudar (ex: movimento, captura, mudança de turno).
- **Template Method**: Para definir o esqueleto de um turno, com a possibilidade de customizar as etapas, como movimentação e validação.

## Instalação
Para instalar e executar o projeto, siga os passos abaixo:

1. Clone o repositório do projeto:
    ```bash
    git clone https://github.com/seu-usuario/jogo-de-damas.git
    ```
2. Abra o projeto na sua IDE preferida (como IntelliJ IDEA, Eclipse ou NetBeans).
3. Certifique-se de que o **JDK** esteja instalado e configurado corretamente.
4. Compile o projeto para verificar se não há erros de sintaxe ou dependências ausentes.

## Executando o Projeto
Para executar o jogo, siga os passos abaixo:

1. Após abrir o projeto na IDE, localize o arquivo **Main.java**.
2. Clique com o botão direito e selecione "Executar" ou utilize o atalho apropriado para iniciar o jogo.
3. A interface gráfica será aberta, e você poderá começar a jogar com outra pessoa localmente, alternando os turnos.

---

Projeto desenvolvido como parte da avaliação da disciplina de Padrões de Projeto Orientado à Objetos.

Desenvolvedor: **[José Neto](https://github.com/Neto-Pereira25)** e **[Lucas Gabriel](https://github.com/luke-rocha3)**
