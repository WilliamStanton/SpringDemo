package Proxies;

import Aspects.ToLog;
import Model.Car;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * The NewCarSellProxy is a proxy class that allows for selling new cars
 * 
 * @author Billy Stanton
 * @since 1/3/2024
 */
@Component // Add bean to Spring Context as 'component'
@Qualifier("NEW") // Helps Spring developers identify which proxy 
                  // they would like to choose when adding this class as a bean to context
public class NewCarSellProxy implements CarSellProxy {
    // Instantiate logger object which logs with the class name
    private Logger logger = Logger.getLogger(NewCarSellProxy.class.getName());

    @Override // Implement method from interface
    @ToLog // Method utilizes Aspect
    /**
     * The sell method sells a car
     */
    public Boolean sell(Car car) {
        System.out.printf("----------\nNew Car Sold:\nBrand: %s\nModel: %s\nYear: %s\n----------\n", car.getBrand(), car.getModel(), car.getYear());
    
        logger.info("Success: New Car Sold");
        
        return true;
    }
}
