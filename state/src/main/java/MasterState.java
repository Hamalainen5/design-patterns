public class MasterState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println("You are already a Master.");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You are already a Master.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("You are already a Master.");
    }

    @Override
    public String getName() {
        return "Master";
    }
}
