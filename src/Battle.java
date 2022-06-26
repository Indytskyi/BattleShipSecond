import java.io.IOException;

public class Battle {

    private GameShips gameShips = new GameShips();

    private boolean changePlayers = true;

    private PlayingField player1 = new PlayingField("Player 1");
    private PlayingField player2 = new PlayingField("Player 2");

    public void initializationOfShips() {
        gameShips.initializationOfShip(player1);
        System.out.println("\nPress Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        gameShips.initializationOfShip(player2);
        fight(player1, player2);
    }

    public void fight(PlayingField playingFieldYour, PlayingField playingFieldOpponent) {
        while (playingFieldOpponent.getCountOfLiveShips() != 0) {
            playingFieldOpponent.printBattlefieldFog();
            System.out.print("---------------------");
            playingFieldYour.printBattlefield();
            System.out.println("\n" + playingFieldYour.getNameOfPlayer() + ", it's your turn:");
            gameShips.startGame(playingFieldOpponent);
            if (playingFieldOpponent.getCountOfLiveShips() == 0) {
                break;
            }
            moveToAnotherPlayer();

        }

        System.out.println(playingFieldYour.getNameOfPlayer() + ", win!");
        System.exit(0);
    }

    private void moveToAnotherPlayer() {
        System.out.println("\nPress Enter and pass the move to another player");
        try {
            System.in.read();
            if (changePlayers) {
                changePlayers = false;
                fight(player2, player1);

            } else {
                changePlayers = true;
                fight(player1, player2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
