package clf.winner.sample.spring.core.test;

import clf.winner.sample.spring.core.service.AnnotationConfigSample;
import clf.winner.sample.spring.core.test.base.BaseJunitTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AnnotationConfigSampleTest extends BaseJunitTest {

    @Autowired
    private AnnotationConfigSample annotationConfigSample;

    @Test
    public void test() {
        Assert.assertNotNull(annotationConfigSample);
        annotationConfigSample.say();
    }
}
