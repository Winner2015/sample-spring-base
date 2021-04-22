package clf.winner.sample.spring.core.service.event;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class CustomAnnotationEventListener {

    @EventListener
    public void receiveEvent(CustomEvent customEvent) {
        System.out.println("CustomAnnotationEventListener receive CustomEvent");
    }
}
