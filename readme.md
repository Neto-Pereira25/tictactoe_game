<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jogo de Damas</title>
    <style>
        html {
            scroll-behavior: smooth;
        }

        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f9;
            color: #333;
        }

        h1 {
            color: #2c3e50;
        }

        h2 {
            color: #2980b9;
        }

        pre {
            background-color: #ecf0f1;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #bdc3c7;
            overflow: auto;
        }

        ul {
            margin-bottom: 15px;
        }

        footer {
            margin-top: 30px;
            text-align: center;
            color: #7f8c8d;
        }

        img {
            width: 20px;
            height: 20px;
        }

        .important {
            color: #e74c3c;
            font-weight: bold;
        }

        #scrollToTop {
            position: fixed;
            bottom: 20px;
            right: 20px;
            background-color: #2980b9;
            color: black;
            border: none;
            padding: 6px 9px;
            border-radius: 50%;
            cursor: pointer;
            font-size: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        #scrollToTop:hover {
            background-color: #3498db;
        }
    </style>
</head>

<body>
    <h1 id="inicio">Jogo de Damas - Projeto em Java</h1>
    <p>Este é um projeto de implementação do clássico <strong>Jogo de Damas</strong>, criado utilizando
        <strong>Java</strong> com a biblioteca <strong>Swing</strong> para a interface gráfica. O projeto implementa
        diversos padrões de projeto de software para organizar e modularizar a lógica do jogo.</p>

    <h2>Sumário</h2>
    <ul>
        <li><a href="#introducao">Introdução</a></li>
        <li><a href="#tecnologias">Tecnologias Utilizadas</a></li>
        <li><a href="#funcionalidades">Funcionalidades</a></li>
        <li><a href="#padrões">Padrões de Projeto</a></li>
        <li><a href="#instalacao">Instalação</a></li>
        <li><a href="#executando">Executando o Projeto</a></li>
    </ul>

    <h2 id="introducao">Introdução</h2>
    <p>O <strong>Jogo de Damas</strong> é um jogo de tabuleiro para dois jogadores, onde o objetivo é capturar ou
        bloquear as peças do adversário. Este projeto simula a versão digital do jogo, utilizando Java para a lógica e
        Swing para a interface gráfica.</p>

    <h2 id="tecnologias">Tecnologias Utilizadas</h2>
    <ul>
        <li><strong>Java</strong>: Linguagem de programação para implementar a lógica do jogo.</li>
        <li><strong>Swing</strong>: Biblioteca para construção da interface gráfica.</li>
        <li><strong>Git</strong>: Controle de versão para gerenciar o código-fonte.</li>
    </ul>

    <h2 id="funcionalidades">Funcionalidades</h2>
    <ul>
        <li><strong>Tabuleiro de 8x8</strong>: Representação gráfica de um tabuleiro de damas, com casas claras e
            escuras.</li>
        <li><strong>Movimento de peças</strong>: Movimentos válidos e captura de peças do adversário.</li>
        <li><strong>Promoção de peças</strong>: Quando uma peça chega à última linha, ela se transforma em dama, com
            movimentação especial.</li>
        <li><strong>Controle de turnos</strong>: Alternância entre os jogadores e controle de vitória.</li>
        <li><strong>Interface gráfica</strong>: Interface amigável e intuitiva utilizando o Swing.</li>
    </ul>

    <h2 id="padrões">Padrões de Projeto</h2>
    <p>O projeto faz uso de diversos padrões de design para melhorar a estrutura e a manutenção do código. Alguns dos
        principais padrões utilizados são:</p>
    <ul>
        <li><strong>Composite</strong>: Para tratar as peças de forma hierárquica, permitindo que as peças normais e as
            damas sejam manipuladas de maneira uniforme.</li>
        <li><strong>Iterator</strong>: Para percorrer o tabuleiro e as peças de forma eficiente e modular.</li>
        <li><strong>Chain of Responsibility</strong>: Para encadear as verificações e ações durante o movimento das
            peças, como capturas e promoções.</li>
        <li><strong>Observer</strong>: Para notificar a interface gráfica sempre que o estado do jogo mudar (ex:
            movimento, captura, mudança de turno).</li>
        <li><strong>Template Method</strong>: Para definir o esqueleto de um turno, com a possibilidade de customizar as
            etapas, como movimentação e validação.</li>
    </ul>

    <h2 id="instalacao">Instalação</h2>
    <p>Para instalar e executar o projeto, siga os passos abaixo:</p>
    <ol>
        <li>Clone o repositório do projeto:
            <pre><code>git clone https://github.com/seu-usuario/jogo-de-damas.git</code></pre>
        </li>
        <li>Abra o projeto na sua IDE preferida (como IntelliJ IDEA, Eclipse ou NetBeans).</li>
        <li>Certifique-se de que o <strong>JDK</strong> esteja instalado e configurado corretamente.</li>
        <li>Compile o projeto para verificar se não há erros de sintaxe ou dependências ausentes.</li>
    </ol>

    <h2 id="executando">Executando o Projeto</h2>
    <p>Para executar o jogo, siga os passos abaixo:</p>
    <ol>
        <li>Após abrir o projeto na IDE, localize o arquivo <strong>Main.java</strong>.</li>
        <li>Clique com o botão direito e selecione "Executar" ou utilize o atalho apropriado para iniciar o jogo.</li>
        <li>A interface gráfica será aberta, e você poderá começar a jogar com outra pessoa localmente, alternando os
            turnos.</li>
    </ol>

    <a href="#inicio" id="scrollToTop">
        <img src="./public/assets/img/up-arrow.png" alt="seta apontada para cima">
    </a>

    <footer>
        <p>Projeto desenvolvido como parte da avaliação da disciplina de Padrões de Projeto Orientado à Objetos.</p>
        <p>Desenvolvedor: <strong><a href="https://github.com/Neto-Pereira25" target="_blank">José Neto</a> e <a href="https://github.com/luke-rocha3" target="_blank">Lucas Gabriel</a></strong></p>
    </footer>
</body>

</html>