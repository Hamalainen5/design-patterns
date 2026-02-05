import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class WeatherStation extends Thread {

    private final List<WeatherObserver> observers = new ArrayList<>();
    private final Random random = new Random();

    private int temperature;

    private static final int MIN_TEMP = -20;
    private static final int MAX_TEMP = 40;

    public WeatherStation() {
        // Initial random temperature
        this.temperature = random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP;
        System.out.println("Initial temperature: " + temperature + "C");
    }

    public synchronized void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public synchronized void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private synchronized void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    private void updateTemperature() {
        int change = random.nextBoolean() ? 1 : -1;
        temperature += change;

        if (temperature > MAX_TEMP) {
            temperature = MAX_TEMP;
        } else if (temperature < MIN_TEMP) {
            temperature = MIN_TEMP;
        }

        System.out.println("Updated temperature: " + temperature + "C");
        notifyObservers();
    }

    @Override
    public void run() {
        while (true) {
            updateTemperature();

            try {
                int sleepTime = 1000 + random.nextInt(4000); // 1–5 seconds
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
