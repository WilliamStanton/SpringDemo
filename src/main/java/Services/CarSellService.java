package Services;

import Model.Car;
import Proxies.CarSellProxy;
import Repository.CarRepository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * The CarSellService class is a service class that utilizes the proxies and repositories to provide
 * functional methods to the main class
 * 
 * @author Billy Stanton
 * @since 1/3/2024
 */
@Service // Add bean to Spring Context as 'service'
public class CarSellService {

    // Autowired fields
    private final CarSellProxy usedCar;
    private final CarSellProxy newCar;
    private final CarRepository carRepository;
    
    /**
     * Autowire beans via Constructor
     * 
     * @param usedCarSellProxy wires the (used) CarSellProxy bean
     * @param newCarSellProxy wires the (new) CarSellProxy bean
     * @param carRepository wires the (db) CarRepository bean
     */
    public CarSellService(@Qualifier("USED")CarSellProxy usedCarSellProxy,
                          @Qualifier("NEW")CarSellProxy newCarSellProxy,
                          @Qualifier("DB")CarRepository carRepository) {
        this.usedCar = usedCarSellProxy;
        this.newCar = newCarSellProxy;
        this.carRepository = carRepository;
    }
    
    /**
     * The sellCar method instructs the service to sell the car
     * by calling either the usedCar or newCar proxy, and then reporting the sale to the repository
     * 
     * @param car the car object
     */
    public void sellCar(Car car) {
        // Used Car
        if (car.getCondition().equals("USED")) {
            usedCar.sell(car);
            carRepository.storeTransaction(car);
        } 
        // New Car
        else {
            newCar.sell(car);
            carRepository.storeTransaction(car);
        }
    }
}
