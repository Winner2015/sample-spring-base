package clf.winner.sample.spring.core.test;

import clf.winner.sample.spring.core.service.BeanLifeCycleSample;
import clf.winner.sample.spring.core.test.base.BaseJunitTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BeanLifeCycleSampleTest extends BaseJunitTest {

    @Autowired
    private BeanLifeCycleSample beanLifeCycleSample;

    @Test
    public void test() {
        Assert.assertNotNull(beanLifeCycleSample);
    }
}
