package clf.winner.sample.spring.core.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HelloWorldService {

    private static final Log logger = LogFactory.getLog(HelloWorldService.class);

    private String name;

    public void sayHello(){
        logger.info("Hello ! " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
