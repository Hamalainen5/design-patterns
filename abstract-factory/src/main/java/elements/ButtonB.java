package elements;// Style B implementation of elements.Button

public class ButtonB extends Button {

    public ButtonB(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("##############");
        System.out.println("#  " + text + "  #");
        System.out.println("##############");
    }
}
