public class OfficeComputerBuilder implements ComputerBuilder{

    private Computer computer;
    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void addProcessor(){
        computer.addComponent(new Component("Mid-range Processor"));
    }
    @Override
    public void addRam() {
        computer.addComponent(new Component("8GB RAM"));
    }
    @Override
    public void addHardDrive() {
        computer.addComponent(new Component("512GB SSD"));
    }
    @Override
    public void addGraphicsCard() {
        computer.addComponent(new Component("Integrated Graphics Card"));
    }
    @Override
    public void addOperatingSystem() {
        computer.addComponent(new Component("Windows 10 Pro"));
    }

    public Computer getComputer() {
        return computer;
    }
}
