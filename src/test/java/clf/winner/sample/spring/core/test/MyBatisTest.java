package clf.winner.sample.spring.core.test;

import clf.winner.sample.spring.core.mapper.StudentMapper;
import clf.winner.sample.spring.core.pojo.StudentPO;
import clf.winner.sample.spring.core.test.base.BaseJunitTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBatisTest extends BaseJunitTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void test() {
        Assert.assertNotNull(studentMapper);
        StudentPO s = studentMapper.queryById(2);
        Assert.assertNotNull(s);
    }
}