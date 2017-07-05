import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import own.jadezhang.learning.dubboSample.domain.auth.AuthUser;
import own.jadezhang.learning.dubboSample.service.auth.IAuthUserService;

import java.util.List;

/**
 * Created by Zhang Junwei on 2017/5/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-service.xml")
public class AuthUserTester {
    @Autowired
    private IAuthUserService authUserService;

    @Test
    public void testZK() throws Exception {
        List<AuthUser> all = authUserService.findAll();
        System.out.println(all.size());
    }
}
