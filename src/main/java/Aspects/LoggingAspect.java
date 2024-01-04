package Aspects;

import java.util.Arrays;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * The LoggingAspect class is an aspect that intercepts methods and provides
 * information that may useful to the developer
 * 
 * @author Billy Stanton
 * @since 1/3/2024
 */
@Component // Add bean to Spring Context as 'component'
@Aspect // Instruct IOC that this is an 'aspect' component
public class LoggingAspect {
    
    // Instantiate logger object which logs with the class name
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    
    /**
     * The log method intercepts affected methods and provides a log to the developer with information
     * that may be useful to them and not otherwise available
     * 
     * @param joinPoint represents the intercepted method and can be utilized to obtain the method name,
     * params, target obj, results, and more. It can also change the parameters the method will execute with
     * 
     * @throws Throwable throws all exceptions from the interrupted method
     */
    @Around("@annotation(ToLog)")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
         logger.info("Method \"" + joinPoint.getSignature().getName() + "\" will now execute");
         Object result = joinPoint.proceed();
         Object[] args = joinPoint.getArgs();
         logger.info("Method \"" + joinPoint.getSignature().getName() + "\" returned " + result + ", and executed with args: " + Arrays.toString(args));
    }
}
