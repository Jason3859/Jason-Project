package dev.jason.cricket;

public class Main {
    public static void mainGame() throws Exception {
        Toss.toss();
        Toss.afterToss();
        Toss.declareTossWinner();

        if (GameConfig.playerWonToss) {
            System.out.println("You won the toss!");
            MainGame.playerTossChoice();

            switch (GameConfig.playerChoice) {
                case "bat":
                    while (!GameConfig.isPlayerOut)
                        MainGame.player();
                    break;

                case "ball":
                    while (!GameConfig.isComputerOut)
                        MainGame.computer();
                    break;
            }
        }

        if (GameConfig.computerWonToss) {
            System.out.println("Computer won the toss");
            MainGame.computerTossChoice();

            switch (GameConfig.computerChoice.toLowerCase()) {
                case "bat":
                    while (!GameConfig.isComputerOut)
                        MainGame.computer();
                    break;
                case "ball":
                    while (!GameConfig.isPlayerOut)
                        MainGame.player();
                    break;
            }
        }

        MainGame.gameSummary();
    }
}
