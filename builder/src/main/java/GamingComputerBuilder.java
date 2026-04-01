public class GamingComputerBuilder implements ComputerBuilder{

    private Computer computer;
    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void addProcessor(){
        computer.addComponent(new Component("High-end Processor"));
    }
    @Override
    public void addRam() {
        computer.addComponent(new Component("16GB RAM"));
    }
    @Override
    public void addHardDrive() {
        computer.addComponent(new Component("1TB SSD"));
    }
    @Override
    public void addGraphicsCard() {
        computer.addComponent(new Component("High-end Graphics Card"));
    }
    @Override
    public void addOperatingSystem() {
        computer.addComponent(new Component("Windows 10"));
    }

    public Computer getComputer() {
        return computer;
    }
}
