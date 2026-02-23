import java.util.Random;

public class DiceGame extends Game {

    private int[] scores;
    private int roundsPlayed;
    private int maxRounds;
    private int numberOfPlayers;
    private Random random;

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        scores = new int[numberOfPlayers];
        this.roundsPlayed = 0;
        this.maxRounds = 5;
        this.random = new Random();

        System.out.println("Game initialized with " + numberOfPlayers + " players.");
        System.out.println("Game will play for " + maxRounds + " rounds.");
    }

    @Override
    public boolean endOfGame(){
        return roundsPlayed >= maxRounds;
    }

    @Override
    public void playSingleTurn(int player) {
        int diceRoll = random.nextInt(6) + 1; // Simulate rolling a 6-sided die
        scores[player] += diceRoll;
        System.out.println("Player " + player + " rolled a " + diceRoll + ". Total score: " + scores[player]);

        // Increase the round count after all players have taken their turn
        if (player == numberOfPlayers - 1) {
            roundsPlayed++;
            System.out.println("---- End of round " + roundsPlayed + " ----");
        }
    }

    @Override
    public void displayWinner() {
        int highestScore = -1;
        int winner = -1;

        for (int i = 0; i < numberOfPlayers; i++) {
            if (scores[i] > highestScore) {
                highestScore = scores[i];
                winner = i;
            }
        }

        System.out.println("Player " + winner + " wins with a score of " + highestScore + " points!");
    }
}


