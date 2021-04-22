package clf.winner.sample.spring.core.dao;

import clf.winner.sample.spring.core.domain.StudentPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentDAO extends JdbcDaoSupport {

    @Autowired
    public StudentDAO(JdbcTemplate jdbcTemplate) {
        super.setJdbcTemplate(jdbcTemplate);
    }

    public StudentPO getById (long id) {
        String sql = "select * from Student where id = ?";
        RowMapper<StudentPO> rowMapper = new BeanPropertyRowMapper<>(StudentPO.class);
        return getJdbcTemplate().queryForObject(sql, rowMapper, id);
    }

    public void insert(long id) {
        String sql = "insert into Student values (" + id + ",'test', 98);";
        getJdbcTemplate().execute(sql);
    }

    @Transactional()
    public void transactionTest() {
        insert(2002L);
        int a = 1/0;
        insert(2003L);
    }


}
