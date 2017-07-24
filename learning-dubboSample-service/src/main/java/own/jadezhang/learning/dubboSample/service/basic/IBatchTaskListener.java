package own.jadezhang.learning.dubboSample.service.basic;

import own.jadezhang.learning.dubboSample.common.ResultDto;
import own.jadezhang.learning.dubboSample.domain.basic.BasicBatchTask;
import own.jadezhang.learning.dubboSample.enums.TaskTypeEnum;

/**
 * Created by Zhang Junwei on 2017/7/22.
 */
public interface IBatchTaskListener {

    TaskTypeEnum getTaskType();

    boolean beforeDealTask(BasicBatchTask task);

    ResultDto dealTask(BasicBatchTask task);

    void afterDealTask(BasicBatchTask task);
}
