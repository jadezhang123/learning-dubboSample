package own.jadezhang.learning.dubboSample.service.basic;

import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import own.jadezhang.base.common.param.SqlOrderEnum;
import own.jadezhang.learning.dubboSample.common.ResultDto;
import own.jadezhang.learning.dubboSample.domain.basic.BasicBatchTask;
import own.jadezhang.learning.dubboSample.enums.TaskDealStatusEnum;
import own.jadezhang.learning.dubboSample.param.basic.BasicBatchTaskParamEx;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Zhang Junwei on 2017/7/22.
 */
public class BatchTaskManager implements IScheduleTaskDealSingle<BasicBatchTask> {

    private static final Logger logger = LoggerFactory.getLogger(BatchTaskManager.class);

    private List<IBatchTaskListener> taskListeners;
    @Autowired
    private IBasicBatchTaskService basicBatchTaskService;

    /**
     * 执行单个任务
     * @param task    Object
     * @param ownSign 当前环境名称
     * @throws Exception
     */
    @Override
    public boolean execute(BasicBatchTask task, String ownSign) throws Exception {

        IBatchTaskListener taskListener = getTaskListener(task.getTaskType());

        //任务处理前如果返回值为false，则不往下执行，直接提前返回
        if (taskListener.beforeDealTask(task) == false) {
            return false;
        }

        long dealTime = System.currentTimeMillis();
        task.setDealTime(dealTime);
        int dealStatus = TaskDealStatusEnum.SUCCESS.getValue();
        boolean result = true;
        StringBuilder dealDescBuilder = new StringBuilder();
        try {
            ResultDto resultDTO = taskListener.dealTask(task);
            long spentTime = System.currentTimeMillis() - dealTime;
            dealDescBuilder.append("[").append(spentTime).append("]");
            if (resultDTO.isSuccess()) {
                dealDescBuilder.append("处理成功:");
            } else {
                dealStatus = TaskDealStatusEnum.FAILURE.getValue();
                dealDescBuilder.append("处理失败:");
            }
            dealDescBuilder.append(resultDTO.getMsg());
        } catch (Exception e) {
            logger.warn("deal schedule FAIL for {}", e.getMessage());
            dealStatus = TaskDealStatusEnum.FAILURE.getValue();
            dealDescBuilder.append("处理失败:").append(e.getCause());
            result = false;
        } finally {
            try {
                //更新任务状态
                String dealDesc = dealDescBuilder.toString();
                task.setDealStatus(dealStatus);
                if (dealDesc.length() > 500) {
                    dealDesc = StringUtils.substring(dealDesc, 0, 490) + "......";
                }
                task.setDealDesc(dealDesc);
                task.setDealTime(System.currentTimeMillis());
                basicBatchTaskService.update(task);
                taskListener.afterDealTask(task);
            } catch (Exception e) {
                logger.error("update schedule status error for {}", e.getMessage());
            }
            return result;
        }
    }

    private IBatchTaskListener getTaskListener(int taskType) {
        for (IBatchTaskListener taskListener : taskListeners) {
            if (taskType == taskListener.getTaskType().getValue()) {
                return taskListener;
            }
        }
        return null;
    }

    /**
     * 根据条件，查询当前调度服务器可处理的任务
     * @param taskParameter    任务的自定义参数
     * @param ownSign          当前环境名称
     * @param taskQueueNum     当前任务类型的任务队列数量
     * @param taskQueueList    当前调度服务器，分配到的可处理队列
     * @param eachFetchDataNum 每次获取数据的数量
     * @return
     * @throws Exception
     */
    public List<BasicBatchTask> selectTasks(String taskParameter, String ownSign, int taskQueueNum, List<TaskItemDefine> taskQueueList, int eachFetchDataNum) throws Exception {
        List<BasicBatchTask> basicBatchTaskList = new ArrayList<BasicBatchTask>();
        if (taskQueueList.size() == 0) {
            return basicBatchTaskList;
        }
        StringBuffer condition = new StringBuffer();
        for (int i = 0; i < taskQueueList.size(); i++) {
            if (i > 0) {
                condition.append(",");
            }
            condition.append(taskQueueList.get(i).getTaskItemId());
        }

        BasicBatchTaskParamEx basicBatchTaskParamEx = new BasicBatchTaskParamEx();
        basicBatchTaskParamEx.setDealStatus(TaskDealStatusEnum.WAITING.getValue());
        basicBatchTaskParamEx.setTaskQueueNum(taskQueueNum);
        basicBatchTaskParamEx.setContainIds(condition.toString());
        basicBatchTaskParamEx.setStartTime(System.currentTimeMillis());
        basicBatchTaskList = basicBatchTaskService.queryTaskPage(basicBatchTaskParamEx.toMap(), basicBatchTaskParamEx.F_ID, SqlOrderEnum.ASC, 1, eachFetchDataNum);
        return basicBatchTaskList;
    }

    @Override
    public Comparator<BasicBatchTask> getComparator() {
        return new Comparator<BasicBatchTask>() {
            @Override
            public int compare(BasicBatchTask o1, BasicBatchTask o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
    }

    public void setTaskListenerList(List<IBatchTaskListener> taskListeners) {
        this.taskListeners = taskListeners;
    }
}
