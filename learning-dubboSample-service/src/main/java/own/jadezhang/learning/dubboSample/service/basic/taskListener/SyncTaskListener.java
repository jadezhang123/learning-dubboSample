package own.jadezhang.learning.dubboSample.service.basic.taskListener;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import own.jadezhang.base.common.utils.CommonUtil;
import own.jadezhang.learning.cumquat.zookeeper.curator.ZKClientFactory;
import own.jadezhang.learning.dubboSample.common.ResultDto;
import own.jadezhang.learning.dubboSample.domain.auth.AuthUser;
import own.jadezhang.learning.dubboSample.domain.basic.BasicBatchTask;
import own.jadezhang.learning.dubboSample.enums.TaskTypeEnum;
import own.jadezhang.learning.dubboSample.param.auth.AuthUserParam;
import own.jadezhang.learning.dubboSample.service.auth.IAuthUserService;
import own.jadezhang.learning.dubboSample.service.basic.ABatchTaskListener;

import java.util.concurrent.TimeUnit;

/**
 * Created by Zhang Junwei on 2017/7/25.
 */
public class SyncTaskListener extends ABatchTaskListener {

    private static final Logger logger = LoggerFactory.getLogger(SyncTaskListener.class);

    public static final String LOCK_PATH = "/startConfigs/learning/dubboSample/locks/syncTask";

    @Autowired
    private IAuthUserService authUserService;

    private final InterProcessMutex lock = new InterProcessMutex(ZKClientFactory.getClient(), LOCK_PATH);

    @Override
    public TaskTypeEnum getTaskType() {
        return TaskTypeEnum.STAT_DATA;
    }

    @Override
    public ResultDto dealTask(BasicBatchTask task) {
        try {
            lock.acquire();
            AuthUser jack = (AuthUser) authUserService.findOne(AuthUserParam.F_Name, "jack", null, null);
            TimeUnit.MILLISECONDS.sleep((long) (3 * Math.random()));
            if (jack == null) {
                jack = new AuthUser();
                jack.setCode(CommonUtil.makeUUID());
                jack.setName("jack");
                jack.setPassword("" + task.getId());
                jack.setSalt("salt");
                jack.setPhone("15671569029");
                jack.setState(0);
                authUserService.add(jack);
            } else {
                jack.setPassword(jack.getPassword() + "-" + task.getId());
                authUserService.update(jack);
            }
        } catch (Exception e) {
            return new ResultDto(false, e.getCause());
        } finally {
            try {
                lock.release();
                logger.info("release lock....");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResultDto(true, null);
    }
}
