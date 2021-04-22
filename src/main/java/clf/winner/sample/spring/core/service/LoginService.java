package clf.winner.sample.spring.core.service;

import clf.winner.sample.spring.core.aop.Log;
import clf.winner.sample.spring.core.domain.UserDTO;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

    @Log(id = "#userDTO.userId", name = "#userDTO.userName")
    public void login(UserDTO userDTO) {
        System.out.println("user login: " + JSON.toJSONString(userDTO));
    }

}