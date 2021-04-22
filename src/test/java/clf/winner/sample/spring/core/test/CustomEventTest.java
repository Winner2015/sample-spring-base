package clf.winner.sample.spring.core.test;

import clf.winner.sample.spring.core.service.event.CustomEvent;
import clf.winner.sample.spring.core.service.event.CustomEventPublisher;
import clf.winner.sample.spring.core.test.base.BaseJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomEventTest extends BaseJunitTest {

    @Autowired
    private CustomEventPublisher customEventPublisher;

    @Test
    public void test() {
        customEventPublisher.publish(new CustomEvent(this, "hello"));
    }
}
