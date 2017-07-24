/*
{*****************************************************************************
{  dubbo示例 v1.0													
{  版权信息 (c) 2005-2017 http://git.oschina.net/htengen
{  创建人：  张俊伟
{  审查人：
{  模块：批处理任务表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2017-07-22  张俊伟        新建	
{ 	                                                                     
{  ---------------------------------------------------------------------------
{  注：本模块代码由codgen代码生成工具辅助生成 http://www.oschina.net/p/codgen	
{*****************************************************************************	
*/
package own.jadezhang.learning.dubboSample.service.basic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import own.jadezhang.base.common.dao.IBaseDAO;
import own.jadezhang.base.common.param.SqlOrderEnum;
import own.jadezhang.base.common.service.impl.AbstractBaseService;
import own.jadezhang.learning.dubboSample.dao.basic.IBasicBatchTaskDAO;
import own.jadezhang.learning.dubboSample.domain.basic.BasicBatchTask;
import own.jadezhang.learning.dubboSample.service.basic.IBasicBatchTaskService;

import java.util.List;
import java.util.Map;

/**
 * 《批处理任务》 业务逻辑服务类
 * @author 张俊伟
 */
@Service("basicBatchTaskServiceImpl")
public class BasicBatchTaskServiceImpl extends AbstractBaseService<IBaseDAO<BasicBatchTask>, BasicBatchTask> implements IBasicBatchTaskService<IBaseDAO<BasicBatchTask>, BasicBatchTask> {
    @Autowired
    private IBasicBatchTaskDAO basicBatchTaskDAO;

    @Override
    public IBaseDAO<BasicBatchTask> getDao() {
        return basicBatchTaskDAO;
    }

    @Override
    public List<BasicBatchTask> queryTaskPage(Map<String, Object> condition, String orderBy, SqlOrderEnum sortBy, Integer pageNo, Integer pageSize) {
        if (sortBy == null) {
            sortBy = SqlOrderEnum.ASC;
        }
        return basicBatchTaskDAO.queryTaskPage(condition, orderBy, sortBy.getAction(), (pageNo - 1) * pageSize, pageSize);
    }
}