package Aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom Aspect Annotation (toLog)
 */
@Retention(RetentionPolicy.RUNTIME) // Allows the custom annotation to intercept at runtime
@Target(ElementType.METHOD) // Restricts the annotation to only be used within methods (suggested)
public @interface ToLog {
    
}
