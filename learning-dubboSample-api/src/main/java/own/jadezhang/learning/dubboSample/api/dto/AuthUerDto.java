package own.jadezhang.learning.dubboSample.api.dto;

/**
 * Created by Zhang Junwei on 2017/7/4.
 */
public class AuthUerDto {
    private String code; //用户code
    private String name; //用户名
    private String password; //加密后的密码
    private String phone; //手机号
    private Integer state; //用户状态；0：活跃；1：锁定

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
