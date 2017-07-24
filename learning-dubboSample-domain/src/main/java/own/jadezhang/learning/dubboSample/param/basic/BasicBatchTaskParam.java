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

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import own.jadezhang.base.common.param.CreateBaseParam;

/**
 * 《批处理任务》 查询参数实体
 * @author 张俊伟
 *
 */
public class BasicBatchTaskParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——任务代码
	*/
	public static final String F_Code="code";
	/**
	*字段常量——任务名称
	*/
	public static final String F_Name="name";
	/**
	*字段常量——任务类型
	*/
	public static final String F_TaskType="taskType";
	/**
	*字段常量——业务代码 对应业务表的code
	*/
	public static final String F_BizCode="bizCode";
	/**
	*字段常量——开始时间 任务开始处理时间，小于或等于当前时间的任务才开始处理
	*/
	public static final String F_StartTime="startTime";
	/**
	*字段常量——处理状态 0-待处理，1-处理中，2-处理成功，3-处理失败，4-取消处理
	*/
	public static final String F_DealStatus="dealStatus";
	/**
	*字段常量——处理时间
	*/
	public static final String F_DealTime="dealTime";
	/**
	*字段常量——处理描述
	*/
	public static final String F_DealDesc="dealDesc";
	/**
	*字段常量——执行次数
	*/
	public static final String F_ExeTimes="exeTimes";
	
	private String code; //任务代码
	private String name; //任务名称
	private Integer taskType; //任务类型
	private String bizCode; //业务代码 对应业务表的code
	private Long startTime; //开始时间 任务开始处理时间，小于或等于当前时间的任务才开始处理
	private Integer dealStatus; //处理状态 0-待处理，1-处理中，2-处理成功，3-处理失败，4-取消处理
	private Long dealTime; //处理时间
	private String dealDesc; //处理描述
	private Integer exeTimes; //执行次数
    
	/**
	 *默认空构造函数
	 */
	public BasicBatchTaskParam() {
		super();
	}
	 
	/**
	 * @return code 任务代码
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 任务代码
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return name 任务名称
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 任务名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return taskType 任务类型
	 */
	public Integer getTaskType(){
		return this.taskType;
	}
	/**
	 * @param taskType 任务类型
	 */
	public void setTaskType(Integer taskType){
		this.taskType = taskType;
	}
	/**
	 * @return bizCode 业务代码 对应业务表的code
	 */
	public String getBizCode(){
		return this.bizCode;
	}
	/**
	 * @param bizCode 业务代码 对应业务表的code
	 */
	public void setBizCode(String bizCode){
		this.bizCode = bizCode;
	}
	/**
	 * @return startTime 开始时间 任务开始处理时间，小于或等于当前时间的任务才开始处理
	 */
	public Long getStartTime(){
		return this.startTime;
	}
	/**
	 * @param startTime 开始时间 任务开始处理时间，小于或等于当前时间的任务才开始处理
	 */
	public void setStartTime(Long startTime){
		this.startTime = startTime;
	}
	/**
	 * @return dealStatus 处理状态 0-待处理，1-处理中，2-处理成功，3-处理失败，4-取消处理
	 */
	public Integer getDealStatus(){
		return this.dealStatus;
	}
	/**
	 * @param dealStatus 处理状态 0-待处理，1-处理中，2-处理成功，3-处理失败，4-取消处理
	 */
	public void setDealStatus(Integer dealStatus){
		this.dealStatus = dealStatus;
	}
	/**
	 * @return dealTime 处理时间
	 */
	public Long getDealTime(){
		return this.dealTime;
	}
	/**
	 * @param dealTime 处理时间
	 */
	public void setDealTime(Long dealTime){
		this.dealTime = dealTime;
	}
	/**
	 * @return dealDesc 处理描述
	 */
	public String getDealDesc(){
		return this.dealDesc;
	}
	/**
	 * @param dealDesc 处理描述
	 */
	public void setDealDesc(String dealDesc){
		this.dealDesc = dealDesc;
	}
	/**
	 * @return exeTimes 执行次数
	 */
	public Integer getExeTimes(){
		return this.exeTimes;
	}
	/**
	 * @param exeTimes 执行次数
	 */
	public void setExeTimes(Integer exeTimes){
		this.exeTimes = exeTimes;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("code",getCode())
			.append("name",getName())
			.append("taskType",getTaskType())
			.append("bizCode",getBizCode())
			.append("startTime",getStartTime())
			.append("dealStatus",getDealStatus())
			.append("dealTime",getDealTime())
			.append("dealDesc",getDealDesc())
			.append("exeTimes",getExeTimes())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
}
