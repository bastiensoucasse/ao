package abstractFactory;

public class WindowsButton extends Button {
    public void draw() {
        System.out.println("I'm a WindowsButton: " + getCaption());
    }
}
