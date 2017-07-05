package own.jadezhang.learning.dubboSample.api.rpc.impl;


import org.springframework.beans.factory.annotation.Autowired;
import own.jadezhang.learning.dubboSample.api.dto.AuthUerDto;
import own.jadezhang.learning.dubboSample.api.rpc.IUserService4Rpc;
import own.jadezhang.learning.dubboSample.domain.auth.AuthUser;
import own.jadezhang.learning.dubboSample.param.auth.AuthUserParam;
import own.jadezhang.learning.dubboSample.service.auth.IAuthUserService;

/**
 * Created by Zhang Junwei on 2017/7/4.
 */
public class UserService4RpcImpl implements IUserService4Rpc {
    @Autowired
    private IAuthUserService authUserService;

    @Override
    public AuthUerDto findUser(String userCode) {
        AuthUerDto userDto = new AuthUerDto();
        AuthUser one = (AuthUser) authUserService.findOne(AuthUserParam.F_Code, userCode, null, null);
        if (one == null) {
            return null;
        }
        userDto.setCode(one.getCode());
        userDto.setName(one.getName());
        userDto.setPassword(one.getPassword());
        userDto.setPhone(one.getPhone());
        return userDto;
    }
}
