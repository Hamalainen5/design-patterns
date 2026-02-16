public class IntermediateState implements State {

    private static final int XP_REQUIRED = 250;

    @Override
    public void train(GameCharacter character) {
        character.addExperience(30);

        if (character.getExperiencePoints() >= XP_REQUIRED) {
            character.levelUp();
            character.setState(new ExpertState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        character.addHealth(20);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Fight not available at Intermediate level.");
    }

    @Override
    public String getName() {
        return "Intermediate";
    }
}
