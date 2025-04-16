package dev.jason.cricket;

import dev.jason.exception.InputOutOfRangeException;

public class MainGame {
    private static final GameConfig gameConfig = new GameConfig();
    private static final MainGame mainGame = new MainGame();

    public static void mainGame() throws Exception {
        Toss.toss();
        Toss.afterToss();
        Toss.declareTossWinner();

        if (GameConfig.playerWonToss) {
            System.out.println("You won the toss!");
            MainGame.playerTossChoice();

            switch (GameConfig.playerChoice) {
                case "bat":
                    MainGame.playerBatting();
                    break;

                case "ball":
                    MainGame.computerBatting();
                    break;
            }
        }

        if (GameConfig.computerWonToss) {
            System.out.println("Computer won the toss");
            MainGame.computerTossChoice();

            switch (GameConfig.computerChoice.toLowerCase()) {
                case "bat":
                    MainGame.computerBatting();
                    break;

                case "ball":
                    MainGame.playerBatting();
                    break;
            }
        }

        MainGame.gameSummary();
    }

    static void playerTossChoice() {
        System.out.print("Bat or Ball: ");
        gameConfig.setPlayerChoice();
        gameConfig.setComputerChoice();
        System.out.println();
        System.out.println("Okay! You " + GameConfig.playerChoice + " first");
    }

    static void computerTossChoice() {
        gameConfig.setComputerChoice();
        System.out.println();
        System.out.println("Computer choice to " + GameConfig.computerChoice);
    }

    public static void player() throws Exception {
        System.out.println("Over: " + GameConfig.overs);
        System.out.println("Ball: " + GameConfig.balls);
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

            System.out.println("Your score: " + GameConfig.playerScore);
            System.out.println();

            GameConfig.balls = 0;
            GameConfig.overs = 0;

            computerBatting();
        }

    }

    public static void computerBatting() throws Exception {
        while (!GameConfig.isComputerOut || GameConfig.overs == GameConfig.totalOvers) {
            GameConfig.balls++;
            MainGame.computer();
            if (GameConfig.balls == 6) {
                GameConfig.overs += 1;
                gameConfig.resetBalls();
            }

            if (GameConfig.isPlayerOut) {
                if (GameConfig.computerScore > GameConfig.playerScore) {
                    break;
                }
            }
        }
    }

    public static void computer() throws Exception {
        System.out.println("Over: " + GameConfig.overs);
        System.out.println("Ball: " + GameConfig.balls);
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

            System.out.println("Computer score: " + GameConfig.computerScore);
            System.out.println();

            GameConfig.balls = 0;
            GameConfig.overs = 0;
            playerBatting();
        }

    }

    public static void playerBatting() throws Exception {
        while (!GameConfig.isPlayerOut || GameConfig.overs == GameConfig.totalOvers) {
            GameConfig.balls++;
            MainGame.player();
            if (GameConfig.balls == 6) {
                GameConfig.overs += 1;
                gameConfig.resetBalls();
            }

            if (GameConfig.isComputerOut) {
                if (GameConfig.playerScore > GameConfig.computerScore) {
                    break;
                }
            }
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