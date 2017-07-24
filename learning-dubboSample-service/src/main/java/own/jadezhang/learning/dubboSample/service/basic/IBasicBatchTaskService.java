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

package own.jadezhang.learning.dubboSample.service.basic;

import own.jadezhang.base.common.dao.IBaseDAO;
import own.jadezhang.base.common.domain.BaseDomain;
import own.jadezhang.base.common.param.SqlOrderEnum;
import own.jadezhang.base.common.service.IBaseService;
import own.jadezhang.learning.dubboSample.domain.basic.BasicBatchTask;

import java.util.List;
import java.util.Map;

/**
 * 《批处理任务》 业务逻辑服务接口
 * @author 张俊伟
 */
public interface IBasicBatchTaskService<D extends IBaseDAO<T>, T extends BaseDomain> extends IBaseService<D, T> {

    List<BasicBatchTask> queryTaskPage(Map<String, Object> condition, String orderBy, SqlOrderEnum sortBy, Integer pageNo, Integer pageSize);

}