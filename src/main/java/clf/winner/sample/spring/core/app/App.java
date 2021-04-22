package clf.winner.sample.spring.core.app;

import clf.winner.sample.spring.core.dao.StudentDAO;
import clf.winner.sample.spring.core.domain.UserDTO;
import clf.winner.sample.spring.core.service.HelloWorldService;
import clf.winner.sample.spring.core.service.LoginService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringConfig.class);
        context.refresh();

        HelloWorldService helloWorldService = (HelloWorldService) context.getBean("helloWorldService");
        helloWorldService.sayHello();

        UserDTO user = new UserDTO();
        user.setUserId(123456L);
        user.setUserName("Winner");

        LoginService loginService = (LoginService) context.getBean("loginService");
        loginService.login(user);


        StudentDAO studentDAO = (StudentDAO) context.getBean("studentDAO");
        studentDAO.transactionTest();

    }
}
