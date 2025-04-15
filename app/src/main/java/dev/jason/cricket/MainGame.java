package dev.jason.cricket;

import dev.jason.exception.InputOutOfRangeException;

public class MainGame {
    private static final GameConfig gameConfig = new GameConfig();
    private static final MainGame mainGame = new MainGame();

    static void playerTossChoice() {
        System.out.print("Bat or Ball: ");
        gameConfig.setPlayerChoice();
        gameConfig.setComputerChoice();
    }

    static void computerTossChoice() {
        gameConfig.setComputerChoice();
        System.out.println("Computer choice to " + GameConfig.computerChoice);
        System.out.println();
    }

    public static void player() throws Exception {
        mainGame.askInputsForGame();

        if (GameConfig.playerInput != GameConfig.computerInput) {
            GameConfig.isPlayerOut = false;
            GameConfig.playerScore += GameConfig.playerInput;
            System.out.println("Your score: " + GameConfig.playerScore);
            System.out.println();
        } else {
            GameConfig.isPlayerOut = true;
            if (GameConfig.isComputerOut)
                System.out.println("You are out!");
            else
                System.out.println("You are out! It's computer's chance to bat.");

            while (!GameConfig.isComputerOut)
                computer();
        }

    }

    public static void computer() throws Exception {
        mainGame.askInputsForGame();

        if (GameConfig.computerInput != GameConfig.playerInput) {
            GameConfig.isComputerOut = false;
            GameConfig.computerScore += GameConfig.computerInput;
            System.out.println("Computer score: " + GameConfig.computerScore);
            System.out.println();
        } else {
            GameConfig.isComputerOut = true;
            if (GameConfig.isPlayerOut)
                System.out.println("Computer is out!");
            else
                System.out.println("Computer is out! It's your chance to bat.");

            while (!GameConfig.isPlayerOut)
                player();
        }

    }

    public static void gameSummary() {
        System.out.println();

        if (GameConfig.playerScore > GameConfig.computerScore) {
            System.out.println("You won the game!");
            System.out.println("Your score: " + GameConfig.playerScore);
            System.out.println("Computer score: " + GameConfig.computerScore);
        }

        if (GameConfig.computerScore > GameConfig.playerScore) {
            System.out.println("Computer won the game!");
            System.out.println("Your score: " + GameConfig.playerScore);
            System.out.println("Computer score: " + GameConfig.computerScore);
        }

        if (GameConfig.playerScore == GameConfig.computerScore) {
            System.out.println("It's a tie!");
            System.out.println("Your score: " + GameConfig.playerScore);
            System.out.println("Computer score: " + GameConfig.computerScore);
        }
    }

    private void askInputsForGame() throws InputOutOfRangeException {
        System.out.print("Enter any number: ");
        try {
            gameConfig.askPlayerForInput();
            gameConfig.setComputerInput();
            System.out.println("You: " + GameConfig.playerInput);
            System.out.println("Computer: " + GameConfig.computerInput);
        } catch (InputOutOfRangeException e) {
            throw new InputOutOfRangeException(e.getMessage());
        }
    }
}