// Abstract class untuk kendaraan umum
abstract class Vehicle {
    protected String brand;
    
    public Vehicle(String brand) {
        this.brand = brand;
    }
    
    public abstract void startEngine();
}

// Interface untuk kendaraan elektrik
interface Electric {
    void chargeBattery();
}

// Class mobil (mewarisi Vehicle dan implement Electric)
class Car extends Vehicle implements Electric {
    private int batteryLevel;  // Atribut spesifik Car
    
    public Car(String brand) {
        super(brand);
        this.batteryLevel = 0;
    }
    
    @Override
    public void startEngine() {
        System.out.println(brand + " car: Silent electric motor activated ⚡");
    }
    
    @Override
    public void chargeBattery() {
        batteryLevel = 100;
        System.out.println(brand + " car: Battery charged to " + batteryLevel + "% 🔋");
    }
    
    // Getter untuk batteryLevel
    public int getBatteryLevel() {
        return batteryLevel;
    }
}

// Class motor (mewarisi Vehicle)
class Motorcycle extends Vehicle {
    public Motorcycle(String brand) {
        super(brand);
    }
    
    @Override
    public void startEngine() {
        System.out.println(brand + " motorcycle: VROOOOM! 🏍️");
    }
}

// Class utama
public class MainApp {
    public static void main(String[] args) {
        // Polymorphism: Array bertipe Vehicle tapi berisi subclass
        Vehicle[] vehicles = {
            new Car("Tesla"),
            new Motorcycle("Harley-Davidson")
        };
        
        // Iterasi melalui semua kendaraan
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();  // Polymorphic call
            
            // Cek apakah kendaraan elektrik
            if (vehicle instanceof Electric) {
                Electric ev = (Electric) vehicle;
                ev.chargeBattery();
                
                // Contoh akses batteryLevel (opsional)
                System.out.println("Current battery: " + 
                    ((Car)vehicle).getBatteryLevel() + "%\n");
            }
        }
    }
}