package abstractFactory;

public abstract class GUIFactory {
    public static GUIFactory getFactory() {
        int sys = -1;
        // Comment to prevent any error from VS Code
        // sys = readFromConfigFile("OS_TYPE");
        if (sys == 0)
            return (new WindowsFactory());
        return (new MacOSFactory());
    }

    public abstract Button createButton();
}
