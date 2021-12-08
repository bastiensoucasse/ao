package abstractFactory;

public class MacOSFactory extends GUIFactory {
    public Button createButton() {
        return (new MacOSButton());
    }
}
