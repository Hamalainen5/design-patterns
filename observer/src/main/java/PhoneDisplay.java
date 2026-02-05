public class PhoneDisplay implements WeatherObserver {

    @Override
    public void update(int temperature) {
        System.out.println("📱 Phone display: Current temperature is " + temperature + "°C");
    }
}
