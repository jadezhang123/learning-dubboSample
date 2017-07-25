package dubboSample.schedule;

import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by Zhang Junwei on 2017/7/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-test.xml"})
public class ScheduleStarter {
    @Autowired
    private TBScheduleManagerFactory scheduleManagerFactory;

    @Test
    public void start() throws Exception {
        scheduleManagerFactory.init();
        TimeUnit.DAYS.sleep(1);
    }
}
