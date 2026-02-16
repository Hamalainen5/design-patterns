import java.util.Scanner;

public class Game {

    private GameCharacter character;
    private Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
    }

    public void start() {

        System.out.print("Enter character name: ");
        String name = scanner.nextLine();

        character = new GameCharacter(name);

        gameLoop();

        scanner.close();
    }

    private void gameLoop() {

        while (!(character.getState() instanceof MasterState)) {

            character.displayStatus();
            showMenu();

            int choice = getChoice();

            handleChoice(choice);
        }

        character.displayStatus();
        System.out.println("\nCONGRATULATIONS! You reached MASTER level!");
    }

    private void showMenu() {

        System.out.println("\nChoose action:");
        System.out.println("1 - Train");
        System.out.println("2 - Meditate");
        System.out.println("3 - Fight");
        System.out.println("4 - Exit");
    }

    private int getChoice() {

        System.out.print("> ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input.");
            scanner.next();
        }

        return scanner.nextInt();
    }

    private void handleChoice(int choice) {

        switch (choice) {

            case 1:
                character.train();
                break;

            case 2:
                character.meditate();
                break;

            case 3:
                character.fight();
                break;

            case 4:
                System.out.println("Game exited.");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }
}
