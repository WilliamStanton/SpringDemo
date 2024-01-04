package Model;

/**
 * The Car class provides a model object that is NOT part of the Spring Context
 * that is STILL USED by the Spring Context
 * 
 * @author Billy Stanton
 * @since 1/3/2024
 */
public class Car {
    // Declare Fields
    private String brand;
    private String model;
    private String condition;
    private int year;

    // Parameterized Constructor
    public Car(String brand, String model, String condition, int year) {
        this.brand = brand;
        this.model = model;
        this.condition = condition.toUpperCase();
        this.year = year;
    }

    // No-arg Constructor
    public Car() {
        this.brand = "";
        this.model = "";
        this.condition = "";
        this.year = 0;
    }
    
    /**
     * Getters and Setters
     */
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition.toUpperCase();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    /**
     * Returns all fields of the car object
     */
    public String toString() {
        return "Car{" + "brand=" + brand + ", model=" + model + ", year=" + year + '}';
    }
}
