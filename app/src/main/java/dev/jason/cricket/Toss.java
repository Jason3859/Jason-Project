package dev.jason.cricket;

import java.util.Objects;

public class Toss {
    static final GameConfig gameConfig = new GameConfig();

    static void toss() {
        System.out.print("Odd or Eve? Enter your choice: ");
        gameConfig.setPlayerTossChoice();
        gameConfig.setComputerTossChoice();
        System.out.println("Computer: " + GameConfig.computerTossChoice);
        System.out.println();
    }

    static void afterToss() throws Exception {
        System.out.print("Enter any number: ");
        try {
            gameConfig.setPlayerPostTossChoice();
            gameConfig.setComputerPostTossChoice();
            System.out.println("Computer: " + GameConfig.computerPostTossChoice);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


    static void declareTossWinner() {

        int tossTotal = GameConfig.playerPostTossChoice + GameConfig.computerPostTossChoice;

        if (tossTotal % 2 == 0 &&
            (
                Objects.equals(GameConfig.playerTossChoice, "eve") ||
                Objects.equals(GameConfig.computerTossChoice, "eve")
            )
        ) {
            GameConfig.playerWonToss = Objects.equals(GameConfig.playerTossChoice, "eve");
            GameConfig.computerWonToss = Objects.equals(GameConfig.computerTossChoice, "eve");
        }

        if (tossTotal % 2 != 0 &&
            (
                Objects.equals(GameConfig.playerTossChoice, "odd") ||
                Objects.equals(GameConfig.computerTossChoice, "odd")
            )
        ) {
            GameConfig.playerWonToss = Objects.equals(GameConfig.playerTossChoice, "odd");
            GameConfig.computerWonToss = Objects.equals(GameConfig.computerTossChoice, "odd");
        }
    }
}
