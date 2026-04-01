public class Director {

    private ComputerBuilder builder;

    public Director(ComputerBuilder builder) {
        this.builder = builder;
    }

    public void constructComputer() {
        builder.addProcessor();
        builder.addRam();
        builder.addHardDrive();
        builder.addGraphicsCard();
        builder.addOperatingSystem();
    }
}
