package own.jadezhang.learning.dubboSample.enums;

/**
 * Created by Zhang Junwei on 2017/7/24.
 */
public enum TaskTypeEnum {

    STAT_DATA(1, "统计数据");

    /**
     * 由一个值和名称实例化对象
     *
     * @param value
     * @param name
     */
    private TaskTypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    private final int value;
    private final String name;

    /**
     * 取得枚举的值
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * 取得枚举的名称
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 根据枚举值获取对应的名称
     *
     * @param value
     * @return
     */
    public static String getNameByValue(int value) {
        TaskTypeEnum[] types = TaskTypeEnum.values();
        for (int i = 0; i < types.length; i++) {
            if (types[i].getValue() == value)
                return types[i].getName();
        }
        return "";
    }

    /**
     * 根据枚举值获取对应实例
     *
     * @param value
     * @return
     */
    public static TaskTypeEnum getInstanceByValue(int value) throws Exception {
        TaskTypeEnum[] types = TaskTypeEnum.values();
        for (int i = 0; i < types.length; i++) {
            if (types[i].getValue() == value)
                return types[i];
        }
        throw new Exception("无效的任务类型枚举值："+value);
    }
}
