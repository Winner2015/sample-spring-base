package clf.winner.sample.spring.core.test.base;

import clf.winner.sample.spring.core.app.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BaseJunitTest {
    @Test
    public void t() {

    }
}
