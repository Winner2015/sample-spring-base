package clf.winner.sample.spring.core.test;

import clf.winner.sample.spring.core.dao.StudentDAO;
import clf.winner.sample.spring.core.domain.StudentPO;
import clf.winner.sample.spring.core.test.base.BaseJunitTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class JDBCTest extends BaseJunitTest {

    @Autowired
    private DataSource dataSource;

    @Value("${jdbc.password}")
    private String password;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentDAO studentDao;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Test
    public void test() {
        Assert.assertNotNull(password);
        Assert.assertNotNull(dataSource);
        Assert.assertNotNull(jdbcTemplate);
        Assert.assertNotNull(transactionManager);
        Assert.assertNotNull(transactionTemplate);
    }

    @Test
    public void testJdbcTemplate() {

        List<Map<String, Object>> rows =  jdbcTemplate.queryForList("select * from Student");
        Assert.assertNotNull(rows);

        RowMapper<StudentPO> rowMapper = new BeanPropertyRowMapper<>(StudentPO.class);
        StudentPO po = jdbcTemplate.queryForObject("select * from Student where id = 1", rowMapper);
        Assert.assertNotNull(po);
    }

    @Test
    public void testJdbcDao() {
        StudentPO po = studentDao.getById(2);
        Assert.assertNotNull(po);
    }

    @Test
    public void testTransactionTemplate() {

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                studentDao.insert(1002L);
                int a = 1/0;
                studentDao.insert(1003L);
            }
        });

    }


    @Test
    public void testTransactionManager() {

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus transactionStatus = transactionManager.getTransaction(def);

        try {
            studentDao.insert(1004L);
//            int a = 1/0;
            studentDao.insert(1005L);
            transactionManager.commit(transactionStatus);

        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback(transactionStatus);
        }
    }

    @Test
    public void testTransactionAnnotation() {
        studentDao.transactionTest();
    }

}
