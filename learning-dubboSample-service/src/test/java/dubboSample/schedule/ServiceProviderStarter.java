package dubboSample.schedule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by Zhang Junwei on 2017/8/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/spring-proxy.xml"})
public class ServiceProviderStarter {
    @Test
    public void start() throws Exception {
        TimeUnit.DAYS.sleep(1);
    }
}
