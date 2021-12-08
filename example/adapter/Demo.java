package adapter;

public class Demo {
    static void rechargeUSBPhone(final USBPhone phone) {
        phone.useUSB();
        phone.charge();
    }

    static void rechargeLightningPhone(final LightningPhone phone) {
        phone.useLightning();
        phone.charge();
    }

    public static void main(final String[] args) {
        final AndroidPhone android = new AndroidPhone();
        final IPhone iPhone = new IPhone();

        System.out.println("Charging Android phone with USB");
        rechargeUSBPhone(android);

        System.out.println("Charging iPhone with Lightning");
        rechargeLightningPhone(iPhone);

        System.out.println("Charging iPhone with USB");
        rechargeUSBPhone(new USBToLightningAdapter(iPhone));
    }
}
