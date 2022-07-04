
import java.util.Scanner;

public class GameShips {

    private final Scanner scanner = new Scanner(System.in);

    public void initializationOfShip(PlayingField playingField) {
        System.out.println(playingField.getNameOfPlayer() + ", place your ships on the game field");
        playingField.createBattlefield();
        playingField.printBattlefield();

        while (playingField.getCurrentShip() != Ships.values().length) {
            System.out.printf("\nEnter the coordinates of the %s (%d cells):\n",
                    playingField.getShip().getTypeOfShip(), playingField.getShip().getSize());
            while (true) {
                try {
                    String startShipPosition = scanner.next();
                    String finishShipPosition = scanner.next();
                    playingField.getShip().setShipCoordinates(startShipPosition, finishShipPosition);
                    if (!ValidationOfField.CheckPlaceOfShip(playingField, startShipPosition, finishShipPosition)) {
                        continue;
                    }


                    playingField.placeShipOnBattlefield();
                    playingField.printBattlefield();
                    break;
                } catch (Exception e) {
                    System.out.println("Error! Wrong ship location! Try again:");
                }

            }
        }
    }


    public void startGame(PlayingField playingField) {
            String shot = scanner.next();
            boolean validate = playingField.getAttack().setCoordinates(shot);
            if (!playingField.getAttack().validateShot() || !validate) {
                System.out.println("\nError! You entered the wrong coordinates! Try again:\n");
                startGame(playingField); // ??????????? -----------------------------------
            }

            playingField.setHitOfAttack();

            if (playingField.getCountOfLiveShips() != 0) {
                if (playingField.getAttack().isHitShip()) {
                    if (!playingField.getAttack().isDeadShip()) {
                        System.out.println("You hit a ship!\n");
                    } else {
                        System.out.println("You sank a ship!\n");
                    }
                    playingField.getAttack().setDeadShip(false);
                } else {
                    System.out.println("You missed!\n");
                }
            }


    }


}
