public class WindowDisplay implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("🪟 Window display: It's now " + temperature + "°C outside");
    }
}
