public class OkladException extends Exception {
    private double oklad;

    public OkladException(String message, double oklad) {
        super(message);
        this.oklad = oklad;
    }

    public double getOklad() {
        return oklad;
    }
}