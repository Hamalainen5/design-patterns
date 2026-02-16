public class GameCharacter {

    private String name;
    private int level;
    private int experiencePoints;
    private int healthPoints;

    private State currentState;

    public GameCharacter(String name) {
        this.name = name;
        this.level = 1;
        this.experiencePoints = 0;
        this.healthPoints = 100;
        this.currentState = new NoviceState();
    }

    public void setState(State state) {
        this.currentState = state;
        System.out.println(">>> State changed to: " + state.getName());
    }

    public State getState() {
        return currentState;
    }

    public void train() {
        currentState.train(this);
    }

    public void meditate() {
        currentState.meditate(this);
    }

    public void fight() {
        currentState.fight(this);
    }

    public void addExperience(int amount) {
        experiencePoints += amount;
        System.out.println(name + " gained " + amount + " XP.");
    }

    public void addHealth(int amount) {
        healthPoints += amount;
        System.out.println(name + " gained " + amount + " HP.");
    }

    public void loseHealth(int amount) {
        healthPoints -= amount;
        if (healthPoints < 0) healthPoints = 0;
        System.out.println(name + " lost " + amount + " HP.");
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void levelUp() {
        level++;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public void displayStatus() {
        System.out.println("\n===== CHARACTER STATUS =====");
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("State: " + currentState.getName());
        System.out.println("XP: " + experiencePoints);
        System.out.println("HP: " + healthPoints);
        System.out.println("============================");
    }
}
