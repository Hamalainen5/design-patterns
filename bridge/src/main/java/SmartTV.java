public class SmartTV implements Device{


    @Override
    public void enable() {
        System.out.println("Smart TV is enabled");
    }
    @Override
    public void disable() {
        System.out.println("Smart TV is disabled");
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public int getChannel() {
        return 1;
    }
    @Override
    public void setChannel(int channel) {
        System.out.println("Smart TV channel set to " + channel);
    }
    @Override
    public int getVolume() {
        return 50;
    }
    @Override
    public void setVolume(int volume) {
        System.out.println("Smart TV volume set to " + volume);
    }
    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm a Smart TV.");
        System.out.println("| I'm " + (isEnabled() ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + getVolume() + "%");
        System.out.println("| Current channel is " + getChannel());
        System.out.println("------------------------------------\n");
    }

}
