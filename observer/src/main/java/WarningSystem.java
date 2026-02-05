import java.util.Observer;

public class WarningSystem implements WeatherObserver {

    @Override
    public void update(int temperature) {
        if (temperature <= 0) {
            System.out.println("⚠️ Warning system: Frost alert! " + temperature + "°C");
        }
    }
}
