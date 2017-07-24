package own.jadezhang.learning.dubboSample.enums;

/**
 * 任务处理状态枚举
 * Created by tengen on 2016/6/12.
 */
public enum TaskDealStatusEnum {

    /**
     * 待处理
     */
    WAITING(0,"待处理"),
    /**
     * 处理中
     */
    DEALING(1,"处理中"),
    /**
     * 处理成功
     */
    SUCCESS(2,"处理成功"),
    /**
     * 处理失败
     */
    FAILURE(3,"处理失败"),
    /**
     * 取消处理
     */
    CANCEL(4,"取消处理"),

    /**
     * 全部状态
     */
    ALL(5,"取消处理");

    /**
     * 由一个值和名称实例化对象
     * @param value
     * @param name
     */
    private TaskDealStatusEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    private final int value;
    private final String name;

    /**
     * 取得枚举的值
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * 取得枚举的名称
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 根据枚举值获取对应的名称
     * @param value
     * @return
     */
    public static String getNameByValue(int value){
        TaskDealStatusEnum[] types = TaskDealStatusEnum.values();
        for (int i = 0; i < types.length; i++) {
            if(types[i].getValue()==value)
                return types[i].getName();
        }
        return "";
    }
}
