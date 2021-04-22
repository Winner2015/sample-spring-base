package clf.winner.sample.spring.core.app;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources({
        @PropertySource("classpath:jdbc.properties")
})
public class PropertiesConfig {

}
