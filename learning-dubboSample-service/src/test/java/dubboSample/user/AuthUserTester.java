package dubboSample.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import own.jadezhang.base.common.utils.CommonUtil;
import own.jadezhang.learning.dubboSample.domain.auth.AuthUser;
import own.jadezhang.learning.dubboSample.domain.basic.BasicBatchTask;
import own.jadezhang.learning.dubboSample.enums.TaskDealStatusEnum;
import own.jadezhang.learning.dubboSample.enums.TaskTypeEnum;
import own.jadezhang.learning.dubboSample.service.auth.IAuthUserService;
import own.jadezhang.learning.dubboSample.service.basic.IBasicBatchTaskService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhang Junwei on 2017/5/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-service.xml")
public class AuthUserTester {
    @Autowired
    private IAuthUserService authUserService;
    @Autowired
    private IBasicBatchTaskService basicBatchTaskService;

    @Test
    public void testZK() throws Exception {
        List<AuthUser> all = authUserService.findAll();
        System.out.println(all.size());
    }

    @Test
    public void addTask() throws Exception {
        List<BasicBatchTask> tasks = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            BasicBatchTask basicBatchTask = new BasicBatchTask();
            basicBatchTask.setCode(CommonUtil.makeUUID());
            basicBatchTask.setName("syncTask" + i);
            basicBatchTask.setTaskType(TaskTypeEnum.STAT_DATA.getValue());
            basicBatchTask.setBizCode("");
            basicBatchTask.setStartTime(System.currentTimeMillis());
            basicBatchTask.setDealStatus(TaskDealStatusEnum.WAITING.getValue());
            basicBatchTask.setCreator("123");
            basicBatchTask.setLastModifier("123");
            basicBatchTask.setExeTimes(0);
            basicBatchTask.setStatus(0);

            tasks.add(basicBatchTask);
        }
        basicBatchTaskService.batchAdd(tasks);

    }
}
