
package Proxies;

import Aspects.ToLog;
import Model.Car;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * The UsedCarSellProxy is a proxy class that allows for selling used cars
 * 
 * @author Billy Stanton
 * @since 1/3/2024
 */
@Component // Add bean to Spring Context as 'component'
@Qualifier("USED") // Helps Spring developers identify which proxy 
                   // they would like to choose when adding this class as a bean to context
public class UsedCarSellProxy implements CarSellProxy {
    // Instantiate logger object which logs with the class name
    private Logger logger = Logger.getLogger(UsedCarSellProxy.class.getName());
    
    @Override // Implement method from interface
    @ToLog // Method utilizes Aspect
    /**
     * The sell method sells a car
     */
    public Boolean sell(Car car) {
        System.out.printf("----------\nUsed Car Sold:\nBrand: %s\nModel: %s\nYear: %s\n----------\n", car.getBrand(), car.getModel(), car.getYear());
        
        logger.info("Success: Used Car Sold");
        
        return true;
    }
    
}
