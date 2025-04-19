package dev.jason.cricket;

import dev.jason.exception.InputOutOfRangeException;

import java.util.Scanner;

public class GameConfig {
    private final Random random = new Random();
    private final Scanner sc = new Scanner(System.in);

    static String computerTossChoice;
    static int computerPostTossChoice;
    static String playerTossChoice;
    static int playerPostTossChoice;
    static boolean playerWonToss;
    static boolean computerWonToss;
    static String playerChoice;
    static String computerChoice;
    static int playerInput;
    static int computerInput;
    static boolean isPlayerOut;
    static boolean isComputerOut;
    public static int playerScore = 0;
    public static int computerScore = 0;
    public static int overs = 0;
    public static int balls = 0;
    public static int totalOvers = 5;

    void setComputerTossChoice() {
        computerTossChoice =
            playerTossChoice.equals("odd") ? "eve" :
            playerTossChoice.equals("eve") ? "odd" : "";
    }
    void setPlayerTossChoice() {
        String temp = sc.next();
        if (temp.equals("odd") || temp.equals("eve")) {
            playerTossChoice = temp;
        }
    }
    void setPlayerPostTossChoice() throws InputOutOfRangeException {
        int temp = sc.nextInt();
        if (temp <= 5) {
            playerPostTossChoice = temp;
        } else {
            throw new InputOutOfRangeException("Input must be less than or equal to 5");
        }
    }
    void askPlayerForInput() throws InputOutOfRangeException {
        int temp = sc.nextInt();
        if (temp < 6) {
            playerInput = temp;
        } else {
            throw new InputOutOfRangeException("Input must be less than or equal to 5");
        }
    }
    void resetBalls() {
        balls = 0;
    }
    void setComputerPostTossChoice() {
        computerPostTossChoice = random.randomInt();
    }
    void setComputerInput() {
        computerInput = random.randomInt();
    }
    void setPlayerChoice() {
        playerChoice = sc.next();
    }
    void setComputerChoice() {
        computerChoice = random.computerChoice();
    }
}