public class NoviceState implements State {

    private static final int XP_REQUIRED = 100;

    @Override
    public void train(GameCharacter character) {
        character.addExperience(20);

        if (character.getExperiencePoints() >= XP_REQUIRED) {
            character.levelUp();
            character.setState(new IntermediateState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Meditate not available at Novice level.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Fight not available at Novice level.");
    }

    @Override
    public String getName() {
        return "Novice";
    }
}
