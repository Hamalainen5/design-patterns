public class ExpertState implements State {

    private static final int XP_REQUIRED = 500;

    @Override
    public void train(GameCharacter character) {
        character.addExperience(40);

        if (character.getExperiencePoints() >= XP_REQUIRED) {
            character.levelUp();
            character.setState(new MasterState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        character.addHealth(30);
    }

    @Override
    public void fight(GameCharacter character) {
        character.addExperience(60);
        character.loseHealth(25);

        if (character.getExperiencePoints() >= XP_REQUIRED) {
            character.levelUp();
            character.setState(new MasterState());
        }
    }

    @Override
    public String getName() {
        return "Expert";
    }
}
