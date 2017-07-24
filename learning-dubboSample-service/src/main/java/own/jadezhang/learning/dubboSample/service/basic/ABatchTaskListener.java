package own.jadezhang.learning.dubboSample.service.basic;

import own.jadezhang.learning.dubboSample.domain.basic.BasicBatchTask;

/**
 * Created by Zhang Junwei on 2017/7/24.
 */
public abstract class ABatchTaskListener implements IBatchTaskListener {
    @Override
    public boolean beforeDealTask(BasicBatchTask task) {
        return true;
    }

    @Override
    public void afterDealTask(BasicBatchTask task) {

    }
}
