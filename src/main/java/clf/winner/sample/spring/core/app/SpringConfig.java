package clf.winner.sample.spring.core.app;

import clf.winner.sample.spring.core.service.AnnotationConfigSample;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan(value = "clf.winner.sample.spring.core")
@Import({XmlConfig.class, PropertiesConfig.class})
public class SpringConfig {

    @Bean //等同于XML配置中的<bean/>
    public AnnotationConfigSample annotationConfigSample() {
        return new AnnotationConfigSample();
    }

}