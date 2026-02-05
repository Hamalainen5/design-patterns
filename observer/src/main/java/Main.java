public class Main {

    public static void main(String[] args) throws InterruptedException {
        WeatherStation weatherStation = new WeatherStation();

        WeatherObserver phone = new PhoneDisplay();
        WeatherObserver window = new WindowDisplay();
        WeatherObserver warning = new WarningSystem();

        weatherStation.registerObserver(phone);
        weatherStation.registerObserver(window);
        weatherStation.registerObserver(warning);

        weatherStation.start();

        // Let the simulation run for a while
        Thread.sleep(10000);

        System.out.println("\n=== Removing WindowDisplay observer ===\n");
        weatherStation.removeObserver(window);

        // Continue simulation
        Thread.sleep(10000);

        System.out.println("\nSimulation finished.");
        System.exit(0);


    }
}
