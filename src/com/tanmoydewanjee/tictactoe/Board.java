package com.tanmoydewanjee.tictactoe;

public class Board {
    private static final String board = """
            %s | %s | %s
            ----------
            %s | %s | %s
            ----------
            %s | %s | %s
            """;

    private int inputCount;

    private final String[] boardValues;

    public Board() {
        boardValues = new String[9];
        for (int i = 0; i < boardValues.length; i++) {
            boardValues[i] = String.valueOf(i + 1);
        }
    }

    public boolean play(int box, Player currentPlayer) {
        if (box <= 0 || box > boardValues.length) {
            System.out.println("Don't go outside the board!");
            return false;
        }

        int currentBox = box - 1;

        if (boardValues[currentBox].equals(TicTacToeConstants.PLAYER_ONE_SYMBOL) || boardValues[currentBox].equals(TicTacToeConstants.PLAYER_TWO_SYMBOL)) {
            System.out.println("Cannot override a box!");
            return false;
        }

        boardValues[currentBox] = currentPlayer.getSymbol();
        increaseInputCount();
        return true;
    }

    private void increaseInputCount() {
        inputCount++;
    }

    public void print() {
        System.out.printf((board) + "%n",
                boardValues[0], boardValues[1], boardValues[2],
                boardValues[3], boardValues[4], boardValues[5],
                boardValues[6], boardValues[7], boardValues[8]);
    }

    public boolean isBoardFull() {
        return inputCount == 9;
    }

    public boolean doesPlayerWin(Player player){
        String symbol = player.getSymbol();

        if (boardValues[0].equals(symbol) && boardValues[1].equals(symbol) && boardValues[2].equals(symbol)){
            return true;
        }

        if (boardValues[3].equals(symbol) && boardValues[4].equals(symbol) && boardValues[5].equals(symbol)){
            return true;
        }

        if (boardValues[6].equals(symbol) && boardValues[7].equals(symbol) && boardValues[8].equals(symbol)){
            return true;
        }

        if (boardValues[0].equals(symbol) && boardValues[3].equals(symbol) && boardValues[6].equals(symbol)){
            return true;
        }

        if (boardValues[1].equals(symbol) && boardValues[4].equals(symbol) && boardValues[7].equals(symbol)){
            return true;
        }

        if (boardValues[2].equals(symbol) && boardValues[5].equals(symbol) && boardValues[8].equals(symbol)){
            return true;
        }

        if (boardValues[0].equals(symbol) && boardValues[4].equals(symbol) && boardValues[8].equals(symbol)){
            return true;
        }

        if (boardValues[2].equals(symbol) && boardValues[4].equals(symbol) && boardValues[6].equals(symbol)){
            return true;
        }

        return false;
    }
}
