import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Device> devices = new HashMap<>();

        devices.put("SN001", new Smartphone("Samsung", "Galaxy S23", 999.99, "Android", 256));
        devices.put("SN002", new Laptop("Apple", "MacBook Pro", 1999.99, "M2 Pro", 16));
        devices.put("SN003", new Smartphone("Apple", "iPhone 15", 1199.99, "iOS", 128));
        devices.put("SN004", new Laptop("Dell", "XPS 13", 1299.99, "Intel i7", 32));
        devices.put("SN005", new Device("Generic", "Tablet", 299.99));

        System.out.println("Все серийные номера (ключи):");
        for (String serialNumber : devices.keySet()) {
            System.out.println(serialNumber);
        }

        System.out.println("\nПодробная информация об устройствах:");
        for (Device device : devices.values()) {
            System.out.println("Устройство: " + device);
        }

    }
}