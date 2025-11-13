public class Smartphone extends Device {
    private String operatingSystem;
    private int storageGB;

    public Smartphone(String brand, String model, double price, String operatingSystem, int storageGB) {
        super(brand, model, price);
        this.operatingSystem = operatingSystem;
        this.storageGB = storageGB;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public int getStorageGB() {
        return storageGB;
    }

    @Override
    public String toString() {
        return String.format("Smartphone{brand='%s', model='%s', price=%.2f, OS='%s', storage=%dGB}",
                getBrand(), getModel(), getPrice(), operatingSystem, storageGB);
    }
}