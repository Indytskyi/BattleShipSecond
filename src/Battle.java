import java.io.IOException;

public class Battle {

    private GameShips gameShips = new GameShips();

    private PlayingField player1 = new PlayingField("Player 1");
    private PlayingField player2 = new PlayingField("Player 2");

    public void initializationOfShips() {
        gameShips.initializationOfShip(player1);
        moveToAnotherPlayer();
        gameShips.initializationOfShip(player2);
    }

    public void fight(PlayingField playingFieldYour, PlayingField playingFieldOpponent) {
        while (playingFieldOpponent.getCountOfLiveShips() != 0) {
            playingFieldOpponent.printBattlefieldFog();
            System.out.println("---------------------");
            playingFieldYour.printBattlefield();


        }

        System.out.println(playingFieldYour.getNameOfPlayer() + ", win!");
    }

    private void moveToAnotherPlayer() {
        System.out.println("\nPress Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
