package adapter;

class USBToLightningAdapter implements USBPhone {
    private final LightningPhone lightningPhone;

    public USBToLightningAdapter(final LightningPhone lightningPhone) {
        this.lightningPhone = lightningPhone;
    }

    @Override
    public void useUSB() {
        System.out.println("USB connected");
        lightningPhone.useLightning();
    }

    @Override
    public void charge() {
        lightningPhone.charge();
    }
}
