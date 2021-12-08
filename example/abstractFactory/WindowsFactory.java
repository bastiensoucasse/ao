package abstractFactory;

public class WindowsFactory extends GUIFactory {
    public Button createButton() {
        return (new WindowsButton());
    }
}
