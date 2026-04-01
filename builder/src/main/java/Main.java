public class Main {

    public static void main(String[] args) {
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        Director director = new Director(gamingBuilder);
        director.constructComputer();
        Computer gamingComputer = gamingBuilder.getComputer();
        System.out.println("Gaming Computer:");
        System.out.println(gamingComputer);

        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director = new Director(officeBuilder);
        director.constructComputer();
        Computer officeComputer = officeBuilder.getComputer();
        System.out.println("Office Computer:");
        System.out.println(officeComputer);
    }
}
