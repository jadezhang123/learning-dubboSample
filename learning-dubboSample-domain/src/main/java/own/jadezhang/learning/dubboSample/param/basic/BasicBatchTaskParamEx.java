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

package own.jadezhang.learning.dubboSample.param.basic;

/**
 * 《批处理任务》 查询参数实体
 * @author 张俊伟
 *
 */
public class BasicBatchTaskParamEx extends BasicBatchTaskParam {
	private static final long serialVersionUID = 1L;
	
	//针对BasicBatchTaskParam实体在这里增加额外的属性和对应的get和set方法

	private int taskQueueNum;
	private String containIds;

	public int getTaskQueueNum() {
		return taskQueueNum;
	}

	public void setTaskQueueNum(int taskQueueNum) {
		this.taskQueueNum = taskQueueNum;
	}

	public String getContainIds() {
		return containIds;
	}

	public void setContainIds(String containIds) {
		this.containIds = containIds;
	}
}