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
}
