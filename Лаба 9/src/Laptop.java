public class Laptop extends Device {
    private String processor;
    private int ramGB;

    public Laptop(String brand, String model, double price, String processor, int ramGB) {
        super(brand, model, price);
        this.processor = processor;
        this.ramGB = ramGB;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRamGB() {
        return ramGB;
    }

    @Override
    public String toString() {
        return String.format("Laptop{brand='%s', model='%s', price=%.2f, processor='%s', RAM=%dGB}",
                getBrand(), getModel(), getPrice(), processor, ramGB);
    }
}