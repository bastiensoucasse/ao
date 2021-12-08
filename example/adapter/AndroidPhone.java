package adapter;

class AndroidPhone implements USBPhone {
    private boolean connector;

    @Override
    public void useUSB() {
        connector = true;
        System.out.println("USB connected");
    }

    @Override
    public void charge() {
        if (connector) {
            System.out.println("Recharge started");
            System.out.println("Recharge finished");
        } else {
            System.out.println("Connect USB first");
        }
    }
}
