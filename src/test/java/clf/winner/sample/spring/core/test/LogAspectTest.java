package clf.winner.sample.spring.core.test;

import clf.winner.sample.spring.core.domain.UserDTO;
import clf.winner.sample.spring.core.service.LoginService;
import clf.winner.sample.spring.core.test.base.BaseJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LogAspectTest extends BaseJunitTest {

    @Autowired
    private LoginService loginService;

    @Test
    public void test() {
        UserDTO user = new UserDTO();
        user.setUserId(123456L);
        user.setUserName("Winner");

        loginService.login(user);
    }
}
