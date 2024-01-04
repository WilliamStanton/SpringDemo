package Main;

import Config.ProjectConfig;
import Model.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import Services.CarSellService;

/**
 * Spring Demonstration featuring concepts:
 * 
 * Inversion of Control (Application Executes being controlled by Framework), 
 * Spring Context & Beans (Related to IOC),
 * Aspect Oriented Programming (Proxy methods, Weaving, Method interruption & altering), 
 * Stereotype Annotations & Annotations (Providing additional info to JVM)
 * 
 * @author Billy Stanton
 * @since 1/3/2024
 */
public class Main {

    public static void main(String[] args) {
       // Initialize Spring Context IOC
       var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
       
       // Add Service Bean to Spring Context
       var service = context.getBean(CarSellService.class);
       
       // Instantiate car object to be utilized by the service bean
       Car usedCar = new Car("Mercedes", "G-Wagon", "new", 2024);
//       Car newCar = new Car("Jeep", "Wrangler", "used", 1996);
       
       // Utilize service bean to sell the car object
       service.sellCar(usedCar);
//       service.sellCar(newCar);
    }
}
