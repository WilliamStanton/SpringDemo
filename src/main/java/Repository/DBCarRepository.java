package Repository;

import Aspects.ToLog;
import Model.Car;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * The DBCarRepository class is a repository class that stores information for data persistence
 * 
 * @author Billy Stanton
 * @since 1/3/2024
 */
@Repository  // Add bean to Spring Context as 'repository'
@Qualifier("DB") // Helps Spring developers identify which repository 
                 // they would like to choose when adding this class as a bean to context
public class DBCarRepository implements CarRepository {
    // Instantiate logger object which logs with the class name
    private Logger logger = Logger.getLogger(DBCarRepository.class.getName());
    
    /**
     * The storeTransaction stores car transactions to the database for persistence (proof of concept)
     */
    @Override // Implement method from interface
    @ToLog // Method utilizes Aspect
    public void storeTransaction(Car car) {
        logger.info("Transaction Saved to DB");
    }
}
