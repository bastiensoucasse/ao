package abstractFactory;

public class MacOSButton extends Button {
    public void draw() {
        System.out.println("I'm a MacOSButton: " + getCaption());
    }
}
