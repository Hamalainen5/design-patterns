public interface ComputerBuilder {
    void addProcessor();
    void addRam();
    void addHardDrive();
    void addGraphicsCard();
    void addOperatingSystem();
    Computer getComputer();
}
