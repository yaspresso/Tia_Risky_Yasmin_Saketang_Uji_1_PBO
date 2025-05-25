// [1] Abstract Class Product
abstract class Product {
    protected String name;
    protected double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    // Abstract method untuk hitung total (termasuk pajak jika ada)
    public abstract double calculateTotal();
}

// [2] Interface Taxable
interface Taxable {
    double TAX_RATE = 0.11;  // Pajak 11%
    double calculateTax();
}

// [3] Subclass Food (kena pajak)
class Food extends Product implements Taxable {
    public Food(String name, double price) {
        super(name, price);
    }
    
    @Override
    public double calculateTax() {
        return price * TAX_RATE;
    }
    
    @Override
    public double calculateTotal() {
        return price + calculateTax();
    }
}

// [4] Subclass Beverage (tidak kena pajak)
class Beverage extends Product {
    public Beverage(String name, double price) {
        super(name, price);
    }
    
    @Override
    public double calculateTotal() {
        return price;  // Beverage bebas pajak
    }
}

// [5] Main App
public class CashierApp {
    public static void main(String[] args) {
        Product[] cart = {
            new Food("Burger", 5.0),
            new Beverage("Coffee", 3.0),
            new Food("Pizza", 10.0)
        };
        
        // Hitung total belanja (dengan polymorphism)
        double total = 0;
        for (Product product : cart) {
            total += product.calculateTotal();
            System.out.println(product.name + ": $" + product.calculateTotal());
        }
        
        System.out.println("------------------");
        System.out.println("TOTAL: $" + total);
    }
}
