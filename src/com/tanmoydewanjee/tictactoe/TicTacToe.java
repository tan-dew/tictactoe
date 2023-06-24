package com.tanmoydewanjee.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    public void startGame() {
        coinToss();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the 1st player:");
        Player playerOne = new Player();
        playerOne.setName(scanner.nextLine());
        playerOne.setSymbol(TicTacToeConstants.PLAYER_ONE_SYMBOL);

        System.out.println("Enter the name of the 2nd player:");
        Player playerTwo = new Player();
        playerTwo.setName(scanner.nextLine());
        playerTwo.setSymbol(TicTacToeConstants.PLAYER_TWO_SYMBOL);

        Board board = new Board();
        board.print();

        Player currentPlayer = playerOne;

        while (true) {
            if (board.isBoardFull()){
                System.out.println("Game over! It's a draw.");
                break;
            }

            System.out.println(currentPlayer.getName() + ":");
            if (!board.play(scanner.nextInt(), currentPlayer)){
                continue;
            }

            board.print();

            if (board.doesPlayerWin(currentPlayer)){
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            currentPlayer = currentPlayer == playerOne ? playerTwo : playerOne;
        }
    }

    private void coinToss(){
        System.out.println("Let's settle who goes first. Heads or tails?");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        int coin = (int) Math.round(Math.random());

        String side = coin == 0 ? "Heads" : "Tails";
        System.out.printf("%s it is! Player one goes first. Play accordingly.\n", side);
    }
}

