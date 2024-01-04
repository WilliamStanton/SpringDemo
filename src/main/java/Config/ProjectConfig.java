package Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Project Config instructs Spring to add beans, etc.
 * 
 * @author Billy Stanton
 * @since 1/3/2024
 */
@Configuration // Instructs Spring that this is the configuration class
@ComponentScan(basePackages = {"Repository", "Services", "Aspects", "Proxies"}) // Instructs Spring where classes with Stereotype Annotations can be found (beans)
@EnableAspectJAutoProxy // Enables Aspect functionality (AOP)
public class ProjectConfig {
    
}
